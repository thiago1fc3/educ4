package br.com.educ4.repository.professor;

import br.com.educ4.core.ports.driven.repository.professor.FindProfessorBySchoolIdRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;
import static org.springframework.data.mongodb.core.aggregation.LookupOperation.newLookup;
import static org.springframework.data.mongodb.core.query.Criteria.where;

@Named
@RequiredArgsConstructor
public class FindProfessorBySchoolIdRepository implements FindProfessorBySchoolIdRepositoryPort {

    private final MongoTemplate database;
    private static final String DOCUMENT_NAME = "professor";

    public <T> List<T> findBySchoolId(ObjectId schoolId, Class<T> projection) {

        var operations = new ArrayList<AggregationOperation>();

        operations.add(match(where("schoolId").is(schoolId)));

        operations.add(
                newLookup().from("user").localField("userId").foreignField("_id").as("user")
        );

        operations.add(unwind("user"));

        operations.add(
                project(projection)
                        .and("user.name").as("name")
                        .and("user.picture").as("picture")
                        .and("user.username").as("email")
        );

        var aggregation = Aggregation.newAggregation(operations);

        return database.aggregate(aggregation, DOCUMENT_NAME, projection).getMappedResults();
    }

}
