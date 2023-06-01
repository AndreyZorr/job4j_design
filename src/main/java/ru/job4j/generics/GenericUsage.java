package ru.job4j.generics;

import java.util.*;

/*WildCard(<?>) - имеет соответствие с любым типом*/
public class GenericUsage {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        new GenericUsage().printRsl(list);
    }

    public void printRsl(Collection<?> col) {
        for (Iterator<?> iterator = col.iterator(); iterator.hasNext();) {
            Object next = iterator.next();
            System.out.println("Текущий элемент: " + next);
        }
    }
}
