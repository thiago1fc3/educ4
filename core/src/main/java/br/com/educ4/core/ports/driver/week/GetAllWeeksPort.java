package br.com.educ4.core.ports.driver.week;

import java.util.List;

public interface GetAllWeeksPort {

    <T> List<T> execute(Class<T> projection);

}
