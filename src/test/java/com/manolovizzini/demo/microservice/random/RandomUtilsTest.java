package com.manolovizzini.demo.microservice.random;

import com.github.javafaker.Faker;
import com.manolovizzini.demo.microservice.domain.system.Parameter;
import com.manolovizzini.demo.microservice.domain.user.User;
import junit.framework.TestCase;

import java.util.HashSet;

import static org.junit.Assert.assertNotEquals;

/**
 * @author mviz - 18/10/2022
 * @version 1.0-SNAPSHOT
 */
public class RandomUtilsTest extends TestCase {

    private RandomUtils randomUtils;
    private Parameter parameter;

    @Override
    protected void setUp() throws Exception {
        randomUtils = new RandomUtils();
        parameter = new Parameter();
    }

    public void testGetRandomRoles() {

    }
    public void testGenerateUser_Country_true1() {
        parameter.setLanguageTag("it-IT");

        User user = randomUtils.generateUser(parameter, new Faker(), new HashSet<>(), new HashSet<>());

        assertEquals("Italy", user.getCountry());
    }

    public void testGenerateUser_Country_true2() {
        parameter.setLanguageTag("ar-TN");

        User user = randomUtils.generateUser(parameter, new Faker(), new HashSet<>(), new HashSet<>());

        assertEquals("Tunisia", user.getCountry());
    }

    public void testGenerateUser_Country_false() {
        parameter.setLanguageTag("ar-TN");

        User user = randomUtils.generateUser(parameter, new Faker(), new HashSet<>(), new HashSet<>());

        assertNotEquals("France", user.getCountry());
    }
}
