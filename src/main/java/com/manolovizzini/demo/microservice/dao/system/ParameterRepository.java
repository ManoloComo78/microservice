package com.manolovizzini.demo.microservice.dao.system;

import com.manolovizzini.demo.microservice.dao.BaseEntityPositionableEditableRepository;
import com.manolovizzini.demo.microservice.domain.system.Parameter;

import java.util.Optional;

/**
 * @author mviz - 13/10/2022
 * @version 1.0-SNAPSHOT
 * <p>
 */
public interface ParameterRepository extends BaseEntityPositionableEditableRepository<Parameter> {

    Optional<Parameter> findByLanguageCode(String languageCode);
    Optional<Parameter> findByCounter(int counter);
}
