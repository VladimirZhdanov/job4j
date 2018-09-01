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
        int n = data.length;
        for (int i = 0; i < n - 1; i++) {
            if (data[i][i] != data[i + 1][i + 1] || data[i][n - 1 - i] != data[i + 1][n - 2 - i]) {
                result = false;
            }
        }
        return result;
    }
}