package ru.job4j.list;

/**
 * User
 *
 * @author Vladimir Zhdanov (mailto:constHomeSpb@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class User {
    private int id;
    private String name;
    private String ciy;

    public User(int id, String name, String ciy) {
        this.id = id;
        this.name = name;
        this.ciy = ciy;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCiy() {
        return ciy;
    }
}
