package com.javarush.island.mikhailov.enums;

import java.util.concurrent.ThreadLocalRandom;

public enum Gender {

    MALE(1),
    FEMALE(0);

    private final int value;

    Gender(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Gender getRandomGender() {
        int randomValue = ThreadLocalRandom.current().nextInt(0, 2); // 0 and 1
        return randomValue == 0 ? FEMALE : MALE;
    }
}
