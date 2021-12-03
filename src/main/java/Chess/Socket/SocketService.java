package Chess.Socket;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SocketService {
    private SocketManager manager;
    private final Scanner input;
    private final PrintStream output;
    private final Socket socket;
    private final ServerSocket serverSocket;
    private boolean isOpen = true;

    public SocketService(Scanner input, PrintStream output, Socket socket, ServerSocket serverSocket) {
        this.input = input;
        this.output = output;
        this.socket = socket;
        this.serverSocket = serverSocket;
        startObserving();
    }

    private void startObserving() {
        new Thread(() -> {
            while (isOpen) {
                receive(input.nextLine());
            }
            try {
                input.close();
                output.close();
                socket.close();
                if (serverSocket != null)
                    serverSocket.close();
            } catch (IOException exception) {
                Logger.getLogger(SocketServer.class.getName()).log(Level.SEVERE, null, exception);
            }
        }).start();
    }

    public void setManager(SocketManager manager) {
        this.manager = manager;
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
