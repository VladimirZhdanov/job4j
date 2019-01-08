package ru.job4j.list;

import java.util.List;

public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int sizeOfList = list.size();
        while (sizeOfList % rows != 0) {
            sizeOfList++;
        }
        int cells = sizeOfList / rows;
        int[][] array = new int[rows][cells];
        int indexOfNewList = 0;
        for (int i[] : array) {
            int index = 0;
            for (int j : i) {
                if (indexOfNewList < list.size()) {
                    i[index++] = list.get(indexOfNewList++);
                }
            }
        }
        return array;
    }
}