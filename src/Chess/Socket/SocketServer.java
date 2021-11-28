package Socket;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SocketServer {
    ServerSocket server;
    Socket client;
    Scanner input;
    PrintStream output;

    public SocketServer() {
        new Thread(() -> {
            try {
                server = new ServerSocket(SocketService.PORT);
                client = server.accept();
                new Thread(() -> {
                    while (true) {
                        try {
                            input = new Scanner(client.getInputStream());
                            final var line = input.nextLine();
                            if ((line != null) && (!line.equals(""))) {
                                System.out.println(SocketService.PORT + " recebeu: " + line);
                            }
                        } catch (IOException ex) {
                            Logger.getLogger(SocketServer.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }).start();
            } catch (IOException ex) {
                Logger.getLogger(SocketServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }).start();
    }
}
