package com.movieapp.cinegraphqlapi.util;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

public class CommonUtils {
    private static final Random random = new Random();

    private CommonUtils() {
    }

    public static String generateRandomId(String prifix) {
        return prifix + UUID.randomUUID();
    }

    public static int generateRandomNumberBetween(int min, int max) {
        return random.nextInt((max - min) + 1) + min;
    }

    public static Set<Integer> generateUniqueRandomNumberSet(int min, int max, int count) {
        Set<Integer> uniqueRandomNumbers = new HashSet<>();

        while (uniqueRandomNumbers.size() < count) {
            int randomNumber = generateRandomNumberBetween(min, max);
            uniqueRandomNumbers.add(randomNumber);
        }

        return uniqueRandomNumbers;
    }
}
