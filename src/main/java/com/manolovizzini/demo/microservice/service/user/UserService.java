package com.manolovizzini.demo.microservice.service.user;

import com.manolovizzini.demo.microservice.domain.user.User;
import com.manolovizzini.demo.microservice.dto.user.UserDTO;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * @author mviz - 13/10/2022
 * @version 1.0-SNAPSHOT
 * <p>
 */
public interface UserService {

    User getById(Long id) throws Exception;

    User getByUsername(String username) throws Exception;

    User getByNationality(String nationality) throws Exception;

    User save(User user) throws Exception;

    Iterable<User> findAll();

    Iterable<User> reload(String languageCode, int counter);

    Long count();

    Page<User> findAll(Pageable pageRequest);

    void deleteById(long id);

    Optional<User> findById(long id);

    Optional<User> findByUsername(String userEmail);

    Page<User> findAll(Predicate predicate, Pageable pageable);
}
