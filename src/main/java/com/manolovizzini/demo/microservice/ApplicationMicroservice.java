package com.manolovizzini.demo.microservice;

import com.manolovizzini.demo.microservice.dao.user.RoleRepository;
import com.manolovizzini.demo.microservice.dao.user.UserRepository;
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
    CommandLineRunner runner(UserRepository userRepository, RoleRepository roleRepository) {
        return args -> {
            Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));

            Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
                    .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));

            userRepository.save(new User("Pippo", userRole));
            userRepository.save(new User("Pluto", userRole));
            User paperino = new User("Paperino", userRole);
            paperino.getRoles().add(adminRole);
            userRepository.save(paperino);

            logger.info("findAll()");
            userRepository.findAll().forEach(x -> logger.info(x.getUsername()));

            logger.info("findById(1L)");
            userRepository.findById(1l).ifPresent(x -> logger.info(x.getUsername()));
        };
    }

}
