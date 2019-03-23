package ru.job4j.io.zip;

/**
 * Args
 *
 * @author Vladimir Zhdanov (mailto:constHomeSpb@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Args {
    private String directory;
    private String exclude;
    private String output;

    public Args(String[] args) {
        this.directory = args[0];
        this.exclude = args[1];
        this.output = args[2];
    }

    public String directory() {
        return directory;
    }

    public String exclude() {
        return exclude;
    }

    public String output() {
        return output;
    }
}
