package com.manolovizzini.demo.microservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author mviz - 13/10/2022
 * @version 1.0-SNAPSHOT
 * <p>
 */
@Getter
@Setter
public class IdDTO extends BaseDTO {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long id;

    public IdDTO(){

    }

    public IdDTO(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (!(o instanceof IdDTO))
            return false;

        IdDTO idDTO = (IdDTO) o;

        return new EqualsBuilder().appendSuper(super.equals(o)).append(getId(), idDTO.getId()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).appendSuper(super.hashCode()).append(getId()).toHashCode();
    }
}
