package com.manolovizzini.demo.microservice.random;

import com.github.javafaker.Faker;
import com.manolovizzini.demo.microservice.common.EntityGenerator;
import com.manolovizzini.demo.microservice.common.RandomUtils;
import com.manolovizzini.demo.microservice.domain.system.Parameter;
import com.manolovizzini.demo.microservice.domain.user.Role;
import com.manolovizzini.demo.microservice.domain.user.RoleName;
import com.manolovizzini.demo.microservice.domain.user.User;
import junit.framework.TestCase;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertNotEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author mviz - 18/10/2022
 * @version 1.0-SNAPSHOT
 */
public class EntityGeneratorTest extends TestCase {

    private EntityGenerator entityGenerator;
    private Parameter parameter;
    private RandomUtils randomUtils;

    private Set<Role> roles;

    @Override
    protected void setUp() throws Exception {
        entityGenerator = new EntityGenerator();
        parameter = new Parameter();
        randomUtils = mock(RandomUtils.class);

        roles = new HashSet<>();
        roles.add(new Role(RoleName.ROLE_ADMIN, 1));
        roles.add(new Role(RoleName.ROLE_USER, 10));
        roles.add(new Role(RoleName.ROLE_CEO, 2));
    }

    public void testGetRandomRoles_true1() {
        when(randomUtils.getRandomNumberInRange(anyInt(), anyInt())).thenReturn(roles.size()+1);
        entityGenerator.setRandomUtils(randomUtils);

        Set<Role> rolesRandom = entityGenerator.getRandomRoles(roles);
        assertEquals(3, rolesRandom.size());
    }
    public void testGetRandomRoles_true2() {
        when(randomUtils.getRandomNumberInRange(anyInt(), anyInt())).thenReturn(1);
        entityGenerator.setRandomUtils(randomUtils);

        Set<Role> rolesRandom = entityGenerator.getRandomRoles(roles);
        assertEquals(1, rolesRandom.size());
        assertEquals(RoleName.ROLE_ADMIN, rolesRandom.iterator().next().getName());
    }
    public void testGetRandomRoles_true3() {
        when(randomUtils.getRandomNumberInRange(anyInt(), anyInt())).thenReturn(2);
        entityGenerator.setRandomUtils(randomUtils);

        Set<Role> rolesRandom = entityGenerator.getRandomRoles(roles);
        assertEquals(1, rolesRandom.size());
        assertEquals(RoleName.ROLE_USER, rolesRandom.iterator().next().getName());
    }

    public void testGenerateUser_Country_true1() {
        parameter.setLanguageTag("it-IT");

        User user = entityGenerator.generateUser(parameter, new Faker(), new HashSet<>(), new HashSet<>());

        assertEquals("Italy", user.getCountry());
    }

    public void testGenerateUser_Country_true2() {
        parameter.setLanguageTag("ar-TN");

        User user = entityGenerator.generateUser(parameter, new Faker(), new HashSet<>(), new HashSet<>());

        assertEquals("Tunisia", user.getCountry());
    }

    public void testGenerateUser_Country_false() {
        parameter.setLanguageTag("ar-TN");

        User user = entityGenerator.generateUser(parameter, new Faker(), new HashSet<>(), new HashSet<>());

        assertNotEquals("France", user.getCountry());
    }
}
