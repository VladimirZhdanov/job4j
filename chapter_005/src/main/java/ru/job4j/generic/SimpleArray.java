package ru.job4j.generic;

import java.util.*;

/**
 * SimpleArray
 *
 * @author Vladimir Zhdanov (mailto:constHomeSpb@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class SimpleArray<T> implements Iterable<T> {
    private T[] objects;
    private int currentSize;
    private int i = 0;

    public SimpleArray(T[] objects) {
        this.objects = objects;
        this.currentSize = objects.length;
    }

    public boolean add(T model) {
        boolean result = false;
        for (int i = 0; i < currentSize; i++) {
            if (null == objects[i]) {
                objects[i] = model;
                result = true;
                break;
            }
        }
        return result;
    }

    public void set(int index, T model) {
        Objects.checkIndex(index, currentSize);
        if (currentSize > index) {
            this.objects[index] = model;
        }
    }

    public void remove(int index) {
        Objects.checkIndex(index, currentSize);
        final int newSize = currentSize - 1;
        if (newSize > index) {
            System.arraycopy(objects, index + 1, objects, index, newSize - index);
        }
        objects[currentSize - 1] = null;
    }

    public Object get(int index) {
        Objects.checkIndex(index, currentSize);
        return objects[index];
    }

    /*public static void main(String[] args) {
        SimpleArray<String> sa = new SimpleArray<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"});
        sa.remove(9);
        for (int i = 0; i < 10; i++) {
            System.out.println(sa);
        }
    }*/

    @Override
    public Iterator<T> iterator() {
        Iterator<T> it = new Iterator<T>() {

            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < currentSize && objects[currentIndex] != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                } else {
                    return objects[currentIndex++];
                }
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return it;
    }

    @Override
    public String toString() {
        return "SimpleArray{"
                + "objects=" + Arrays.toString(objects)
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SimpleArray<?> that = (SimpleArray<?>) o;
        return currentSize == that.currentSize
                && i == that.i
                && Arrays.equals(objects, that.objects);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(currentSize, i);
        result = 31 * result + Arrays.hashCode(objects);
        return result;
    }
}
