package com.manolovizzini.demo.microservice.service;

import com.manolovizzini.demo.microservice.domain.user.User;
import com.manolovizzini.demo.microservice.dto.user.UserDTO;


/**
 * @author mviz - 13/10/2022
 * @version 1.0-SNAPSHOT
 * <p>
 */
public interface DtoConverterService {

   UserDTO convertToUserDTO(User user);

}
