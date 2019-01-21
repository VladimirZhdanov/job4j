package ru.job4j.bank;


import java.util.*;

public class Convert {

    public Convert(){   // зачем? пробел

    }

    //Converts array to list
    List<Integer> makeList(int[][] array) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++)  // {} - скобки
                list.add(array[i][j]);
        }
        return list;
    }


    //Converts list to array
    public int[][] makeArray(List<Integer> list, int rws) { // название переменой rws - не понятно
        Iterator<Integer> iterator = list.iterator();
        int cls = list.size() / rws + (list.size() % rws == 0 ? 0 : 1); // название переменой rws/cls - не понятно


        int[][] array = new int[rws][cls];
        for (int i = 0; i < rws; i++) {
            for (int j = 0; j < cls; j++) {
                if (iterator.hasNext())                       // {} - скобки
                    array[i][j] = iterator.next();
                else                                            // {} - скобки
                    array[i][j] = 0;
            }
        }
        return array;
    }
}