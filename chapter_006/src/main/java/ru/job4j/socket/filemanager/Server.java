package ru.job4j.socket.filemanager;

import com.google.common.base.Joiner;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;

public class Server {
    public static String greeting;
    private static final String LN = System.lineSeparator();
    private final Socket socket;

    public Server(Socket socket) {
        this.socket = socket;
    }

    public void start(String mainDirectory) {
        try (PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
        ) {
            greeting = Joiner.on(LN).join(
                    "DIR            Displays a list of files and subdirectories in a directory.",
                    "CD..           Back up a directory.",
                    "CD/            Back to the root.",
                    "_:             Go to the certain directory.",
                    "MKDIR          Creates a directory.",
                    "RMDIR          Removes a directory.",
                    "CF             Create a new file.",
                    "DEL            Delete one files.",
                    "DL             Download a file.",
                    "UL             Upload a file. (does not work in this version)",
                    "HELP           To show the helper.",
                    "EXIT           To exit."
            );
            out.println(greeting);
            boolean userWantsContinue = true;
            String userRequest = null;
            Dispatcher dispatcher = new Dispatcher(mainDirectory, in, out);
            do {
                out.println("wait for command ...");
                out.println();
                userRequest = in.readLine().toLowerCase();
                System.out.println(userRequest);
                userWantsContinue = dispatcher.checkUserRequest(userRequest);
            } while (userWantsContinue);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("chapter_006\\src\\main\\resources\\app.properties")) {
            Properties properties = new Properties();
            properties.load(in);
            ServerSocket serverSocket = new ServerSocket(Integer.valueOf(properties.getProperty("port")));
            Socket socket = serverSocket.accept();
            System.out.println("Server is up ...");
            Server server = new Server(socket);
            server.start(properties.getProperty("root"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}