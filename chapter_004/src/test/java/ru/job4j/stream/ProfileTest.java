package ru.job4j.stream;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * ProfileTest
 *
 * @author Vladimir Zhdanov (mailto:constHomeSpb@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class ProfileTest {

    @Test
    public void collect() {
        List<Profile> listOfProfiles = new ArrayList<>();
        listOfProfiles.add(new Profile(new Address("Moscow", "Lenina", 1, 13)));
        listOfProfiles.add(new Profile(new Address("Moscow", "Moscowskay", 2, 202)));
        List<Address> expected = new ArrayList<>();
        expected.add(new Address("Moscow", "Lenina", 1, 13));
        expected.add(new Address("Moscow", "Moscowskay", 2, 202));
        Profile profile = new Profile();
        List<Address> result = profile.collect(listOfProfiles);
        assertThat(result, is(expected));
    }
}