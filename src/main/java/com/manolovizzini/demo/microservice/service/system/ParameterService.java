package com.manolovizzini.demo.microservice.service.system;

import com.manolovizzini.demo.microservice.domain.system.Parameter;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * @author mviz - 13/10/2022
 * @version 1.0-SNAPSHOT
 * <p>
 */
public interface ParameterService {

    Parameter getById(Long id) throws Exception;

    Parameter save(Parameter parameter) throws Exception;

    Iterable<Parameter> findAll();

    Long count();

    Page<Parameter> findAll(Pageable pageRequest);

    void deleteById(long id);

    Optional<Parameter> findById(long id);

    Page<Parameter> findAll(Predicate predicate, Pageable pageable);
}
