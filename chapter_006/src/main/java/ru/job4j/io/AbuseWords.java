package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * AbuseWords
 *
 * @author Vladimir Zhdanov (mailto:constHomeSpb@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class AbuseWords {

    void dropAbuses(InputStream in, OutputStream out, String[] abuse) {
        try {
            BufferedReader bReader = new BufferedReader(new InputStreamReader(in));
            BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(out));
            ArrayList<String> input = new ArrayList<>(Arrays.asList(bReader.readLine().split(" ")));
            for (String badWord : abuse) {
                if (input.contains(badWord)) {
                    input.remove(badWord);
                }
            }
            String result = String.join(" ", input);
            bWriter.write(result);
            System.out.println(bWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
