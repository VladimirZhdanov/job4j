package ru.job4j.io;

import java.io.*;

/**
 * CheckNumber
 *
 * @author Vladimir Zhdanov (mailto:constHomeSpb@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class CheckNumber {
    boolean isNumber(InputStream in) {
        var result = false;
        ByteArrayInputStream bais = null;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(in));
            String line = br.readLine();
            byte[] lineOfBytes =  in.readAllBytes();
            for (byte value : lineOfBytes) {
                if (value < 48 || value > 57) {
                    throw new NumberFormatException();
                }
                //System.out.println(value);
            }
            int lastSymbol = line.charAt(line.length() - 1);
            if (lastSymbol % 2 == 0) {
                result = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException nfe) {
            System.out.println("Необходимо ввести число!");
            nfe.printStackTrace();
        }
        return result;
    }
}
