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
        int n = array.length;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n - i - 1 - temp; j++) {
                if (array[i].equals(array[j])) {
                    String a = array[j];
                    array[j] = array[n - 1 - temp];
                    array[n - 1 - temp] = a;
                    temp++;
                }
            }
        }
        return Arrays.copyOf(array, n - temp);
    }
}
