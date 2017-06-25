package com.aditya.webapp.utilities;

import javax.validation.constraints.NotNull;
import java.util.Random;

public class StringUtils {

    final static String CHAR_LIST = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

    public static boolean isNull(@NotNull String value) {
        if (value == null || value.equals("") || value.trim().equals("") || value.equals("null")) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public static String generateRandomString(int RANDOM_STRING_LENGTH) {
        String CHAR_LIST = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuffer randStr = new StringBuffer();
        for (int i = 0; i < RANDOM_STRING_LENGTH; i++) {
            int number = getRandomNumber();
            char ch = CHAR_LIST.charAt(number);
            randStr.append(ch);
        }
        return randStr.toString();
    }

    private static int getRandomNumber() {
        int randomInt = 0;
        Random randomGenerator = new Random();
        randomInt = randomGenerator.nextInt(CHAR_LIST.length());
        if (randomInt - 1 == -1) {
            return randomInt;
        } else {
            return randomInt - 1;
        }
    }

    public static String buildSEOFriendlyString(String input, String sperator) {
        return input.replaceAll("[^A-Za-z0-9]+", sperator).toLowerCase();
    }
}
