package br.com.educ4.core.ports.driver.school;

import org.bson.types.ObjectId;

import java.util.List;

public interface GetSchoolsByInstitutionIdPort {

    <T> List<T> execute(ObjectId institutionId, Class<T> projection);

}
