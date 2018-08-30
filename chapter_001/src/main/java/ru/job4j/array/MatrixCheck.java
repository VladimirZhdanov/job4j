package ru.job4j.array;

/**
 * MatrixCheck
 *
 * @author Vladimir Zhdanov (mailto:constHomeSpb@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class MatrixCheck {

    /**
     * Check a array.
     * @param data - array.
     * @return resolve of checked array.
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;
        for (int i = 0; i < data.length - 1; i++) {
            if (data[i][i] != data[i + 1][i + 1]) {
                result = false;
            }
        }
        return result;
    }
}