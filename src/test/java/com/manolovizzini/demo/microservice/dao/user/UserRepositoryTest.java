package com.manolovizzini.demo.microservice.dao.user;

import com.manolovizzini.demo.microservice.domain.user.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.stream.StreamSupport;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

/**
 * @author mviz - 13/10/2022
 * @version 1.0-SNAPSHOT
 * <p>
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository repository;


//    @Test
//    public void testFindByName() {
//        String username = "pippo";
//
//        entityManager.persist(new User(username));
//
//        Iterable<User> users = repository.findAll();
//        assertEquals(1, StreamSupport.stream(users.spliterator(), false).count());
//
//        assertThat(users).extracting(User::getUsername).containsOnly(username);
//
//    }
}
