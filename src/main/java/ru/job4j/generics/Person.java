package ru.job4j.generics;

import ru.job4j.serialization.json.Contact;

import java.util.Date;

public class Person {
    private String name;

    private int age;

    private Date birthday;

    public Person(String name, int age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public Person(boolean b, int age, Contact contact, String[] strings) {
    }

    /* getters and setters
       equals and hashcode
       toString */
}
