package ru.job4j.io.zip;

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

    public static void main(String[] args) {
        args = new String[3];
        ConsoleInput input = new ConsoleInput();
        args[0] = input.ask("Please, enter a path to a directory in order to archive, format: c:\\abc\\def...:");
        args[1] = input.ask("Please, enter a extension to ignore, format: .*:");
        args[2] = input.ask("Please, enter a new name to a new zip-file:");
        Args parameters = new Args(args);
        Logic logic = new Logic();
        logic.list(parameters.directory(), parameters.exclude());
        logic.zipping(parameters);
    }

    public void zipping(Args args) {
        List<File> listForZipping = this.list(args.directory(), args.exclude());
        try (ZipOutputStream zip = new ZipOutputStream(new FileOutputStream(args.output()))) {
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
