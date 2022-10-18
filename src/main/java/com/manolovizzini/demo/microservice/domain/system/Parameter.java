package com.manolovizzini.demo.microservice.domain.system;

import com.manolovizzini.demo.microservice.domain.BaseEntityActiveablePositionableEditable;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;

/**
 * @author mviz - 17/10/2022
 * @version 1.0-SNAPSHOT
 */
@Entity
@Table(name = "t_parameter")
@Getter
@Setter
public class Parameter  extends BaseEntityActiveablePositionableEditable {

    @Column(unique = true, nullable = false)
    private String languageCode;

    @Column(nullable = false)
    private int counter = 5;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Parameter)) return false;

        Parameter parameter = (Parameter) o;

        return new EqualsBuilder().appendSuper(super.equals(o)).append(getCounter(), parameter.getCounter()).append(getLanguageCode(), parameter.getLanguageCode()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).appendSuper(super.hashCode()).append(getLanguageCode()).append(getCounter()).toHashCode();
    }
}
