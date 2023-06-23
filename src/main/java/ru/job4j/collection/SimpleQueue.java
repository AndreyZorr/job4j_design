package ru.job4j.collection;

import java.util.NoSuchElementException;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();

    private int size = 0;

    public T poll() {
        if (size != 0) {
            size--;
            return out.pop();
        }
            throw new NoSuchElementException("Queue is empty");
    }

    public void push(T value) {
        in.push(value);
        size++;
        if (size == 1) {
            out.push(value);
        } else {
            T sizeOut = out.pop();
            out.push(in.pop());
            out.push(sizeOut);
        }
    }
}
