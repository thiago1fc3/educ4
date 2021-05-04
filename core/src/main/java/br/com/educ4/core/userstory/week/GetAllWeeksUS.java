package br.com.educ4.core.userstory.week;

import br.com.educ4.core.ports.driven.repository.week.WeekRepositoryPort;
import br.com.educ4.core.ports.driver.week.GetAllWeeksPort;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;
import java.util.List;

@Named
@RequiredArgsConstructor
public class GetAllWeeksUS implements GetAllWeeksPort {

    private final WeekRepositoryPort repository;

    @Override
    public <T> List<T> execute(Class<T> projection) {
        return repository.findBy(projection);
    }
}
