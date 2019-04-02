package ru.job4j.socket.netFileManager;

import com.google.common.base.Joiner;
import java.io.*;
import java.net.Socket;

public class Server {
    private static final String LN = System.lineSeparator();
    private static final int PORT = 5001;
    private final Socket socket;

    public Server(Socket socket) {
        this.socket = socket;
    }

    public void start(String mainDirectory) {
        try (PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
        ) {
            String greeting = Joiner.on(LN).join(
                    "bla bla",
                    "bla bla",
                    "bla bla",
                    "bla bla",
                    "For exit: exit"
            );
            out.println(greeting);
            boolean userWantsContinue = true;
            String userRequest = null;

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
