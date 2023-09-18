package ru.job4j.io.serialization.json;

import javax.xml.bind.annotation.*;
@XmlAccessorType(XmlAccessType.FIELD)
public class Number {
    @XmlAttribute
    private String number;
    public Number() {
    }
    public Number(String number) {
        this.number = number;
    }
    @Override
    public String toString() {
        return "Number{"
                + "number='" + number + '\''
                + '}';
    }
}
