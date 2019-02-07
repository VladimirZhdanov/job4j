package ru.job4j.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
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
        return profiles.stream().distinct().map(profile -> profile.address).collect(Collectors.toList());
    }

    public List<Address> sortByCity(List<Address> list) {
        list.sort(
                new Comparator<Address>() {
                    @Override
                    public int compare(Address o1, Address o2) {
                        return o1.getCity().compareTo(o2.getCity());
                    }
                });
        return list;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Profile profile = (Profile) o;
        return Objects.equals(address, profile.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address);
    }
}
