package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Convert
 *
 * @author Vladimir Zhdanov (mailto:constHomeSpb@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Convert {
    public List<Integer> convert(Integer[][] matrix, Function<Integer[], Stream<Integer>> list) {
        return Stream.of(matrix).flatMap(list).collect(Collectors.toList());
    }
}
