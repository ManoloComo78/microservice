package com.manolovizzini.demo.microservice.dao.user;

import com.manolovizzini.demo.microservice.dao.BaseEntityPositionableEditableRepository;
import com.manolovizzini.demo.microservice.domain.user.Role;
import com.manolovizzini.demo.microservice.domain.user.RoleName;

import java.util.Optional;

/**
 * @author mviz - 16/10/2022
 * @version 1.0-SNAPSHOT
 */
public interface RoleRepository extends BaseEntityPositionableEditableRepository<Role> {

    Optional<Role> findByName(RoleName roleName);
}
