package ru.job4j.list;

import java.util.List;
/*метод возвращает список,
в которые помещены список элементов elements типа E.
 Как мы видим метод принимает переменное количество аргументов (обозначается ...).
  Т.е. мы можем перечислять большое количество аргументов через запятую.*/
public class Listes {
    public static void main(String[] args) {
        List<String> rsl = List.of("one", "two", "three");
        for (String s : rsl) {
            System.out.println("Текущий элемент :" + s);
            /* метод возвращает неизменяемый список, т.е. вызвать метод add(), remove() */
        }
    }
}
