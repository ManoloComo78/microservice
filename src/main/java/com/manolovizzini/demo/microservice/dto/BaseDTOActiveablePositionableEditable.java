package com.manolovizzini.demo.microservice.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author mviz - 13/10/2022
 * @version 1.0-SNAPSHOT
 * <p>
 */
@Getter
@Setter
public abstract class BaseDTOActiveablePositionableEditable extends BaseDTO {

    private boolean active;

    private boolean eliminated;

    private int position;

    private boolean editable;


}
