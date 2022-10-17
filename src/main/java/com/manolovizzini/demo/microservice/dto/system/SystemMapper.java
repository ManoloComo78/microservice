package com.manolovizzini.demo.microservice.dto.system;

import com.manolovizzini.demo.microservice.domain.system.Parameter;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author mviz - 15/10/2022
 * @version 1.0-SNAPSHOT
 */
@Mapper(
        componentModel = "spring"
)
public interface SystemMapper {
    SystemMapper INSTANCE = Mappers.getMapper(SystemMapper.class);

    ParameterDTO parameterToParameterDTO(Parameter parameter);

    Iterable<ParameterDTO> parametersToParameterDTOs(Iterable<Parameter> parameters);
}
