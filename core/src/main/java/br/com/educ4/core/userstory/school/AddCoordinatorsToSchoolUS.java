package br.com.educ4.core.userstory.school;

import br.com.educ4.core.domain.School;
import br.com.educ4.core.ports.driven.repository.school.SchoolRepositoryPort;
import br.com.educ4.core.ports.driver.school.AddCoordinatorsToSchoolPort;
import br.com.educ4.core.ports.driver.school.PatchSchoolPort;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;

import java.util.Set;

import static br.com.educ4.core.utils.MapperConfig.getMapper;

@Named
@RequiredArgsConstructor
public class AddCoordinatorsToSchoolUS implements AddCoordinatorsToSchoolPort {

    private final FindSchoolByIdUS findSchoolByIdlUS;
    private final SchoolRepositoryPort repository;

    @Override
    public School execute(String schoolId, Set<String> coordinatorsIds) {
        var dbSchool = findSchoolByIdlUS.execute(schoolId);
        dbSchool.addCoordinators(coordinatorsIds);
        return repository.save(dbSchool);
    }
}
