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
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cells; j++) {
                if (index >= list.size()) {
                    break;
                }
                array[i][j] = list.get(index++);
            }
        }
       /* int indexOfNewList = 0;
        for (int i[] : array) {
            int index = 0;
            for (int j : i) {
                if (indexOfNewList < list.size()) {
                    i[index++] = list.get(indexOfNewList++);
                }
            }
        }*/
        return array;
    }
}