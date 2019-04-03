package ru.job4j.socket.net_file_manager;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class Despecher {
    private static final String LN = System.lineSeparator();
    private Map<String, Function<String, Boolean>> dispatch = new HashMap<>();
    private String mainDirectory;
    private PrintWriter out;
    private BufferedReader in;

    public Despecher(String mainDirectory, BufferedReader in, PrintWriter out) {
        this.mainDirectory = mainDirectory;
        this.out = out;
        this.in = in;
        this.init();
    }

    public void setDispatch(String type, Function<String, Boolean> manager) {
        this.dispatch.put(type, manager);
    }

    public Despecher init() {
        this.setDispatch("exit", this.exit());
        return this;
    }

    public boolean checkUserRequest(final String userRequest) {
        boolean result = true;
        if (this.dispatch.keySet().contains(userRequest)) {
            result = this.dispatch.get(userRequest).apply(userRequest);
        } else {
            out.printf(
                    "%s is not recognized as an internal or external command,%s operable program or batch file.%s",
                    userRequest, LN, LN
            );
        }
        return result;
    }
    /**
     * To exit from the app.
     *
     * @return boolean type.
     */
    public Function<String, Boolean> exit() {
        return exit -> {
            out.println("Bye bye ...");
            out.println();
            return false;
        };
    }


}