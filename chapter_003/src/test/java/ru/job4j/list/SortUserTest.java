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
    private final Set<User> expecte = new TreeSet<>();

    @Before
    public void putNewUsers() {
        userList.add(new User("Diablo", 666));
        userList.add(new User("John", 27));
        userList.add(new User("Petr", 37));
        userList.add(new User("Mike", 32));
    }

    @Test
    public void when() {
        expecte.add(new User("John", 27));
        expecte.add(new User("Mike", 32));
        expecte.add(new User("Petr", 37));
        expecte.add(new User("Diablo", 666));
        Set<User> result = sortedTreeSet.sort(userList);

        assertThat(result.toString(), is(expecte.toString()));
    }

}