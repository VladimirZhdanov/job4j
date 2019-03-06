package ru.job4j.map;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * UserTest
 *
 * @author Vladimir Zhdanov (mailto:constHomeSpb@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class UserTest {
    private User user1 = new User("Mark", 1, new Calendar());
    private User user2 = new User("Mark", 1, new Calendar());

    @Test
    public void shouldBeTheSame() {
        assertThat(user1, is(user1));
        assertThat(user2, is(user2));
        assertThat(user1, is(user2));
        assertThat(user1.hashCode(), is(user2.hashCode()));
    }
}