package br.com.educ4.core.ports.driven.repository.weeks;

import br.com.educ4.core.domain.Week;

import java.util.Optional;

public interface WeekRepositoryPort {

    Week save(Week week);

    <T> Optional<T> findById(String id, Class<T> projection);

}
