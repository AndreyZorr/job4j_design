package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {
        final Car car = new Car(false, 70, new Number("number"),
                new String[] {"Sacha, Vika"});

        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(car));

        final String carJson =
                "{"
                        + "\"v8\":false,"
                        + "\"age\":70,"
                        + "\"number\":"
                        + "{"
                        + "\"number\":\"111\""
                        + "},"
                        + "\"owners\":"
                        + "[\"Sacha\",\"Vika\"]"
                        + "}";

        final Car car1 = gson.fromJson(carJson, Car.class);
        System.out.println(car1);
    }
}
