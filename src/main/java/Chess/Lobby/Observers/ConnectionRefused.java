package Chess.Lobby.Observers;

import javax.swing.JOptionPane;
import Chess.Events.Observer;
import Chess.GUI.GUIScreen;
import Chess.Socket.SocketMessages;

public class ConnectionRefused implements Observer {
    private final GUIScreen component;

    public ConnectionRefused(GUIScreen component) {
        this.component = component;
    }

    public void handle(String event) {
        if (!event.equals(SocketMessages.CONNECTION_REFUSED))
            return;
        component.enable();
        JOptionPane.showMessageDialog(
                component.getScreen(),
                "Não foi possível encontrar um servidor socket rodando!", "Atenção!",
                JOptionPane.ERROR_MESSAGE);
    }
}
