package ru.job4j.tracker;

import java.util.List;

/**
 * StartUI class.
 *
 * @author Vladimir Zhdanov (mailto:constHomeSpb@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class StartUI {
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
    private boolean working = true;

    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions(this);
        List<Integer> range = menu.getRangeOfMenu();
        do {
            menu.show();
            menu.select(this.input.ask("select:", range));
        } while (this.working);
    }
    public void stop() {
        this.working = false;
    }

    /**
     * <p>The beginning of the app.</p>.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ValidateInput(
                new ConsoleInput()
        ), new Tracker()).init();
    }
}