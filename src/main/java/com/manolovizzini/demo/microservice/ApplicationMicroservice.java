package com.manolovizzini.demo.microservice;


import com.manolovizzini.demo.microservice.dao.user.AccessRepository;
import com.manolovizzini.demo.microservice.dao.user.RoleRepository;
import com.manolovizzini.demo.microservice.dao.user.UserRepository;
import com.manolovizzini.demo.microservice.domain.user.Access;
import com.manolovizzini.demo.microservice.domain.user.Role;
import com.manolovizzini.demo.microservice.domain.user.RoleName;
import com.manolovizzini.demo.microservice.domain.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.LocalDateTime;

/**
 * @author mviz - 13/10/2022
 * @version 1.0-SNAPSHOT
 * <p>
 */
@SpringBootApplication
@EntityScan("com.manolovizzini.demo.microservice.domain")
@EnableJpaRepositories("com.manolovizzini.demo.microservice.dao")
public class ApplicationMicroservice extends SpringBootServletInitializer {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationMicroservice.class);

    public static void main(String[] args) {
        SpringApplication.run(ApplicationMicroservice.class, args);
    }

    @Bean
    CommandLineRunner runner(UserRepository userRepository, RoleRepository roleRepository, AccessRepository accessRepository) {
        return args -> {
            Access accessNow = new Access(LocalDateTime.now(), "0.0.0.0");
            accessNow = accessRepository.save(accessNow);
            Access accessOld = new Access(LocalDateTime.of(2017, 2, 13, 15, 56), "0.0.0.0");
            accessOld = accessRepository.save(accessOld);

            Role userRole = new Role(RoleName.ROLE_USER, 10);
            roleRepository.save(userRole);

            Role adminRole = new Role(RoleName.ROLE_ADMIN, 1);
            roleRepository.save(adminRole);

            userRole = roleRepository.findByName(RoleName.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));

            adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
                    .orElseThrow(() -> new RuntimeException("Fail! -> Cause: Admin Role not find."));

            userRepository.save(new User("Pippo", userRole, accessNow));
            userRepository.save(new User("Pluto", userRole, accessNow));
            User paperino = new User("Paperino", userRole, accessNow);
            paperino.getRoles().add(adminRole);
            paperino.getAccesses().add(accessOld);
            userRepository.save(paperino);

            logger.info("findAll()");
            userRepository.findAll().forEach(x -> logger.info(x.getUsername()));

            logger.info("findById(1L)");
            userRepository.findById(1l).ifPresent(x -> logger.info(x.getUsername()));
        };
    }

}
