package Chess.Lobby.Observers;

import java.awt.Component;
import javax.swing.JOptionPane;
import Chess.Events.Observer;
import Chess.Socket.SocketMessages;

public class PortInUse implements Observer {
    private final Component component;

    public PortInUse(Component component) {
        this.component = component;
    }

    public void handle(String event) {
        if (!event.equals(SocketMessages.PORT_IN_USE))
            return;
        JOptionPane.showMessageDialog(
                component,
                "A porta utilizada pelo socket já está em uso!", "Atenção!",
                JOptionPane.ERROR_MESSAGE);
        System.out.println("PORT_IN_USE");
    }
}
