package ru.job4j.jdbc;


import org.junit.Test;
import ru.job4j.tracker.Item;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;

public class TrackerSQLTest {
    @Test
    public void checkConnection() {
        TrackerSQL sql = new TrackerSQL();
        assertThat(sql.init(), is(true));
    }

    @Test
    public void whenAddItemThanFindSameItem() throws Exception {
        try (TrackerSQL trackerSQL = new TrackerSQL()) {
            String id = trackerSQL.add(new Item("item1", "description1")).getId();
            assertThat(trackerSQL.findById(id).getName(), is("item1"));
        }
    }

    @Test
    public void whenDeleteItemThenCantFind() throws Exception {
        try (TrackerSQL trackerSQL = new TrackerSQL()) {
            String id = trackerSQL.add(new Item("item2", "description2")).getId();
            trackerSQL.delete(id);
            assertThat(trackerSQL.findById(id), nullValue());
        }
    }

    @Test
    public void whenReplaceThanHaveNewItem() throws Exception {
        try (TrackerSQL trackerSQL = new TrackerSQL()) {
            String newItemId = trackerSQL.add(new Item("item3", "description3")).getId();
            System.out.println(newItemId);
            trackerSQL.replace(newItemId, new Item("newItem3", "newDescription3"));
            assertThat(trackerSQL.findById(newItemId).getName(), is("newItem3"));
        }
    }
}