package com.manolovizzini.demo.microservice.dto;

import com.manolovizzini.demo.microservice.domain.system.Parameter;
import com.manolovizzini.demo.microservice.dto.system.ParameterDTO;
import com.manolovizzini.demo.microservice.dto.system.SystemMapper;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SystemMapperUnitTest {

    @Test
    public void givenParameterEntitytoParameter_whenMaps_thenCorrect() {

        Parameter parameter = new Parameter();
        parameter.setId(1L);
        parameter.setLanguageCode("it-IT");
        parameter.setCounter(110);

        ParameterDTO parameterDto = SystemMapper.INSTANCE.parameterToParameterDTO(parameter);

        assertEquals(parameterDto.getId(), parameter.getId());
        assertEquals(parameterDto.getLanguageCode(), parameter.getLanguageCode());
        assertEquals(parameterDto.getCounter(), parameter.getCounter());
    }
}
