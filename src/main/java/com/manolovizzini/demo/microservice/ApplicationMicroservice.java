package com.manolovizzini.demo.microservice;

import com.manolovizzini.demo.microservice.dao.system.ParameterRepository;
import com.manolovizzini.demo.microservice.dao.user.AccessRepository;
import com.manolovizzini.demo.microservice.dao.user.RoleRepository;
import com.manolovizzini.demo.microservice.dao.user.UserRepository;
import com.manolovizzini.demo.microservice.domain.system.Parameter;
import com.manolovizzini.demo.microservice.domain.user.Access;
import com.manolovizzini.demo.microservice.domain.user.Role;
import com.manolovizzini.demo.microservice.domain.user.RoleName;
import com.manolovizzini.demo.microservice.common.EntityGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.HashSet;
import java.util.Set;

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
    public final static String dateLocalePattern = "dd/MM/yyyy";
    public final static String dateTimeLocalePattern = "dd/MM/yyyy hh:mm";

    public static void main(String[] args) {
        SpringApplication.run(ApplicationMicroservice.class, args);
    }

    @Bean
    CommandLineRunner runner(UserRepository userRepository, RoleRepository roleRepository, AccessRepository accessRepository, ParameterRepository parameterRepository, Environment env) {
        return args -> {
            EntityGenerator entityGenerator = new EntityGenerator();

            //System params
            Parameter parameter = new Parameter();
            parameter.setCounter(Integer.parseInt(env.getProperty("system.counter")));
            parameter.setLanguageTag(env.getProperty("system.languageTag"));
            parameterRepository.save(parameter);

            Set<Role> rolesSaved = new HashSet<>();
            rolesSaved.add(roleRepository.save(new Role(RoleName.ROLE_ADMIN, 1)));
            rolesSaved.add(roleRepository.save(new Role(RoleName.ROLE_USER, 10)));

            Set<Access> accessesSaved = new HashSet<>();
            accessesSaved.add(accessRepository.save(entityGenerator.newAccess()));
            accessesSaved.add(accessRepository.save(entityGenerator.newAccess()));
            accessesSaved.add(accessRepository.save(entityGenerator.newAccess()));
            accessesSaved.add(accessRepository.save(entityGenerator.newAccess()));
            accessesSaved.add(accessRepository.save(entityGenerator.newAccess()));

            userRepository.saveAll(entityGenerator.generateUsers(parameter, rolesSaved, accessesSaved));

            logger.info("Users added:" + userRepository.findAll().spliterator().estimateSize());
            logger.info("Language:" + parameter.getLanguageTag());
        };
    }


}
