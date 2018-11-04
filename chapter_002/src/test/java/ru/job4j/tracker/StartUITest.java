package ru.job4j.tracker;

/**
 * StartUITest
 *
 * @author Vladimir Zhdanov (mailto:constHomeSpb@gmail.com)
 * @version $Id$
 * @since 0.1
 */
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {

    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private Tracker tracker = new Tracker();
    private Item item1 = this.tracker.add(new Item("test name1", "desc"));
    private Item item2 = this.tracker.add(new Item("test name2", "desc"));
    private Item item3 = this.tracker.add(new Item("test name3", "desc"));

    @Before
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("execute after method");
    }

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        new StartUI(input, this.tracker).init();
        assertThat(this.tracker.findAll()[3].getName(), is("test name"));
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Input input = new StubInput(new String[]{"2", this.item1.getId(), "test replace", "заменили заявку", "6"});
        new StartUI(input, this.tracker).init();
        assertThat(this.tracker.findById(this.item1.getId()).getName(), is("test replace"));
    }

    @Test
    public void whenUserDeleteItemThenTrackerHasNothing() {
        Input input = new StubInput(new String[]{"3", this.item1.getId(), "3", this.item2.getId(), "3", this.item3.getId(), "6"});
        new StartUI(input, this.tracker).init();
        assertThat(this.tracker.findAll().length, is(0));
    }

    @Test
    public void whenUserWantToShowAllItemsThenItShows() {
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, this.tracker).init();
        assertThat(new String(out.toByteArray()), is("Menu.\r\n"
                + "0. Add new Item\r\n"
                + "1. Show all items\r\n"
                + "2. Edit item\r\n"
                + "3. Delete item\r\n"
                + "4. Find item by Id\r\n"
                + "5. Find items by name\r\n"
                + "6. Exit Program\r\n"
                + "Select:\r\n"
                + "------------ Showing the all item of the Tracker --------------\r\n"
                + "Item with id: " + this.item1.getId() + ", name: " + this.item1.getName() + ", description: desc\r\n"
                + "Item with id: " + this.item2.getId() + ", name: " + this.item2.getName() + ", description: desc\r\n"
                + "Item with id: " + this.item3.getId() + ", name: " + this.item3.getName() + ", description: desc\r\n"
                + "------------------------------ THE END ------------------------\r\n"
                + "Menu.\r\n"
                + "0. Add new Item\r\n"
                + "1. Show all items\r\n"
                + "2. Edit item\r\n"
                + "3. Delete item\r\n"
                + "4. Find item by Id\r\n"
                + "5. Find items by name\r\n"
                + "6. Exit Program\r\nSelect:\r\n"));
    }

    @Test
    public void whenUserSearchByIdItemsThenItShows() {
        Input input = new StubInput(new String[]{"4", this.item1.getId(), "6"});
        new StartUI(input, this.tracker).init();
        assertThat(new String(out.toByteArray()), is("Menu.\r\n"
                + "0. Add new Item\r\n"
                + "1. Show all items\r\n"
                + "2. Edit item\r\n"
                + "3. Delete item\r\n"
                + "4. Find item by Id\r\n"
                + "5. Find items by name\r\n"
                + "6. Exit Program\r\n"
                + "Select:\r\n"
                + "------------ Search an item by id--------------\r\n"
                + "Item with id: " + this.item1.getId() + ", name: " + this.item1.getName() + ", description: desc\r\n"
                + "Menu.\r\n"
                + "0. Add new Item\r\n"
                + "1. Show all items\r\n"
                + "2. Edit item\r\n"
                + "3. Delete item\r\n"
                + "4. Find item by Id\r\n"
                + "5. Find items by name\r\n"
                + "6. Exit Program\r\nSelect:\r\n"));
    }

    @Test
    public void whenUserSearchByNameItemsThenItShows() {
        Input input = new StubInput(new String[]{"5", this.item2.getName(), "6"});
        new StartUI(input, this.tracker).init();
        assertThat(new String(out.toByteArray()), is("Menu.\r\n"
                + "0. Add new Item\r\n"
                + "1. Show all items\r\n"
                + "2. Edit item\r\n"
                + "3. Delete item\r\n"
                + "4. Find item by Id\r\n"
                + "5. Find items by name\r\n"
                + "6. Exit Program\r\n"
                + "Select:\r\n"
                + "------------ Search an item by name --------------\r\n"
                + "Item with id: " + this.item2.getId() + ", name: " + this.item2.getName() + ", description: desc\r\n"
                + "Menu.\r\n"
                + "0. Add new Item\r\n"
                + "1. Show all items\r\n"
                + "2. Edit item\r\n"
                + "3. Delete item\r\n"
                + "4. Find item by Id\r\n"
                + "5. Find items by name\r\n"
                + "6. Exit Program\r\nSelect:\r\n"));
    }
}

