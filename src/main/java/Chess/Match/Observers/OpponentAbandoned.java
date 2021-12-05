package Chess.Match.Observers;

import javax.swing.JComponent;
import javax.swing.JOptionPane;
import Chess.GUI.GUI;
import Chess.Lobby.LobbyScreen;
import Chess.Socket.SocketInstance;
import Chess.Socket.SocketMessages;
import Chess.Events.Observer;

public class OpponentAbandoned implements Observer {
    private final JComponent component;

    public OpponentAbandoned(JComponent component) {
        this.component = component;
    }

    public void handle(String event) {
        if (!event.equals(SocketMessages.NO_SUCH_ELEMENT))
            return;
        SocketInstance.close();
        JOptionPane.showMessageDialog(component, "O oponente abandonou a partida", "Vitória",
                JOptionPane.INFORMATION_MESSAGE);
        GUI.getInstance().goTo(new LobbyScreen());
    }
}
