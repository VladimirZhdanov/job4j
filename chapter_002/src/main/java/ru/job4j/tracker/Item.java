package ru.job4j.tracker;

/**
 * Item class.
 *
 * @author Vladimir Zhdanov (mailto:constHomeSpb@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Item {
    private String id;
    public String name;
    public String description;
    public long created;
    public String[] comments;

    public Item() {
    }
    public Item(String name, String description, long created) {
        this.name = name;
        this.description = description;
        this.created = created;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return this.id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
}
