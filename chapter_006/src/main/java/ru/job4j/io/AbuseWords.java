package ru.job4j.io;

import java.io.*;

/**
 * AbuseWords
 *
 * @author Vladimir Zhdanov (mailto:constHomeSpb@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class AbuseWords {

    void dropAbuses(InputStream in, OutputStream out, String[] abuse) {
        BufferedReader bReader = null;
        BufferedWriter bWriter = null;
        try {
            bReader = new BufferedReader(new InputStreamReader(in));
            bWriter = new BufferedWriter(new OutputStreamWriter(out));
            while (bReader.ready()) {
               // bReader.readLine().
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
