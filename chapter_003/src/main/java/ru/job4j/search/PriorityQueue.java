package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     * @param task задача
     */
    public void put(Task task) {
        if (tasks.size() == 0) {
            tasks.add(task);
        } else if (tasks.getLast().getPriority() < task.getPriority()) {
            tasks.addLast(task);
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                if (tasks.get(i).getPriority() > task.getPriority()) {
                    tasks.add(i, task);
                    break;
                }
                if (tasks.get(i).getPriority() == task.getPriority()) {
                    tasks.add(i, task);
                    break;
                }
            }
        }
        //TODO добавить вставку в связанный список.
    }

    public Task take() {
        return this.tasks.poll();
    }

    public int size() {
        return this.tasks.size();
    }
}