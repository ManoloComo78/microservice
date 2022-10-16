package com.manolovizzini.demo.microservice.controller.user;

import com.manolovizzini.demo.microservice.domain.user.Role;
import com.manolovizzini.demo.microservice.dto.UserMapper;
import com.manolovizzini.demo.microservice.service.user.RoleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

/**
 * @author mviz - 13/10/2022
 * @version 1.0-SNAPSHOT
 * <p>
 */
@RestController
@RequestMapping("/roles")
public class RoleController {

    private final RoleService roleService;

    private final UserMapper userMapper;


    public RoleController(RoleService roleService, UserMapper userMapper) {
        this.roleService = roleService;
        this.userMapper = userMapper;
    }

    @RequestMapping("")
    public Page<Role> findAll(Pageable pageRequest) {
        return roleService.findAll(pageRequest);
    }





//    @DeleteMapping("/{id}")
//    public void delete(@PathVariable long id) {
//        roleService.deleteById(id);
//    }

    @PostMapping("")
    public ResponseEntity<Object> create(@RequestBody Role body) throws Exception {
        Role saved = roleService.save(body);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(saved.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<Object> update(@RequestBody Role body, @PathVariable long id) throws Exception {
//        Optional<Role> bodyOptional = roleService.findById(id);
//        if (!bodyOptional.isPresent()) {
//            return ResponseEntity.notFound().build();
//        }
//        body.setId(id);
//        body.setUpdateDate(LocalDateTime.now());
//        roleService.save(body);
//        return ResponseEntity.noContent().build();
//    }
}
