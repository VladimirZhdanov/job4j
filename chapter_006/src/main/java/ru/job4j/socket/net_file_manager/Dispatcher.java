package ru.job4j.socket.net_file_manager;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.regex.Pattern;

public class Dispatcher {
    private static final String LN = System.lineSeparator();
    private static final String S = System.getProperty("file.separator");
    private Map<String, Function<String, Boolean>> dispatch = new HashMap<>();
    private String pathToCurrentDirectory;
    private PrintWriter out;
    private BufferedReader in;
    private File buffer;

    public Dispatcher(String pathToCurrentDirectory, BufferedReader in, PrintWriter out) {
        this.pathToCurrentDirectory = pathToCurrentDirectory;
        this.out = out;
        this.in = in;
        this.init();
    }

    public void setDispatch(String type, Function<String, Boolean> manager) {
        this.dispatch.put(type, manager);
    }

    /**
     * Set up inner hashMap of commands.
     *
     * @return this instance.
     */
    public Dispatcher init() {
        this.setDispatch("exit", this.exit());
        this.setDispatch("dir", this.dir());
        this.setDispatch("cd..", this.cdBack());
        this.setDispatch("cd/", this.cdToRoot());
        this.setDispatch("_:", this.goTo());
        this.setDispatch("help", this.showHelper());
        this.setDispatch("mkdir", this.mkdir());
        return this;
    }

    public boolean checkUserRequest(final String userRequest) {
        boolean result = true;
        if (this.dispatch.keySet().contains(userRequest)) {
            result = this.dispatch.get(userRequest).apply(userRequest);
        } else {
            out.printf(
                    "'%s' is not recognized as an internal or external command,%s operable program or batch file.%s",
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

    /**
     * Creates a new directory.
     *
     * @return boolean type.
     */
    public Function<String, Boolean> mkdir() {
        return mkdir -> {
            try {
                out.println(pathToCurrentDirectory);
                out.println("Enter a new directory ...");
                out.println();
                String userRequest = in.readLine();
                boolean check = false;
                if (userRequest != null) {
                    check = Pattern.matches("[a-zA-Z]*\\s{0}\\d*", userRequest);
                }
                while (!check) {
                    out.println("Enter new name follow this pattern [a-zA-Z]*\\s{0}\\d* ...");
                    out.println();
                    userRequest = in.readLine();
                    check = Pattern.matches("[a-zA-Z]*\\s{0}\\d*", userRequest);
                }
                this.buffer = new File(this.pathToCurrentDirectory,userRequest);
                buffer.mkdir();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return true;
        };
    }

    /**
     * Removes a directory.
     *
     * @return boolean type.
     */
    public Function<String, Boolean> rmdir() {
        return exit -> {

            return true;
        };
    }

    /**
     * Go to the certain directory.
     *
     * @return boolean type.
     */
    public Function<String, Boolean> goTo() {
        return goTo -> {
            try {
                out.println("Enter a directory ...");
                out.println();
                String userRequest = in.readLine();
                if (userRequest != null) {
                    this.buffer = new File(userRequest);
                }
                while (!this.buffer.isDirectory()) {
                    out.println("Enter a correct path ...");
                    out.println();
                    userRequest = in.readLine();
                    this.buffer = new File(userRequest);
                }
                pathToCurrentDirectory = buffer.getAbsolutePath();
                out.println(pathToCurrentDirectory);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return true;
        };
    }

    /**
     * Displays a list of files and subdirectories in a directory.
     *
     * @return boolean type.
     */
    public Function<String, Boolean> dir() {
        return dir -> {
            this.showDirectory(new File(this.pathToCurrentDirectory));
            return true;
        };
    }

    /**
     * To show the helper.
     *
     * @return boolean type.
     */
    public Function<String, Boolean> showHelper() {
        return showHelper -> {
            out.println(Server.greeting);
            return true;
        };
    }

    /**
     * Back up a directory.
     *
     * @return boolean type.
     */
    public Function<String, Boolean> cdBack() {
        return cdBack -> {
            File currentDirectory = new File(pathToCurrentDirectory);
            if (currentDirectory.getParent() != null) {
                this.pathToCurrentDirectory = currentDirectory.getParent();
                out.println(pathToCurrentDirectory);
            } else {
                out.println("You are already in the root");
            }
            return true;
        };
    }

    /**
     * Back to the root.
     *
     * @return boolean type.
     */
    public Function<String, Boolean> cdToRoot() {
        return cdToRoot -> {
            File currentDirectory = new File(pathToCurrentDirectory);
            while (currentDirectory.getParent() != null) {
                this.pathToCurrentDirectory = currentDirectory.getParent();
                currentDirectory = new File(pathToCurrentDirectory);
            }
            out.println(pathToCurrentDirectory);
            return true;
        };
    }

    private void showDirectory(File directory) {
        out.printf("Folder '%s' has:%s", directory.getAbsolutePath(), LN);
        for (File file : Objects.requireNonNull(directory.listFiles())) {
            out.println(file.toString().substring(directory.getAbsolutePath().length()));
        }
    }

}