package ru.job4j.io.consolechat;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * ConsoleChatTest
 *
 * @author Vladimir Zhdanov (mailto:constHomeSpb@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class ConsoleChatTest {

    @Test
    public void whenCheckConsoleChat() {
        List<String> containerOfLog = new ArrayList<>();
        String logFilePath = System.getProperty("java.io.tmpdir") + "log.txt";
        String[] userInputSimulate = {"Hey", "stop", "miss you", "go on", "end"};
        SimulateInput simulateInput = new SimulateInput(userInputSimulate);
        ConsoleChat consoleChat = new ConsoleChat(simulateInput);
        consoleChat.toStartChat();
        try (BufferedReader br = new BufferedReader(new FileReader(logFilePath))) {
            String line = null;
            while ((line = br.readLine()) != null) {
                containerOfLog.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String lineTenExpected = containerOfLog.get(10);
        String lineThirteenExpected = containerOfLog.get(13);
        assertThat(lineTenExpected.endsWith("go on"), is(true));
        assertThat(lineThirteenExpected.endsWith("Bye bye!"), is(true));
    }
}