package ru.job4j.list;

import java.util.Iterator;

/**
 * MyStack
 *
 * @author Vladimir Zhdanov (mailto:constHomeSpb@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class MyStack<E> implements Iterable<E> {

    private int size = 0;
    private MyStack<E> firstStack;
    private MyStack<E> secondStack;

    public MyStack() {
        this.firstStack = new MyStack<>();
        this.secondStack = new MyStack<>();
    }


    public E poll() {
        E result = secondStack.poll();
        size--;
        return result;

    }

    public void push(E value) {
        firstStack.push(value);
        secondStack.push(firstStack.poll());
        size++;
    }

    public int size() {
        return this.size;
    }

    @Override
    public Iterator<E> iterator() {
        return secondStack.iterator();
    }
}
