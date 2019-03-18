package ru.job4j.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;

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
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(in));
            String line =  br.readLine();
            int lastSymbol = line.charAt(line.length() - 1);
            BigInteger justNumberOfInputStream = new BigInteger(line);
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
