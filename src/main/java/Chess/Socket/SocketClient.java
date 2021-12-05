package Chess.Socket;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ConnectException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SocketClient implements SocketInterface {
    private final SocketService service = new SocketService();

    public SocketClient() {
        new Thread(() -> {
            try {
                final var socket = new Socket(SocketConstants.URL, SocketConstants.PORT);
                final var output = new PrintStream(socket.getOutputStream());
                final var input = new Scanner(socket.getInputStream());
                service.setParams(input, output, socket, null);
            } catch (ConnectException exception) {
                service.manager.handleMessage(SocketMessages.CONNECTION_REFUSED);
            } catch (IOException exception) {
                Logger.getLogger(SocketClient.class.getName()).log(Level.SEVERE, null, exception);
            }
        }).start();
    }

    public SocketClient setManager(SocketManager manager) {
        service.setManager(manager);
        return this;
    }

    public void receive(String message) {
        service.receive(message);
    }

    public SocketClient send(String message) {
        service.send(message);
        return this;
    }

    public void close() {
        service.close();
    }
}
