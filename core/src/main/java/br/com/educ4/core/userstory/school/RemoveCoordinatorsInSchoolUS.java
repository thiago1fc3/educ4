package br.com.educ4.core.userstory.school;

import br.com.educ4.core.domain.School;
import br.com.educ4.core.ports.driven.repository.school.SchoolRepositoryPort;
import br.com.educ4.core.ports.driver.school.RemoveCoordinatorsToSchoolPort;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;

import javax.inject.Named;
import java.util.Set;

@Named
@RequiredArgsConstructor
public class RemoveCoordinatorsInSchoolUS implements RemoveCoordinatorsToSchoolPort {

    private final FindSchoolByIdUS findSchoolByIdlUS;
    private final SchoolRepositoryPort repository;

    @Override
    public School execute(String schoolId, Set<ObjectId> coordinatorsIds) {
        var dbSchool = findSchoolByIdlUS.execute(schoolId, School.class);
        dbSchool.removeCoordinators(coordinatorsIds);
        return repository.save(dbSchool);
    }
}
