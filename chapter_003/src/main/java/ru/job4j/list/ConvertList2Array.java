package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        List<Integer> newList = new ArrayList<>(list);
        while (newList.size() % rows != 0) {
            newList.add(0);
        }
        int cells = newList.size() / rows;
        int[][] array = new int[rows][cells];
        int index = 0;
        int indexOfNewList = 0;
        for (int[] i : array) {
            index = 0;
            for (int j : i) {
                i[index++] = newList.get(indexOfNewList++);
            }
        }
       /* for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows; j++) {
                array[i][j] = newList.get(j + (rows * i));
            }
        }*/
        return array;
    }
}