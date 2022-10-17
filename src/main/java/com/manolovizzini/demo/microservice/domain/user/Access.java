package com.manolovizzini.demo.microservice.domain.user;

import com.manolovizzini.demo.microservice.domain.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * @author mviz - 17/10/2022
 * @version 1.0-SNAPSHOT
 */
@Entity
@Table(name = "t_access")
@Getter
@Setter
public class Access extends BaseEntity {

    @Column(nullable = false)
    private LocalDateTime dateTime = LocalDateTime.now();

    @Column
    private String ip;

    private Set<User> users = new HashSet<>();

    public Access() {
    }

    public Access(final LocalDateTime dateTime, final String ip) {
        this.dateTime = dateTime;
        this.ip = ip;
    }

    @ManyToMany(mappedBy = "accesses")
    public Set<User> getUsers() {
        return users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Access)) return false;

        Access access = (Access) o;

        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(getDateTime(), access.getDateTime())
                .append(getIp(), access.getIp())
                //  .append(getUsers(), access.getUsers())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .appendSuper(super.hashCode())
                .append(getDateTime())
                .append(getIp())
//                .append(getUsers())
                .toHashCode();
    }
}
