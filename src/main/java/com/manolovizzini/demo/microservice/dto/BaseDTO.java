package com.manolovizzini.demo.microservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author mviz - 13/10/2022
 * @version 1.0-SNAPSHOT
 * <p>
 */
@Getter
@Setter
public abstract class BaseDTO implements Serializable, StaticDTO {

}
