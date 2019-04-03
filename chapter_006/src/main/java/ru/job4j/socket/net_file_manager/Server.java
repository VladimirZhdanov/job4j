package ru.job4j.socket.net_file_manager;

import com.google.common.base.Joiner;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;

public class Server {
    private static final String LN = System.lineSeparator();
    private final Socket socket;

    public Server(Socket socket) {
        this.socket = socket;
    }

    public void start(String mainDirectory) {
        try (PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
        ) {
            String greeting = Joiner.on(LN).join(
                    "DIR            Displays a list of files and subdirectories in a directory.",
                    "CD             Displays the name of or changes the current directory.",
                    "CD..           Back on a directory.",
                    "CD/            Back to the root.",
                    "_:             Go to the certain directory.",
                    "MKDIR          Creates a directory.",
                    "RMDIR          Removes a directory.",
                    "DEL            Deletes one or more files.",
                    "COPY           Copies one or more files to another location.",
                    "EXIT           To exit."
            );
            out.println(greeting);
            boolean userWantsContinue = true;
            String userRequest = null;
            Despecher despecher = new Despecher(mainDirectory, in, out);
            do {
                out.println("wait for command ...");
                out.println();
                userRequest = in.readLine().toLowerCase();
                System.out.println(userRequest);
                userWantsContinue = despecher.checkUserRequest(userRequest);
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