package br.com.educ4.core.utils;

import org.modelmapper.ModelMapper;

import static org.modelmapper.Conditions.isNotNull;
import static org.modelmapper.convention.MatchingStrategies.STRICT;

public class MapperConfig {

    private final static ModelMapper mapper;

    private MapperConfig() {
    }

    static {
        mapper = new ModelMapper();
        mapper.getConfiguration().setPropertyCondition(isNotNull()).setMatchingStrategy(STRICT);
    }

    public static ModelMapper getMapper() {
        return mapper;
    }
}
