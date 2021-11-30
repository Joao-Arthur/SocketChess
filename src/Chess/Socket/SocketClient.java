package Chess.Socket;

import java.io.IOException;
import java.io.PrintStream;
import java.io.InputStream;
import java.net.Socket;
import java.net.ConnectException;
import java.net.ServerSocket;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class SocketClient {
    PrintStream output;
    SocketManager manager;

    public SocketClient() {
        try {
            Socket client = new Socket("localhost", SocketService.PORT);
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
                // client.close();
            }).start();
        } catch (ConnectException exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage());
        } catch (IOException exception) {
            Logger.getLogger(SocketClient.class.getName()).log(Level.SEVERE, null, exception);
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
