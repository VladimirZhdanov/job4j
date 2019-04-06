package ru.job4j.socket.filemanager;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Properties;
import java.util.Scanner;

public class Client {
    private static final String EXIT = "exit";
    private static final String LN = System.lineSeparator();
    private final Socket socket;

    public Client(Socket socket) {
        this.socket = socket;
    }

    public void start() {
        try (PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
             Scanner console = new Scanner(System.in)) {
            String request = null;
            String response = null;
            boolean userWantsContinue = true;

            do {
                response = in.readLine();
                while (!response.isEmpty()) {
                    System.out.println(response);
                    response = in.readLine();
                }
                request = console.nextLine();
                out.println(request);
                if (EXIT.equalsIgnoreCase(request)) {
                    response = in.readLine();
                    System.out.println(response);
                    userWantsContinue = false;
                }
            } while (userWantsContinue);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("chapter_006\\src\\main\\resources\\app.properties")) {
            Properties properties = new Properties();
            properties.load(in);
            final Integer port = Integer.valueOf(properties.getProperty("port"));
            final String host = properties.getProperty("host");
            Socket socket = new Socket(InetAddress.getByName(host), port);
            Client client = new Client(socket);
            client.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
