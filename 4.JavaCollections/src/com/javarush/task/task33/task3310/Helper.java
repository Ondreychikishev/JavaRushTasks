package com.javarush.task.task33.task3310;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Created by chikishev-93 on 24.09.17.
 */
public class Helper {
    public static String generateRandomString() {
        SecureRandom secureRandom = new SecureRandom();
        BigInteger ss =  new BigInteger(130, secureRandom);
        return ss.toString(32);
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }
}
