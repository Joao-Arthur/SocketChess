package Chess.Socket;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SocketService {
    private SocketManager manager;
    private Scanner input;
    private PrintStream output;
    private Socket socket;
    private ServerSocket serverSocket;
    private boolean isOpen = true;

    public void setParams(Scanner input, PrintStream output, Socket socket, ServerSocket serverSocket) {
        this.input = input;
        this.output = output;
        this.socket = socket;
        this.serverSocket = serverSocket;
        startObserving();
    }

    private void startObserving() {
        manager.handleMessage(serverSocket != null
                ? SocketMessages.SERVER_CREATED
                : SocketMessages.CLIENT_CREATED);
        new Thread(() -> {
            try {
                while (isOpen)
                    receive(input.nextLine());
            } catch (NoSuchElementException exception) {
                manager.handleMessage(SocketMessages.NO_SUCH_ELEMENT);
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
        Logger.getLogger(SocketService.class.getName()).log(Level.INFO, message);
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
