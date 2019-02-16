package ru.job4j.iterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

/**
 * EvenIterator
 *
 * @author Vladimir Zhdanov (mailto:constHomeSpb@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class EvenIterator<Integer> implements Iterator<Integer> {
    private Integer[] values;
    //private Stream<Integer> stream;
    private int i;
    private boolean nextIsKnown = false;

    public EvenIterator(Integer[] values) {
        this.values = (Integer[]) Arrays.stream(values)
                .filter(value -> (int) value % 2 == 0)
                .toArray();
        //this.stream = Arrays.stream(values);
    }

    @Override
    public boolean hasNext() {
        return i < values.length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        } else {
            Integer result = values[i];
            i++;
            return result;
        }
    }
}
