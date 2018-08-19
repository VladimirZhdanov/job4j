package ru.job4j.array;

/**
 * Check
 *
 * @author Vladimir Zhdanov (mailto:constHomeSpb@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Check {

    /**
     * Check equality of values in array.
     * @param data - array.
     * @return boolean.
     */
    public boolean mono(boolean[] data) {
        boolean result = false;
        for (int i = 0; i < data.length - 1; i++) {
            if (data[i] != data[i + 1]) {
                return result;
            }
            result = true;
        }
        return result;
    }
}