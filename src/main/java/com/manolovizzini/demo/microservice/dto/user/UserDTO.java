package com.manolovizzini.demo.microservice.dto.user;

import com.manolovizzini.demo.microservice.dto.LabelDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * @author mviz - 15/10/2022
 * @version 1.0-SNAPSHOT
 */
@Getter
@Setter
public class UserDTO extends LabelDTO {
    public UserDTO(Long id, String label) {
        super(id, label);
    }
}
