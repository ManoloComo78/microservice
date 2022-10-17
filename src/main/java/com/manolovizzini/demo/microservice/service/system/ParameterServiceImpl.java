package com.manolovizzini.demo.microservice.service.system;

import com.manolovizzini.demo.microservice.dao.system.ParameterRepository;
import com.manolovizzini.demo.microservice.domain.system.Parameter;
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
public class ParameterServiceImpl extends CommonServiceImpl implements ParameterService {

    private final ParameterRepository parameterRepository;

    public ParameterServiceImpl(ParameterRepository parameterRepository) {
        this.parameterRepository = parameterRepository;
    }

    @Override
    public Parameter save(Parameter parameter) throws Exception {
        return parameterRepository.save(parameter);
    }

    @Override
    public Iterable<Parameter> findAll() {
        return parameterRepository.findAll();
    }

    @Override
    public Parameter getById(Long id) throws Exception {
        return parameterRepository.findById(id).orElseThrow(() -> new NotFoundException(HttpStatus.NOT_FOUND, "Parameter Not Found with id -> " + id));
    }

    @Override
    public Long count() {
        return parameterRepository.count();
    }

    @Override
    public Page<Parameter> findAll(Pageable pageRequest) {
        return parameterRepository.findAll(pageRequest);
    }

    @Override
    public void deleteById(long id) {
        parameterRepository.deleteById(id);
    }

    @Override
    public Optional<Parameter> findById(long id) {
        return parameterRepository.findById(id);
    }

    @Override
    public Page<Parameter> findAll(Predicate predicate, Pageable pageable) {
        return parameterRepository.findAll(predicate, pageable);
    }
}
