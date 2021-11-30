package Chess.Socket;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.ConnectException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class SocketClient implements SocketInterface {
    PrintStream output;
    SocketManager manager;
    private boolean isOpen;

    public SocketClient(SocketManager manager) {
        this.manager = manager;
        isOpen = true;
        try {
            Socket client = new Socket(SocketService.URL, SocketService.PORT);
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
                } catch (IOException exception) {
                    Logger.getLogger(SocketServer.class.getName()).log(Level.SEVERE, null, exception);
                }
            }).start();
        } catch (ConnectException exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage());
        } catch (IOException exception) {
            Logger.getLogger(SocketClient.class.getName()).log(Level.SEVERE, null, exception);
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
