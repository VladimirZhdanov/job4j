package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Profile
 *
 * @author Vladimir Zhdanov (mailto:constHomeSpb@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Profile {
    private Address address;

    public Profile() {
    }

    public Profile(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    List<Address> collect(List<Profile> profiles) {
        return profiles.stream().map(profile -> profile.address).collect(Collectors.toList());
    }
}
