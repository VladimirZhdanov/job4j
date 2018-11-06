package ru.job4j.tracker;

/**
 * StartUI class.
 *
 * @author Vladimir Zhdanov (mailto:constHomeSpb@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class StartUI {
    private static final String ADD = "0";
    private static final String SHOW_ALL = "1";
    private static final String EDIT = "2";
    private static final String DELETE = "3";
    private static final String FIND_ID = "4";
    private static final String FIND_NAME = "5";
    private static final String EXIT = "6";

    /**
     * Get data from a client.
     */
    private final Input input;

    /**
     * The tracker.
     */
    private final Tracker tracker;

    /**
     * <p>The constructor.</p>
     * @param input Get data from a client.
     * @param tracker The tracker.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * <p>The main loop of the app.</p>
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Make your choice : ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (SHOW_ALL.equals(answer)) {
                this.showAll();
            } else if (EDIT.equals(answer)) {
                this.editItem();
            } else if (DELETE.equals(answer)) {
                this.deleteItem();
            } else if (FIND_ID.equals(answer)) {
                this.findID();
            } else if (FIND_NAME.equals(answer)) {
                this.findName();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

    /**
     * <p>Find all the elemets of the Tracker.</p>
     */
    private void showAll() {
        System.out.println("------------ Showing the all item of the Tracker --------------");
        Item[] itemOut = this.tracker.findAll();
        for (Item itemIn : itemOut) {
            System.out.println(itemIn);
        }
        System.out.println("------------------------------ THE END ------------------------");
    }

    /**
     * <p>Find by name a item of the Tracker.</p>
     */
    private void findName() {
        System.out.println("------------ Search an item by name --------------");
        String name = this.input.ask("Enter name of the item :");
        Item[] itemOut = this.tracker.findByName(name);
        for (Item itemIn : itemOut) {
            System.out.println(itemIn);
        }
    }

    /**
     * <p>Find by id a item of the Tracker.</p>
     */
    private void findID() {
        System.out.println("------------ Search an item by id--------------");
        String id = this.input.ask("Enter id of the item :");
        Item item = this.tracker.findById(id);
        if (item == null) {
            System.out.println("The id is not exist!");
        } else {
            System.out.println(item);
        }
    }

    /**
     * <p>Delete a item of the Tracker.</p>
     */
    private void deleteItem() {
        System.out.println("------------ Delete an item --------------");
        String id = this.input.ask("Enter id of the item :");
        if (!this.tracker.delete(id)) {
            System.out.println("The id is not exist!");
        } else {
            System.out.println("------------ The item with id : " + id + " is deleted " + "-----------");
        }
    }

    /**
     * <p>Replace the old item to a new one.</p>
     */
    private void editItem() {
        System.out.println("------------ Edition a item --------------");
        String id = this.input.ask("Enter id of the item :");
        Item previous = this.tracker.findById(id);
        if (previous == null) {
            System.out.println("The id is not exist!");
        } else {
            System.out.println(previous);
            String name = this.input.ask("Enter a new name of the item :");
            String desc = this.input.ask("Enter a new description of the item :");
            Item next = new Item(name, desc);
            this.tracker.replace(id, next);
            System.out.println(next);
        }
    }

    /**
     * <p>Add a new item to the Tracker.</p>.
     */
    private void createItem() {
        System.out.println("------------ Addition a new item --------------");
        String name = this.input.ask("Enter a new name of the item :");
        String desc = this.input.ask("Enter a description of the item :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println(item);
    }

    /**
     * <p>Show the menu.</p>.
     */
    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
        System.out.println("Select:");
    }

    /**
     * <p>The beginning of the app.</p>.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}