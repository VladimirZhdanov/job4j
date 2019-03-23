package ru.job4j.io;

import java.io.File;
import java.util.*;

/**
 * Search
 *
 * @author Vladimir Zhdanov (mailto:constHomeSpb@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Search {
    List<File> files(String parent, List<String> exts) {
        List<File> result = new ArrayList<>();
        File start = new File(parent);
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
                for (String value : exts) {
                    if (file != null && file.getName().endsWith(value)) {
                        result.add(file);
                    }
                }
            }

        }
        return result;
    }
}
