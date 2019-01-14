package ru.job4j.list;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * SortUser
 *
 * @author Vladimir Zhdanov (mailto:constHomeSpb@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class SortUser {
    public Set<User> sort(List<User> list) {
        return new TreeSet<>(list);
    }
}
