package com.manolovizzini.demo.microservice;

import com.manolovizzini.demo.microservice.dao.user.UserRepository;
import com.manolovizzini.demo.microservice.domain.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.TaskExecutor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * @author mviz - 13/10/2022
 * @version 1.0-SNAPSHOT
 * <p>
 */
@SpringBootApplication
@EntityScan("com.manolovizzini.demo.microservice.domain")
@EnableJpaRepositories("com.manolovizzini.demo.microservice.dao")
public class Application implements CommandLineRunner {

    @Autowired
    private UserRepository repository;

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) {

        logger.info("StartApplication...");

        repository.save(new User("Java"));
        repository.save(new User("Node"));
        repository.save(new User("Python"));

        System.out.println("\nfindAll()");
        repository.findAll().forEach(x -> System.out.println(x.getUsername()));

        System.out.println("\nfindById(1L)");
        repository.findById(1l).ifPresent(x -> System.out.println(x.getUsername()));

//        System.out.println("\nfindByName('Node')");
//        repository.findByUsername("Node").forEach(x -> System.out.println(x));

    }


}
