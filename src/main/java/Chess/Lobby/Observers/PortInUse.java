package Chess.Lobby.Observers;

import javax.swing.JOptionPane;
import Chess.Events.Observer;
import Chess.GUI.GUIScreen;
import Chess.Socket.SocketMessages;

public class PortInUse implements Observer {
    private final GUIScreen component;

    public PortInUse(GUIScreen component) {
        this.component = component;
    }

    public void handle(String event) {
        if (!event.equals(SocketMessages.PORT_IN_USE))
            return;
        component.enable();
        JOptionPane.showMessageDialog(
                component.getScreen(),
                "A porta utilizada pelo socket já está em uso!", "Atenção!",
                JOptionPane.ERROR_MESSAGE);
    }
}
