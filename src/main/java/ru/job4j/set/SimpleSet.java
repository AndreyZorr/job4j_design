package ru.job4j.set;

import ru.job4j.collection.SimpleArrayList;

import java.util.Iterator;
import java.util.Objects;

public class SimpleSet<T> implements Set<T> {

    private SimpleArrayList<T> set = new SimpleArrayList<>(0);

    @Override
    public boolean add(T value) {
        boolean rls = !contains(value);
        if (rls) {
            set.add(value);
        }
        return rls;
    }

    @Override
    public boolean contains(T value) {
        boolean rls = false;
        for (T s : set) {
            if (Objects.equals(s, value)) {
                rls = true;
                break;
            }
        }
        return rls;
    }

    @Override
    public Iterator<T> iterator() {
        return set.iterator();
    }
}
