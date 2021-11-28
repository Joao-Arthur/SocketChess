package Socket;

import java.io.IOException;
import java.io.PrintStream;
import java.io.InputStream;
import java.net.Socket;
import java.net.ConnectException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class SocketClient {
    InputStream servidor;
    Socket client;
    PrintStream output;

    public SocketClient() {
        // new Thread(() -> {
        try {
            client = new Socket("localhost", SocketService.PORT);
            output = new PrintStream(client.getOutputStream());
        } catch (ConnectException exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage());
        } catch (IOException exception) {
            Logger.getLogger(SocketClient.class.getName()).log(Level.SEVERE, null, exception);
        }
        // }).start();
    }

    public void send(String message) {
        System.out.println(output);
        if (output != null)
            output.println(message);
    }
}
