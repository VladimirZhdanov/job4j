package ru.job4j.list;

import java.util.Iterator;

/**
 * MyQueue
 *
 * @author Vladimir Zhdanov (mailto:constHomeSpb@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class MyQueue<E> implements Iterable<E> {

    private int size = 0;
    private MyLinkedList<E> container;

    public MyQueue() {
        this.container = new MyLinkedList<>();
    }

    public E poll() {
        E result = container.removeLast();
        size--;
        return result;
    }

    public void push(E value) {
        container.addFirst(value);
        size++;
    }

    public int size() {
        return this.size;
    }

    @Override
    public Iterator<E> iterator() {
        return container.iterator();
    }
}