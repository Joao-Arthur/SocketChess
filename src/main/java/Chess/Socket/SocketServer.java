package Chess.Socket;

import java.io.IOException;
import java.io.PrintStream;
import java.net.BindException;
import java.net.ServerSocket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SocketServer implements SocketInterface {
    private final SocketService service = new SocketService();

    public SocketServer() {
        new Thread(() -> {
            try {
                final var socketServer = new ServerSocket(SocketConstants.PORT);
                final var socket = socketServer.accept();
                final var output = new PrintStream(socket.getOutputStream());
                final var input = new Scanner(socket.getInputStream());
                service.setParams(input, output, socket, socketServer);
            } catch (BindException exception) {
                service.manager.handleMessage(SocketMessages.PORT_IN_USE);
            } catch (IOException exception) {
                Logger.getLogger(SocketServer.class.getName()).log(Level.SEVERE, null, exception);
            }
        }).start();
    }

    public SocketServer setManager(SocketManager manager) {
        service.setManager(manager);
        return this;
    }

    public void receive(String message) {
        service.receive(message);
    }

    public SocketServer send(String message) {
        service.send(message);
        return this;
    }

    public void close() {
        service.close();
    }
}
