package ru.job4j.array;

import java.util.Arrays;

/**
 * ArrayDuplicate
 *
 * @author Vladimir Zhdanov (mailto:constHomeSpb@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class ArrayDuplicate {

    /**
     * Delete duplicate.
     * @param array - array of strings.
     * @return array without duplicates.
     */
    public String[] remove(String[] array) {
        int temp = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length - 1; j++) {
                if (array[i] == array[j]) {
                    String a = array[j];
                    array[j] = array[array.length - 1];
                    array[array.length - 1] = a;
                    temp = temp + 1;
                }
            }
        }
        return Arrays.copyOf(array, array.length - temp);
    }
}
