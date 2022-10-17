package com.manolovizzini.demo.microservice.domain.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.manolovizzini.demo.microservice.domain.BaseEntityActiveablePositionableEditable;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * @author mviz - 13/10/2022
 * @version 1.0-SNAPSHOT
 * <p>
 */
@Entity
@Table(name = "t_user")
@Getter
@Setter
public class User extends BaseEntityActiveablePositionableEditable {

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    @Column(nullable = false)
    private String nationality;

    @Column(nullable = false)
    private LocalDate birthdate = LocalDate.now();

    private Set<Role> roles = new HashSet<>();

    private Set<Access> accesses = new HashSet<>();

    public User() {

    }

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "t_user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    public Set<Role> getRoles() {
        return roles;
    }

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "t_user_access", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "access_id"))
    public Set<Access> getAccesses() {
        return accesses;
    }
}

