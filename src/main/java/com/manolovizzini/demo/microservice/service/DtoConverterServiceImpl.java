package com.manolovizzini.demo.microservice.service;

import com.manolovizzini.demo.microservice.domain.user.User;
import com.manolovizzini.demo.microservice.dto.user.UserDTO;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author mviz - 13/10/2022
 * @version 1.0-SNAPSHOT
 * <p>
 */
@Service
@AllArgsConstructor
public class DtoConverterServiceImpl implements DtoConverterService {

    private final Logger logger = LoggerFactory.getLogger(DtoConverterServiceImpl.class);

    @Override
    public UserDTO convertToUserDTO(User user) {
        String label = user.getFirstname() + " " + user.getLastname();
        return new UserDTO(user.getId(), label);
    }
}
