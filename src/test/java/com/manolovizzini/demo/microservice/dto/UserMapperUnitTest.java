package com.manolovizzini.demo.microservice.dto;

import com.manolovizzini.demo.microservice.ApplicationMicroservice;
import com.manolovizzini.demo.microservice.domain.user.Access;
import com.manolovizzini.demo.microservice.domain.user.Role;
import com.manolovizzini.demo.microservice.domain.user.RoleName;
import com.manolovizzini.demo.microservice.domain.user.User;
import com.manolovizzini.demo.microservice.dto.user.UserDTO;
import com.manolovizzini.demo.microservice.dto.user.UserMapper;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.assertEquals;

public class UserMapperUnitTest {

    @Test
    public void givenUserEntitytoUser_whenMaps_thenCorrect() {
        Access access = new Access(LocalDateTime.of(2017, 2, 13, 15, 56), "0.0.0.0");
        LocalDate birthdate = LocalDate.of(1978, 11, 15);

        Role roleAdmin = new Role();
        roleAdmin.setName(RoleName.ROLE_ADMIN);
        roleAdmin.setLevel(1);

        User user = new User();
        user.setId(1L);
        user.setUsername("Pippo");
        user.getRoles().add(roleAdmin);
        user.getAccesses().add(access);
        user.setBirthdate(birthdate);


        UserDTO userDto = UserMapper.INSTANCE.userToUserDTO(user);
        String accessFormatted =  DateTimeFormatter.ofPattern(ApplicationMicroservice.dateTimeLocalePattern).format(user.getAccesses().iterator().next().getDateTime());
        String birthdateFormatted =  DateTimeFormatter.ofPattern(ApplicationMicroservice.dateLocalePattern).format(user.getBirthdate());

        assertEquals(userDto.getId(), user.getId());
        assertEquals(userDto.getUsername(), user.getUsername());
        assertEquals(userDto.getRoleName(), user.getRoles().iterator().next().getName());
        assertEquals(userDto.getLastAccess(), accessFormatted);
        assertEquals(userDto.getBirthdate(), birthdateFormatted);
    }
}
