package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class JaggedArrayIterator<T> implements Iterator<T> {
    private T[][] values;
    private int i = 0;
    private int j = 0;

    public JaggedArrayIterator(T[][] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        return i < values.length && j < values[i].length;
    }

    @Override
    public T next() {
        if (hasNext()) {
            throw new NoSuchElementException();
        } else {
            T result = values[i][j++];
            if (j > values[i].length - 1) {
                i++;
                j = 0;
            }
            return result;
        }
    }
}
