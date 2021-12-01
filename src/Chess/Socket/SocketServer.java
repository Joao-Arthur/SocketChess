package Chess.Socket;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SocketServer implements SocketInterface {
    private SocketService service;

    public SocketServer() {
        try {
            final var socketServer = new ServerSocket(SocketConstants.PORT);
            final var socket = socketServer.accept();
            final var output = new PrintStream(socket.getOutputStream());
            final var input = new Scanner(socket.getInputStream());
            service = new SocketService(input, output, socket, socketServer);
        } catch (IOException exception) {
            Logger.getLogger(SocketServer.class.getName()).log(Level.SEVERE, null, exception);
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
