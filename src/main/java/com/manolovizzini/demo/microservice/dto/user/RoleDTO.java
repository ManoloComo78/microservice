package com.manolovizzini.demo.microservice.dto.user;

import com.manolovizzini.demo.microservice.domain.user.RoleName;
import lombok.Getter;
import lombok.Setter;

/**
 * @author mviz - 15/10/2022
 * @version 1.0-SNAPSHOT
 */
@Getter
@Setter
public class RoleDTO {
    private RoleName name;
    private int level;


}
