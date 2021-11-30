package Chess.Socket;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SocketServer {
    PrintStream output;
    SocketManager manager;

    public SocketServer() {
        try {
            ServerSocket server = new ServerSocket(SocketService.PORT);
            Socket client = server.accept();
            output = new PrintStream(client.getOutputStream());
            new Thread(() -> {
                while (true) {
                    try {
                        Scanner input = new Scanner(client.getInputStream());
                        handleInput(input.nextLine());
                    } catch (IOException exception) {
                        Logger.getLogger(SocketServer.class.getName()).log(Level.SEVERE, null, exception);
                    }
                }
                // server.close();
            }).start();
        } catch (IOException exception) {
            Logger.getLogger(SocketServer.class.getName()).log(Level.SEVERE, null, exception);
        }
    }

    public void setManager(SocketManager manager) {
        this.manager = manager;
    }

    private void handleInput(String message) {
        if (message == null)
            return;
        if (message.equals(""))
            return;
        if (manager == null)
            return;
        manager.handleMessage(message);
    }

    public void send(String message) {
        if (output != null)
            output.println(message);
    }
}
