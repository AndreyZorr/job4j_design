package ru.job4j.io.serialization.xml;

import javax.xml.bind.annotation.*;
import java.util.Arrays;
@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class Car {
    @XmlAttribute
    private boolean v8;
    @XmlAttribute
    private int age;
    private Number number;
    @XmlElementWrapper(name = "owners")
    @XmlElement(name = "owner")
    private String[] ownerses;
    public Car() {
    }

    public Car(boolean v8, int age, Number number, String... ownerses) {
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
}



