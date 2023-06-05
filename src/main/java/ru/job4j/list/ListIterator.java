package ru.job4j.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/*метод возвращает объект Iterator,
который содержит в себе все элементы исходной коллекции*/

public class ListIterator {
    public static void main(String[] args) {
        List<String> rsl = new ArrayList<>();
        List<String> list = new ArrayList<>();
        rsl.add("one");
        rsl.add("two");
        rsl.add("three");
        list.add("one");
        list.add("three");
        rsl.removeAll(list);
        for (String s : rsl) {
            System.out.println("Текущий элемент: " + s);
        }
    }
}
