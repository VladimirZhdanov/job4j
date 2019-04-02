package ru.job4j.socket.netFileManager;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class Despecher {
    private Map<String, Function<String, Boolean>> dispatch = new HashMap<>();
    private String mainDirectory;

    public Despecher(String mainDirectory) {
        this.mainDirectory = mainDirectory;
        this.init();
    }

    public void setDispatch(String type, Function<String, Boolean> manager) {
        this.dispatch.put(type, manager);
    }

    public Despecher init() {
        this.setDispatch("exit", this.exit());
        return this;
    }

    /**
     * To exit from the app.
     *
     * @return boolean type.
     */
    public Function<String, Boolean> exit() {
        return exit -> {
            System.out.println("Bye bye ...");
            System.out.println();
            return true;
        };
    }


}
