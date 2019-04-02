package ru.job4j.socket.netFileManager;

import java.net.Socket;

public class Server {
    private static final int PORT = 5001;
    private final Socket socket;

    public Server(Socket socket) {
        this.socket = socket;
    }
}
