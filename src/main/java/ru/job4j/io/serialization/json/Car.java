package ru.job4j.io.serialization.json;

import ru.job4j.io.serialization.xml.Number;

import javax.xml.bind.annotation.*;
import java.util.Arrays;
@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class Car {
    @XmlAttribute
    private boolean v8;
    @XmlAttribute
    private int age;
    private ru.job4j.io.serialization.xml.Number number;
    @XmlElementWrapper(name = "owners")
    @XmlElement(name = "owners")
    private String[] ownerses;
    public Car() {
    }

    public Car(boolean v8, int age, ru.job4j.io.serialization.xml.Number number, String... ownerses) {
        this.v8 = v8;
        this.age = age;
        this.number = number;
        this.ownerses = ownerses;
    }

    @Override
    public String toString() {
        return "Person{"
                + "v8=" + v8
                + ", age=" + age
                + ", number=" + number
                + ", owners=" + Arrays.toString(ownerses)
                + '}';
    }


    public boolean isV8() {
        return v8;
    }

    public int getAge() {
        return age;
    }

    public Number getNumber() {
        return number;
    }

    public String[] getOwners() {
        return ownerses;
    }
}
