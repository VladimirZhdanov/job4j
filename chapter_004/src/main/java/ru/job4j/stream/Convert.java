package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Convert {
    public List<Integer> convert(Integer[][] matrix, Function<Integer[], Stream<Integer>> list) {
        return Stream.of(matrix).flatMap(list).collect(Collectors.toList());
    }
}
