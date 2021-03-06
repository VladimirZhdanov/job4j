package ru.job4j.socket.bot;

import com.google.common.base.Joiner;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * ClientTest
 *
 * @author Vladimir Zhdanov (mailto:constHomeSpb@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class ClientTest {
    private static final String LN = System.lineSeparator();

    @Test
    public void whenAskExitThenServerExit() throws IOException {
        testClient("exit", LN, "");
    }

    @Test
    public void whenHi() throws IOException {
        testClient(
                Joiner.on(LN).join("Hi", "exit"),
                Joiner.on(LN).join("Hello, dear friend, I am Oracle.", "", "", ""),
                Joiner.on(LN).join("Hello, dear friend, I am Oracle.", ""));
    }

    private void testClient(String consoleInput, String serverInput, String expected) throws IOException {
        Socket socket = mock(Socket.class);
        ByteArrayInputStream in = new ByteArrayInputStream(serverInput.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayOutputStream consoleOutputStream = new ByteArrayOutputStream();
        PrintStream consolePrintStream = new PrintStream(consoleOutputStream);
        System.setOut(consolePrintStream);
        ByteArrayInputStream consoleInputStream = new ByteArrayInputStream(consoleInput.getBytes());
        System.setIn(consoleInputStream);
        when(socket.getInputStream()).thenReturn(in);
        when(socket.getOutputStream()).thenReturn(out);

        Client clientOracle = new Client(socket);
        clientOracle.start();
        assertThat(consoleOutputStream.toString(), is(expected));
    }

}