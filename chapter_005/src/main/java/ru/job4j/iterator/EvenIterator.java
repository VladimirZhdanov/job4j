package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * EvenIterator
 *
 * @author Vladimir Zhdanov (mailto:constHomeSpb@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class EvenIterator<T> implements Iterator<T> {
    private T[] values;
    private int i = 0;

    public EvenIterator(T[] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        boolean result = false;
        for (int j = i; j < values.length; j++) {
            if ((Integer) values[j] % 2 == 0) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        } else {
            T result;
            while ((Integer) values[i] % 2 != 0) {
                i++;
            }
            result = values[i];
            i++;
            return result;
        }
    }
}
