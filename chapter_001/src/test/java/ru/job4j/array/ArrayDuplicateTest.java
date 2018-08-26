package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * ArrayDuplicateTest
 *
 * @author Vladimir Zhdanov (mailto:constHomeSpb@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class ArrayDuplicateTest {
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        ArrayDuplicate check = new ArrayDuplicate();
        String[] input = new String[]  {"Привет", "Мир", "Привет", "Супер", "Мир"};
        String[] result = new String[]  {"Привет", "Мир", "Супер", "Мир"};
        assertThat(result, is(result));
    }
    //напишите здесь тест, проверяющий удаление дубликатов строк из массива строк.
}

