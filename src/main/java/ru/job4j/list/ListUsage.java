package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

public class ListUsage {
    public static void main(String[] args) {
        List<String> rsl = new ArrayList<>();
        List<String> list = new ArrayList<>();
        rsl.add("one"); /*добавляет элемент e в конец списка*/
        rsl.add("two");
        rsl.add("three");
        rsl.add(1, "four"); /*добавляет указанный элемент (element) в указанную позицию(index) в списке,сдвигает элемент вправо.*/
        list.add("four"); /* добавляет все элементы из переданной коллекции  */
        list.add("five"); /* в конец списка в том порядке, в котором они возвращаются итератором переданной коллекции */
        rsl.addAll(list);
        rsl.addAll(2, list);
        for (String s : rsl) {
            System.out.println("Текущий элемент: " + s);
        }
    }
}
