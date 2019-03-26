package ru.job4j.io.consolechat;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

/**
 * ConsoleChat
 *
 * @author Vladimir Zhdanov (mailto:constHomeSpb@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class ConsoleChat {
    private Input input;

    public ConsoleChat(Input input) {
        this.input = input;
    }

    public static void main(String[] args) {
        ConsoleChat consoleChat = new ConsoleChat(new UserInput());
        consoleChat.toStartChat();
    }

    public void toStartChat() {
        StringJoiner joiner = new StringJoiner(System.lineSeparator());
        joiner.add("Hello Ser! My name is David, I'm personal assistant!");
        joiner.add("Type your request.");
        joiner.add("In order to stop our assistant David type 'Stop' and 'Go on' to continue.Type 'End' to exit.");
        System.out.println(joiner);
        String log = System.getProperty("java.io.tmpdir") + "log.txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(log))) {
            Input userInput = this.input;
            bw.write(new Date() + System.lineSeparator() + joiner.toString() + System.lineSeparator());
            boolean userWantToChat = true;
            boolean userWantToChatWithBot = true;
            String userMassage;
            String botMassage = "Let's get started!";
            System.out.println(botMassage);
            bw.write(new Date() + " Bot: " + botMassage + System.lineSeparator());
            while (userWantToChat) {
                userMassage = userInput.ask();
                bw.write(new Date() + " User: " + userMassage + System.lineSeparator());
                if (userMassage.equalsIgnoreCase("End")) {
                    userWantToChat = false;
                    userWantToChatWithBot = false;
                    String goodBye = "Bye bye!";
                    bw.write(new Date() + " Bot: " + goodBye);
                    System.out.println(goodBye);
                    break;
                }
                if (userMassage.equalsIgnoreCase("Stop")) {
                    userWantToChatWithBot = false;
                    botMassage = "Have a good day, if u want to continue, type 'Go on'.";
                    System.out.println(botMassage);
                    bw.write(new Date() + " Bot: " + botMassage + System.lineSeparator());
                }
                if (userWantToChatWithBot) {
                    botMassage = this.getPhrase();
                    System.out.println(botMassage);
                    bw.write(new Date() + " Bot: " + botMassage + System.lineSeparator());
                }
                if (userMassage.equalsIgnoreCase("Go on")) {
                    userWantToChatWithBot = true;
                    botMassage = "Hello again! My life in serving to you!";
                    System.out.println(botMassage);
                    bw.write(new Date() + " Bot: " + botMassage + System.lineSeparator());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getPhrase() {
        String phrasesDirectory = "C:\\Projects\\job4j\\chapter_006\\src\\main\\resources\\сhat\\phrases.txt";
        ArrayList<String> phrases = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(phrasesDirectory))) {
            String line;
            while ((line = br.readLine()) != null) {
                phrases.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Random rnd = new Random();
        String phrase = phrases.get(rnd.nextInt(phrases.size()));
        return phrase;
    }
}

