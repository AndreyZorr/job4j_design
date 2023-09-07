package ru.job4j.serialization.json;

import java.util.Arrays;

public class Car {

    private final boolean v8;
    private final int age;
    private final Number number;
    private final String[] owners;

    public Car(boolean v8, int age, Number number, String[] owners) {
        this.v8 = v8;
        this.age = age;
        this.number = number;
        this.owners = owners;
    }

    @Override
    public String toString() {
        return "Person{"
                + "v8=" + v8
                + ", age=" + age
                + ", number=" + number
                + ", owners=" + Arrays.toString(owners)
                + '}';
    }
}

