package com.manolovizzini.demo.microservice.dto;

import com.manolovizzini.demo.microservice.ApplicationMicroservice;
import com.manolovizzini.demo.microservice.domain.user.Role;
import com.manolovizzini.demo.microservice.domain.user.User;
import com.manolovizzini.demo.microservice.dto.user.RoleDTO;
import com.manolovizzini.demo.microservice.dto.user.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
            @Mapping(expression = "java(user.getRoles().iterator().next().getName())", target = "roleName"),
            @Mapping(expression = "java(getStringDate(user))", target = "lastAccess")
    })
    UserDTO userToUserDTO(User user);

    RoleDTO roleToRoleDTO(Role role);

    default String getStringDate(User user) {
        LocalDateTime date = user.getAccesses().iterator().next().getDateTime();
        return date != null ? DateTimeFormatter.ofPattern(ApplicationMicroservice.dateLocalePattern).format(date) : null;
    }
}
