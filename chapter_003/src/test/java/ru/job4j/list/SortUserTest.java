package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

/**
 * SortUserTest
 *
 * @author Vladimir Zhdanov (mailto:constHomeSpb@gmail.com)
 * @version $Id$
 * @since 0.1
 */

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SortUserTest {
    private final SortUser sortedTreeSet = new SortUser();
    private final List<User> userList = new ArrayList<>();
    private final List<User> expect = new ArrayList<>();

    @Before
    public void putNewUsers() {
        userList.add(new User("Diablo", 666));
        userList.add(new User("John", 27));
        userList.add(new User("Nil", 37));
        userList.add(new User("I", 32));
        userList.add(new User("I", 3));
    }

    @Test
    public void whenSortByAgeThenSortByAge() {
        expect.add(new User("I", 3));
        expect.add(new User("John", 27));
        expect.add(new User("I", 32));
        expect.add(new User("Nil", 37));
        expect.add(new User("Diablo", 666));
        Set<User> result = sortedTreeSet.sort(userList);
        assertThat(result.toString(), is(expect.toString()));
    }

    @Test
    public void whenInArrayListToSortNameForLength() {
        expect.add(new User("I", 32));
        expect.add(new User("I", 3));
        expect.add(new User("Nil", 37));
        expect.add(new User("John", 27));
        expect.add(new User("Diablo", 666));
        List<User> result = sortedTreeSet.sortNameLength(userList);
        assertThat(result.toString(), is(expect.toString()));
    }

    @Test
    public void sortByAllFields() {
        expect.add(new User("Diablo", 666));
        expect.add(new User("I", 3));
        expect.add(new User("I", 32));
        expect.add(new User("John", 27));
        expect.add(new User("Nil", 37));
        List<User> result = sortedTreeSet.sortByAllFields(userList);
        assertThat(result.toString(), is(expect.toString()));
    }
}