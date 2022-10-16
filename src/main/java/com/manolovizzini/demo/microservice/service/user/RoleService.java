package com.manolovizzini.demo.microservice.service.user;

import com.manolovizzini.demo.microservice.domain.user.Role;
import com.manolovizzini.demo.microservice.domain.user.RoleName;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * @author mviz - 13/10/2022
 * @version 1.0-SNAPSHOT
 * <p>
 */
public interface RoleService {

    Optional<Role> findByName(RoleName roleName);

    Role save(Role role);

    Page<Role> findAll(Pageable pageable);
}