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
public class EvenIterator<Integer> implements Iterator<Integer> {
    private Integer[] values;
    private int i = 0;

    public EvenIterator(Integer[] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        boolean result = false;
        for (int j = i; j < values.length; j++) {
            if ((int) values[j] % 2 == 0) {
                result = true;
                i = j;
                break;
            }
        }
        return result;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        } else {
            Integer result;
            result = values[i];
            i++;
            return result;
        }
    }
}
