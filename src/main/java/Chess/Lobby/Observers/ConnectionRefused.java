package Chess.Lobby.Observers;

import java.awt.Component;
import javax.swing.JOptionPane;
import Chess.Events.Observer;
import Chess.Socket.SocketMessages;

public class ConnectionRefused implements Observer {
    private final Component component;

    public ConnectionRefused(Component component) {
        this.component = component;
    }

    public void handle(String event) {
        if (!event.equals(SocketMessages.CONNECTION_REFUSED))
            return;
        JOptionPane.showMessageDialog(
                component,
                "Não foi possível encontrar um servidor socket rodando!", "Atenção!",
                JOptionPane.ERROR_MESSAGE);
        System.out.println("CONNECTION_REFUSED");
    }
}
