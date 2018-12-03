package ru.job4j.tracker;


public class MenuTracker {
    /**
     * @param хранит ссылку на объект .
     */
    private Input input;

    /**
     * @param хранит ссылку на объект .
     */
    private Tracker tracker;

    /**
     * @param хранит ссылку на массив типа UserAction.
     */
    private UserAction[] actions = new UserAction[7];

    /**
     * Метод для получения массива меню.
     *
     * @return длину массива
     */
    public int getActionLength() {
        return this.actions.length;
    }

    /**
     * Method to get limit.
     *
     * @return array of limit.
     */
    public int[] getRangeOfMenu() {
        int[] result = new int[this.getActionLength()];
        for (int i = 1; i < this.getActionLength(); i++) {
            result[i] = this.actions[i].key();
        }
        return result;
    }

    /**
     * <p>Constructor.</p>
     *
     * @param input   instance of the Input.
     * @param tracker instance of the Tracker.
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    private class AddItem extends BaseAction {
        public AddItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Enter a new name of the item :");
            String desc = input.ask("Enter a description of the item :");
            Item item = new Item(name, desc);
            tracker.add(item);
            System.out.println(item);
        }
    }

    private class ShowItems extends BaseAction {
        public ShowItems(int key, String name) {
            super(key, name);
        }


        @Override
        public void execute(Input input, Tracker tracker) {
            Item[] itemOut = tracker.findAll();
            for (Item itemIn : itemOut) {
                System.out.println(itemIn);
            }
        }
    }

    private static class EditItem extends BaseAction {
        public EditItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Enter id of the item :");
            Item previous = tracker.findById(id);
            if (previous == null) {
                System.out.println("The id is not exist!");
            } else {
                System.out.println(previous);
                String name = input.ask("Enter a new name of the item :");
                String desc = input.ask("Enter a new description of the item :");
                Item next = new Item(name, desc);
                tracker.replace(id, next);
                System.out.println(next);
            }
        }
    }

    private static class DeleteItem extends BaseAction {
        public DeleteItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Enter id of the item :");
            if (!tracker.delete(id)) {
                System.out.println("The id is not exist!");
            } else {
                System.out.println("------------ The item with id : " + id + " is deleted " + "-----------");
            }
        }
    }

    private class FindItemById extends BaseAction {
        public FindItemById(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Enter id of the item :");
            Item item = tracker.findById(id);
            if (item == null) {
                System.out.println("The id is not exist!");
            } else {
                System.out.println(item);
            }
        }
    }

    private class FindItemsByName extends BaseAction {
        public FindItemsByName(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Enter name of the item :");
            Item[] itemOut = tracker.findByName(name);
            for (Item itemIn : itemOut) {
                System.out.println(itemIn);
            }
        }
    }

    private class ExitProgram extends BaseAction {
        private final StartUI ui;

        public ExitProgram(StartUI ui, int key, String name) {
            super(key, name);
            this.ui = ui;
        }

        @Override
        public int key() {
            return 6;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            this.ui.stop();
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Exit Program");
        }
    }

    /**
     * <p>Fill an array.</p>
     * @param ui
     */
    public void fillActions(StartUI ui) {
        this.actions[0] = this.new AddItem(0, "Add new Item");
        this.actions[1] = this.new ShowItems(1, "Show all items");
        this.actions[2] = new MenuTracker.EditItem(2, "Edit item");
        this.actions[3] = new MenuTracker.DeleteItem(3, "Delete item");
        this.actions[4] = this.new FindItemById(4, "Find item by Id");
        this.actions[5] = this.new FindItemsByName(5, "Find items by name");
        this.actions[6] = this.new ExitProgram(ui, 6, "Exit Program");
    }

    /**
     * Метод в зависимости от указанного ключа, выполняет соотвествующие действие.
     *
     * @param key ключ операции
     */
    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }

    /**
     * <p>Show the menu.</p>
     */
    public void show() {
        System.out.println("Menu.");
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }
}