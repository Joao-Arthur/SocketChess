package Chess.Socket;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SocketServer implements SocketInterface {
    PrintStream output;
    SocketManager manager;
    private boolean isOpen;

    public SocketServer(SocketManager manager) {
        this.manager = manager;
        isOpen = true;
        try {
            ServerSocket server = new ServerSocket(SocketService.PORT);
            Socket client = server.accept();
            output = new PrintStream(client.getOutputStream());
            new Thread(() -> {
                while (isOpen) {
                    try {
                        Scanner input = new Scanner(client.getInputStream());
                        receive(input.nextLine());
                    } catch (IOException exception) {
                        Logger.getLogger(SocketServer.class.getName()).log(Level.SEVERE, null, exception);
                    }
                }
                try  {
                    output.close();
                    client.close();
                    server.close();
                } catch (IOException exception) {
                    Logger.getLogger(SocketServer.class.getName()).log(Level.SEVERE, null, exception);
                }
            }).start();
        } catch (IOException exception) {
            Logger.getLogger(SocketServer.class.getName()).log(Level.SEVERE, null, exception);
        }
    }

    public void receive(String message) {
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

    public void close() {
        isOpen = false;
    }
}
