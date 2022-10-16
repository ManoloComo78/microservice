package com.manolovizzini.demo.microservice.dto;

import com.manolovizzini.demo.microservice.domain.user.User;
import com.manolovizzini.demo.microservice.dto.user.UserDTO;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserMapperUnitTest {

    @Test
    public void givenUserEntitytoUser_whenMaps_thenCorrect() {
        User entity  = new User();
        entity.setId(1L);
        entity.setUsername("Pippo");

        UserDTO userDto = UserMapper.INSTANCE.userToUserDTO(entity);

        assertEquals(userDto.getId(), entity.getId());
        assertEquals(userDto.getUsername(), entity.getUsername());
    }
}
