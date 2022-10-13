package com.manolovizzini.demo.microservice.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author mviz - 13/10/2022
 * @version 1.0-SNAPSHOT
 * <p>
 */
@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity {

    private Long id;

    private Long version;

    @JsonIgnore
    @Column(nullable = false)
    private LocalDateTime insertDate = LocalDateTime.now();

    @JsonIgnore
    @Column(nullable = false)
    private LocalDateTime updateDate = LocalDateTime.now();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    @Version
    public Long getVersion() {
        return version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof BaseEntity)) return false;

        BaseEntity that = (BaseEntity) o;

        return new EqualsBuilder()
                .append(getId(), that.getId())
                .append(getVersion(), that.getVersion())
                .append(getInsertDate(), that.getInsertDate())
                .append(getUpdateDate(), that.getUpdateDate())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getId())
                .append(getVersion())
                .append(getInsertDate())
                .append(getUpdateDate())
                .toHashCode();
    }
}
