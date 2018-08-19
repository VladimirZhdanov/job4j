package ru.job4j.array;

/**
 * BubbleSort
 *
 * @author Vladimir Zhdanov (mailto:constHomeSpb@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class BubbleSort {

    /**
     * BubbleSort a array.
     * @param array - array.
     * @return sorted array.
     */
    public int[] sort(int[] array) {
        int goodPairsCounter = 0;
        int i = 0;
        while (true) {
            if (array[i] > array[i + 1]) {
                int q = array[i];
                array[i] = array[i + 1];
                array[i + 1] = q;
                goodPairsCounter = 0;
            } else {
                goodPairsCounter++;
            }
            i++;
            if (i == array.length - 1) {
                i = 0;
            }
            if (goodPairsCounter == array.length - 1) {
                return array;
            }
        }
    }
}
