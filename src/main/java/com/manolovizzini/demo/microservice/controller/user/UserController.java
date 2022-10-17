package com.manolovizzini.demo.microservice.controller.user;

import com.manolovizzini.demo.microservice.domain.user.User;
import com.manolovizzini.demo.microservice.dto.UserMapper;
import com.manolovizzini.demo.microservice.dto.user.UserDTO;
import com.manolovizzini.demo.microservice.service.user.UserService;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.Optional;

/**
 * @author mviz - 13/10/2022
 * @version 1.0-SNAPSHOT
 * <p>
 */
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @RequestMapping("")
    public Page<UserDTO> findAll(Pageable pageRequest) {
        return userService.findAll(pageRequest).map(userMapper::userToUserDTO);
    }

    @GetMapping("/{id}")
    public UserDTO retrieveById(@PathVariable long id) throws Exception {
        return userMapper.userToUserDTO(userService.getById(id));
    }

    @GetMapping("/username/{username}")
    public UserDTO retrieveByUsername(@PathVariable String username) throws Exception {
        return userMapper.userToUserDTO(userService.getByUsername(username));
    }

    @GetMapping("/nationality/{nationality}")
    public UserDTO retrieveByNationality(@PathVariable String nationality) throws Exception {
        return userMapper.userToUserDTO(userService.getByNationality(nationality));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        userService.deleteById(id);
    }

    @PostMapping("")
    public ResponseEntity<Object> create(@RequestBody User body) throws Exception {
        User saved = userService.save(body);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(saved.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@RequestBody User body, @PathVariable long id) throws Exception {
        Optional<User> bodyOptional = userService.findById(id);
        if (!bodyOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        body.setId(id);
        body.setUpdateDate(LocalDateTime.now());
        userService.save(body);
        return ResponseEntity.noContent().build();
    }

//    @GetMapping(value = "/search")
//    public Page<UserDTO> search(@QuerydslPredicate(root = User.class) Predicate predicate, Pageable pageable) {
//        return userService.findAll(predicate, pageable).map(userMapper::userToUserDTO);
//    }
}
