package ru.job4j.io.consolechat;


import java.util.Scanner;

/**
 * UserInput
 *
 * @author Vladimir Zhdanov (mailto:constHomeSpb@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class UserInput implements Input {
    private Scanner inpute = new Scanner(System.in);

    @Override
    public String ask(String question) {
        System.out.println(question);
        return inpute.nextLine();
    }
}
