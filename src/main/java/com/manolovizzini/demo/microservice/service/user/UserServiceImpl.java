package com.manolovizzini.demo.microservice.service.user;

import com.manolovizzini.demo.microservice.dao.user.UserRepository;
import com.manolovizzini.demo.microservice.domain.user.User;
import com.manolovizzini.demo.microservice.exceptions.NotFoundException;
import com.manolovizzini.demo.microservice.service.CommonServiceImpl;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author mviz - 13/10/2022
 * @version 1.0-SNAPSHOT
 * <p>
 */
@Service
public class UserServiceImpl extends CommonServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) throws Exception {
        return userRepository.save(user);
    }

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(Long id) throws Exception {
        return userRepository.findById(id).orElseThrow(() -> new NotFoundException(HttpStatus.NOT_FOUND, "User Not Found with id -> " + id));
    }

    @Override
    public User getByUsername(String username) throws Exception {
        String finalUsername = username;
        return userRepository.findByUsername(username).orElseThrow(() -> new NotFoundException(HttpStatus.NOT_FOUND, "User Not Found with username -> " + finalUsername));
    }

    @Override
    public User getByNationality(String nationality) throws Exception {
        String finalNationality = nationality;
        return userRepository.findByNationality(nationality).orElseThrow(() -> new NotFoundException(HttpStatus.NOT_FOUND, "User Not Found with nationality -> " + finalNationality));
    }

    @Override
    public Long count() {
        return userRepository.count();
    }

    @Override
    public Page<User> findAll(Pageable pageRequest) {
        return userRepository.findAll(pageRequest);
    }

    @Override
    public void deleteById(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<User> findById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> findByUsername(String userEmail) {
        return userRepository.findByUsername(userEmail);
    }

    @Override
    public Page<User> findAll(Predicate predicate, Pageable pageable) {
        return userRepository.findAll(predicate, pageable);
    }
}
