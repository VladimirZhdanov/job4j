package ru.job4j.io.exam;

import org.apache.commons.cli.*;

/**
 * Args
 *
 * @author Vladimir Zhdanov (mailto:constHomeSpb@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Args {
    private String directory;
    private String name;
    private String match;
    private String fullMatch;
    private String regular;
    private String output;
    private String[] args;

    public Args(String[] args) throws ParseException {
        this.args = args;
        parser();
    }

    public String directory() {
        return directory;
    }

    public String name() {
        return name;
    }

    public String match() {
        return match;
    }

    public String fullMatch() {
        return fullMatch;
    }

    public String regular() {
        return regular;
    }

    public String output() {
        return output;
    }

    private void parser() throws ParseException {
        Options options = new Options();
        options.addOption(new Option("d", "directory", true, "directory"));
        options.addOption(new Option("n", "name", true, "name"));
        options.addOption(new Option("m", "match", false, "match"));
        options.addOption(new Option("f", "fullMatch", false, "fullMatch"));
        options.addOption(new Option("r", "regular", false, "regular"));
        options.addOption(new Option("o", "output", true, "output"));
        CommandLineParser parser = new DefaultParser();
        CommandLine commandLine = parser.parse(options, this.args);

        if (commandLine.hasOption("d")) {
            String[] arguments = commandLine.getOptionValues("d");
            this.directory = arguments[0];
            System.out.println("We try directory with: " + arguments[0]);
        }
        if (commandLine.hasOption("n")) {
            String[] arguments = commandLine.getOptionValues("n");
            this.name = arguments[0];
            System.out.println("We try file name with: " + arguments[0]);
        }
        if (commandLine.hasOption("m")) {
            String[] arguments = commandLine.getOptionValues("m");
            this.match = arguments[0];
            System.out.println("We try to match with: " + arguments[0]);
        }
        if (commandLine.hasOption("f")) {
            String[] arguments = commandLine.getOptionValues("f");
            this.fullMatch = arguments[0];
            System.out.println("We try to full match with: " + arguments[0]);
        }
        if (commandLine.hasOption("r")) {
            String[] arguments = commandLine.getOptionValues("r");
            this.regular = arguments[0];
            System.out.println("We try regular with: " + arguments[0]);
        }
        if (commandLine.hasOption("o")) {
            String[] arguments = commandLine.getOptionValues("o");
            this.output = arguments[0];
            System.out.println("We try to output with: " + arguments[0]);
        }
    }
}

