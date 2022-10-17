package com.manolovizzini.demo.microservice.controller.system;


import com.manolovizzini.demo.microservice.domain.system.Parameter;
import com.manolovizzini.demo.microservice.dto.system.ParameterDTO;
import com.manolovizzini.demo.microservice.dto.system.SystemMapper;
import com.manolovizzini.demo.microservice.service.system.ParameterService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
@RequestMapping("/parameters")
public class ParameterController {

    private final ParameterService parameterService;

    private final SystemMapper systemMapper;

    public ParameterController(ParameterService parameterService, SystemMapper systemMapper) {
        this.parameterService = parameterService;
        this.systemMapper = systemMapper;
    }

    @RequestMapping("")
    public Page<ParameterDTO> findAll(Pageable pageRequest) {
        return parameterService.findAll(pageRequest).map(systemMapper::parameterToParameterDTO);
    }

    @GetMapping("/{id}")
    public ParameterDTO retrieveById(@PathVariable long id) throws Exception {
        return systemMapper.parameterToParameterDTO(parameterService.getById(id));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        parameterService.deleteById(id);
    }

    @PostMapping("")
    public ResponseEntity<Object> create(@RequestBody Parameter body) throws Exception {
        Parameter saved = parameterService.save(body);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(saved.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@RequestBody Parameter body, @PathVariable long id) throws Exception {
        Optional<Parameter> bodyOptional = parameterService.findById(id);
        if (!bodyOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        body.setId(id);
        body.setUpdateDate(LocalDateTime.now());
        parameterService.save(body);
        return ResponseEntity.noContent().build();
    }

//    @GetMapping(value = "/search")
//    public Page<ParameterDTO> search(@QuerydslPredicate(root = Parameter.class) Predicate predicate, Pageable pageable) {
//        return parameterService.findAll(predicate, pageable).map(systemMapper::parameterToParameterDTO);
//    }
}
