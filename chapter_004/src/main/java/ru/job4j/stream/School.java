package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * School
 *
 * @author Vladimir Zhdanov (mailto:constHomeSpb@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class School {
    List<Student> collect(List<Student> students, Predicate<Student> predict) {
        return students.stream().filter(predict).collect(Collectors.toList());
    }

    Map<String, Student> convertListToMap(List<Student> students, Function<Student, String> key, Function<Student, Student> value) {
        return students.stream().distinct().collect(Collectors.toMap(key, value));
    }
}
