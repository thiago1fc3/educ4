package br.com.educ4.core.ports.driven.repository.school;

import br.com.educ4.core.domain.School;

import java.util.List;

public interface ListAllSchoolsRepositoryPort {

    List<School> execute();

}
