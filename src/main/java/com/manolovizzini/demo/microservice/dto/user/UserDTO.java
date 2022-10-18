package com.manolovizzini.demo.microservice.dto.user;

import com.manolovizzini.demo.microservice.dto.BaseDTOActiveablePositionableEditable;
import lombok.Getter;
import lombok.Setter;

/**
 * @author mviz - 15/10/2022
 * @version 1.0-SNAPSHOT
 */
@Getter
@Setter
public class UserDTO extends BaseDTOActiveablePositionableEditable {
    private String username;
    private String firstname;
    private String lastname;
    private String nationality;
    private String roles;
    private String lastAccess;
    private String birthdate;
}
