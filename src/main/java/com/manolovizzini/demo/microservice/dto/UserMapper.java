package com.manolovizzini.demo.microservice.dto;

import com.manolovizzini.demo.microservice.domain.user.Role;
import com.manolovizzini.demo.microservice.domain.user.User;
import com.manolovizzini.demo.microservice.dto.user.RoleDTO;
import com.manolovizzini.demo.microservice.dto.user.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

/**
 * @author mviz - 15/10/2022
 * @version 1.0-SNAPSHOT
 */
@Mapper(
        componentModel = "spring"
)
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO userToUserDTO(User user);
//    Page<UserDTO> usersToUserDTO(Page<User> users);
//    User userDTOToUser(UserDTO userDTO);

    RoleDTO roleToRoleDTO(Role role);



}
