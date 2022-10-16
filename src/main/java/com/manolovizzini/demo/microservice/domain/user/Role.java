package com.manolovizzini.demo.microservice.domain.user;

import com.manolovizzini.demo.microservice.domain.BaseEntityActiveablePositionableEditable;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author mviz - 13/10/2022
 * @version 1.0-SNAPSHOT
 * <p>
 */
@Entity
@Table(name = "t_role")
@Getter
@Setter
public class Role extends BaseEntityActiveablePositionableEditable {

    @Enumerated(EnumType.STRING)
    @NaturalId
    @Column(length = 60, nullable = false, unique = true)
    private RoleName name;

    @Column
    private String description;

    @Column(nullable = false)
    private int level = 10;

    private Set<User> users = new HashSet<>();

    public Role() {
    }

    public Role(final RoleName name, final int level) {
        this.name = name;
        this.level = level;
    }

    @ManyToMany(mappedBy = "roles")
    public Set<User> getUsers() {
        return users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Role)) return false;

        Role role = (Role) o;

        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(getLevel(), role.getLevel())
                .append(getName(), role.getName())
                .append(getDescription(), role.getDescription())
                //  .append(getUsers(), role.getUsers())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .appendSuper(super.hashCode())
                .append(getName())
                .append(getDescription())
                .append(getLevel())
//                .append(getUsers())
                .toHashCode();
    }
}
