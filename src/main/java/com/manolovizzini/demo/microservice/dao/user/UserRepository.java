package com.manolovizzini.demo.microservice.dao.user;

import com.manolovizzini.demo.microservice.dao.BaseEntityPositionableEditableRepository;
import com.manolovizzini.demo.microservice.domain.user.User;

import java.util.Optional;

/**
 * @author mviz - 13/10/2022
 * @version 1.0-SNAPSHOT
 * <p>
 */
public interface UserRepository extends BaseEntityPositionableEditableRepository<User> {

    Optional<User> findByUsername(String username);
    Optional<User> findByCountry(String country);
}
