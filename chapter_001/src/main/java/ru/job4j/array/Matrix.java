package ru.job4j.array;

public class Matrix {

    /**
     * Check equality of values in array.
     * @param size - number, the size both sides.
     * @return multiply table.
     */
    public int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                table[i][j] = (i + 1) * (j + 1);
            }
        }
        return table;
    }
}
