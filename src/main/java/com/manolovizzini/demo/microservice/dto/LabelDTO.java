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
public class LabelDTO extends IdDTO {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String label;

    public LabelDTO(){
        super();
    }

    public LabelDTO(Long id, String label) {
        super(id);
        this.label = label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (!(o instanceof LabelDTO))
            return false;

        LabelDTO that = (LabelDTO) o;

        return new EqualsBuilder().appendSuper(super.equals(o)).append(getLabel(), that.getLabel()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).appendSuper(super.hashCode()).append(getLabel()).toHashCode();
    }
}
