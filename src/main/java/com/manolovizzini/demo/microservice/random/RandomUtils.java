package com.manolovizzini.demo.microservice.random;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import com.google.common.collect.Sets;
import com.google.common.net.InetAddresses;
import com.manolovizzini.demo.microservice.common.CommonUtils;
import com.manolovizzini.demo.microservice.domain.system.Parameter;
import com.manolovizzini.demo.microservice.domain.user.Access;
import com.manolovizzini.demo.microservice.domain.user.Role;
import com.manolovizzini.demo.microservice.domain.user.User;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

/**
 * @author mviz - 18/10/2022
 * @version 1.0-SNAPSHOT
 */
public class RandomUtils extends CommonUtils {

    /**
     * Gets random roles.
     * <p>
     * This method return one or all element of set selected by random number.
     * If the random number is set.size()+1 return all, otherwise the element in correspondent position.
     * </p>
     *
     * @param roles the roles
     * @return the random roles
     */
    public Set<Role> getRandomRoles(Set<Role> roles) {
        int returnAll = roles.size() + 1;
        int caseRandom = getRandomNumberInRange(1, returnAll);
        if (caseRandom == returnAll) {
            return roles;
        } else {
            Role[] arr = roles.toArray(new Role[roles.size()]);
            Set<Role> newSet = new HashSet<>();
            newSet.add(arr[caseRandom-1]);
            return newSet;
        }
    }

    public User generateUser(Faker faker, Set<Role> roles, Set<Access> accesses) {
        User user = new User();
        Name nameFake = faker.name();
        user.setUsername(nameFake.username());
        user.setPassword("sa");
        user.setFirstname(nameFake.firstName());
        user.setLastname(nameFake.lastName());
        user.setNationality(faker.nation().nationality());
        user.setBirthdate(faker.date().birthday().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate());
        user.setRoles(roles);
        user.setAccesses(accesses);
        user.setActive(faker.random().nextBoolean());
        return user;
    }

    public Access newAccess() {
        return new Access(createRandomDate(2019, 2021), InetAddresses.fromInteger(new Random().nextInt()).getHostAddress());
    }

    public LocalDateTime createRandomDate(int startYear, int endYear) {
        int day = getRandomNumberInRange(1, 28);
        int month = getRandomNumberInRange(1, 12);
        int year = getRandomNumberInRange(startYear, endYear);
        int hour = getRandomNumberInRange(0, 12);
        int minute = getRandomNumberInRange(1, 59);
        return LocalDateTime.of(year, month, day, hour, minute);
    }

    public Iterable<User> generateUsers(Parameter parameter, Set<Role> roles, Set<Access> accesses) {
        Faker faker = new Faker(new Locale(parameter.getLanguageCode()), new Random(parameter.getCounter()));
        List<User> users = new ArrayList<>();
        for (int i = 0; i < parameter.getCounter(); i++) {
            users.add(generateUser(faker, getRandomRoles(roles), accesses));
        }
        return users;
    }

    public Iterable<User> generateUsers(Parameter parameter, Iterable<Role> roles, Iterable<Access> accesses) {
        return generateUsers(parameter, Sets.newHashSet(roles), Sets.newHashSet(accesses));
    }

    public int getRandomNumberInRange(int min, int max) {
        return new Random().nextInt(max - min) + min;
    }
}
