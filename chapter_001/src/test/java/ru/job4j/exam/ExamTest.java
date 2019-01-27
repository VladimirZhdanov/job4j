package ru.job4j.exam;

import org.junit.Test;
import static org.junit.Assert.assertThat;

import static org.hamcrest.core.Is.is;

/**
 * ExamTest
 *
 * @author Vladimir Zhdanov (mailto:constHomeSpb@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class ExamTest {

    @Test
    public void merge() {
        int[] array1 = new int[] {1, 3};
        int[] array2 = new int[] {2, 4};
        Exam exam = new Exam();
        int[] result = exam.merge(array1, array2);
        int[] expected = new int[]{1, 2, 3, 4};
        assertThat(result, is(expected));
    }
}