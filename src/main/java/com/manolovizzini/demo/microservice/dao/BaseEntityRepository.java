package com.manolovizzini.demo.microservice.dao;

import com.manolovizzini.demo.microservice.domain.BaseEntity;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author mviz - 13/10/2022
 * @version 1.0-SNAPSHOT
 * <p>
 */
@NoRepositoryBean
public interface BaseEntityRepository<T extends BaseEntity> extends PagingAndSortingRepository<T, Long>, QuerydslPredicateExecutor<T> {

}
