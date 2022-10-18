package com.manolovizzini.demo.microservice.dto.user;

import com.manolovizzini.demo.microservice.ApplicationMicroservice;
import com.manolovizzini.demo.microservice.domain.user.Role;
import com.manolovizzini.demo.microservice.domain.user.RoleName;
import com.manolovizzini.demo.microservice.domain.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author mviz - 15/10/2022
 * @version 1.0-SNAPSHOT
 */
@Mapper(
        componentModel = "spring"
)
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mappings({
            @Mapping(expression = "java(getRoles(user))", target = "roles"),
            @Mapping(expression = "java(getBirthdateInString(user))", target = "birthdate"),
            @Mapping(expression = "java(getLastAccessInString(user))", target = "lastAccess")
    })
    UserDTO userToUserDTO(User user);

    Iterable<UserDTO> usersToUserDTOs(Iterable<User> users);

    default String getLastAccessInString(User user) {
        LocalDateTime date = user.getAccesses().iterator().next().getDateTime();
        return date != null ? DateTimeFormatter.ofPattern(ApplicationMicroservice.dateTimeLocalePattern).format(date) : null;
    }

    default String getBirthdateInString(User user) {
        LocalDate date = user.getBirthdate();
        return date != null ? DateTimeFormatter.ofPattern(ApplicationMicroservice.dateLocalePattern).format(date) : null;
    }

    default String getRoles(User user) {
        List<String> roles = new ArrayList<>();
        for (Role role : user.getRoles()) {
            roles.add(String.valueOf(role.getName()));
        }
        return roles.toString().replaceAll("\\[(.*?)\\]", "$1");
    }
}
