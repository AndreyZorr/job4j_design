package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

public class ListReading {
    public static void main(String[] args) {
        List<String> rsl = new ArrayList<>();
        rsl.add("one");
        rsl.add("two");
        rsl.add("three");
        for (int i = 0; i < rsl.size(); i++) {
            System.out.println("Текущий элемент: " + rsl.get(i));
        }
    }
}
