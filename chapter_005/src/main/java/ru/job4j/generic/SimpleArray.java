package ru.job4j.generic;

import java.util.Iterator;

public class SimpleArray<T> implements Iterable<T> {
    private Object[] objects = new Object[10];

/*    add(T model) {

    }

    set(int index, T model) {

    }

    remove(int index) {

    }

    get(int index) {

    }*/

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
