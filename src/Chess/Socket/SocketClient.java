package Chess.Socket;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SocketClient implements SocketInterface {
    private SocketService service;

    public SocketClient() {
        try {
            final var socket = new Socket(SocketConstants.URL, SocketConstants.PORT);
            final var output = new PrintStream(socket.getOutputStream());
            final var input = new Scanner(socket.getInputStream());
            service = new SocketService(input, output, socket, null);
        } catch (IOException exception) {
            Logger.getLogger(SocketClient.class.getName()).log(Level.SEVERE, null, exception);
        }
    }

    public void setManager(SocketManager manager) {
        service.setManager(manager);
    }

    public void receive(String message) {
        service.receive(message);
    }

    public void send(String message) {
        service.send(message);
    }

    public void close() {
        service.close();
    }
}
