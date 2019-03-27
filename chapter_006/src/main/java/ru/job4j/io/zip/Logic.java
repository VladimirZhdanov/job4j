package ru.job4j.io.zip;

import org.apache.commons.cli.*;
import ru.job4j.tracker.ConsoleInput;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Logic
 *
 * @author Vladimir Zhdanov (mailto:constHomeSpb@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Logic {
    public static void main(String[] args) throws ParseException {
        String[] parameters = new String[3];

        Options options = new Options();
        options.addOption(new Option("d", "directory", true, "directory"));
        options.addOption(new Option("e", "exclude", true, "exclude"));
        options.addOption(new Option("o", "output", true, "output"));
        CommandLineParser parser = new DefaultParser();
        CommandLine commandLine = parser.parse(options, args);

        if (commandLine.hasOption("d")) {
            String[] arguments = commandLine.getOptionValues("d");
            parameters[0] = arguments[0];
            System.out.println("We try to directory with: " + arguments[0]);
        }
        if (commandLine.hasOption("e")) {
            String[] arguments = commandLine.getOptionValues("e");
            parameters[1] = arguments[0];
            System.out.println("We try to exclude with: " + arguments[0]);
        }
        if (commandLine.hasOption("o")) {
            String[] arguments = commandLine.getOptionValues("o");
            parameters[2] = arguments[0];
            System.out.println("We try to output with: " + arguments[0]);
        }

        Args params = new Args(parameters);
        Logic logic = new Logic();
        logic.zipping(params);
    }

    public void zipping(Args args) {
        List<File> listForZipping = this.list(args.directory(), args.exclude());
        File files = new File(args.directory() + "\\" + args.output());
        try (ZipOutputStream zip = new ZipOutputStream(new FileOutputStream(files, false))) {
            for (File file : listForZipping) {
                zip.putNextEntry(new ZipEntry(file.getAbsolutePath().substring(args.directory().length())));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<File> list(String source, String exclude) {
        List<File> result = new LinkedList<>();
        File start = new File(source);
        Queue<File> data = new LinkedList<>();
        File[] deepDirectory = null;

        data.offer(start);
        while (!data.isEmpty()) {
            File file = data.poll();
            if (file != null && file.isDirectory()) {
                deepDirectory = file.listFiles();
                if (deepDirectory != null) {
                    for (File value : deepDirectory) {
                        data.offer(value);
                    }
                }
            } else {
                if (file != null && !file.getName().endsWith(exclude)) {
                    result.add(file);
                }
            }
        }
        return result;
    }
}