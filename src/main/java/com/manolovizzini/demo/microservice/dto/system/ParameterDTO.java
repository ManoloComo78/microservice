package com.manolovizzini.demo.microservice.dto.system;

import com.manolovizzini.demo.microservice.dto.BaseDTOActiveablePositionableEditable;
import lombok.Getter;
import lombok.Setter;

/**
 * @author mviz - 15/10/2022
 * @version 1.0-SNAPSHOT
 */
@Getter
@Setter
public class ParameterDTO extends BaseDTOActiveablePositionableEditable {
    private String languageTag;
    private int counter;
}
