package com.manolovizzini.demo.microservice.dao;

import com.manolovizzini.demo.microservice.domain.BaseEntityActiveablePositionableEditable;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

/**
 * @author mviz - 13/10/2022
 * @version 1.0-SNAPSHOT
 * <p>
 */
@NoRepositoryBean
public interface BaseEntityPositionableEditableRepository<T extends BaseEntityActiveablePositionableEditable> extends BaseEntityRepository<T> {

    Optional<T> findByActive(boolean active);

    Optional<T> findByEliminated(boolean eliminated);

    Optional<T> findByPosition(int position);

    Optional<T> findByEditable(boolean editable);
}
