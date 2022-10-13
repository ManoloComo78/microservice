package com.manolovizzini.demo.microservice.domain.user;

import com.manolovizzini.demo.microservice.domain.BaseEntityActiveablePositionableEditable;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

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
    private LocalDate birthdate = LocalDate.now();

    public User() {

    }

    public User(String username) {
        this.username = username;
        this.password = "sa";
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }


}

