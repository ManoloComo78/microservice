package com.manolovizzini.demo.microservice.domain;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * @author mviz - 13/10/2022
 * @version 1.0-SNAPSHOT
 * <p>
 */
@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntityActiveablePositionableEditable extends BaseEntity {

    @Column(nullable = false)
    private boolean active = true;

    @Column(nullable = false)
    private boolean eliminated = false;

    @Column(nullable = false)
    private int position = 1;

    @Column(nullable = false)
    private boolean editable = true;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof BaseEntityActiveablePositionableEditable)) return false;

        BaseEntityActiveablePositionableEditable that = (BaseEntityActiveablePositionableEditable) o;

        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(isActive(), that.isActive())
                .append(isEliminated(), that.isEliminated())
                .append(getPosition(), that.getPosition())
                .append(isEditable(), that.isEditable())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .appendSuper(super.hashCode())
                .append(isActive())
                .append(isEliminated())
                .append(getPosition())
                .append(isEditable())
                .toHashCode();
    }
}
