package com.manolovizzini.demo.microservice.common;

import java.util.Random;

/**
 * @author mviz - 19/10/2022
 * @version 1.0-SNAPSHOT
 */
public class RandomUtils {
    public int getRandomNumberInRange(int min, int max) {
        if (max < 1) {
            max = 1;
        }
        return new Random().nextInt(max - min) + min;
    }
}
