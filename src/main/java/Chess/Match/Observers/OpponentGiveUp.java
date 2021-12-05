package Chess.Match.Observers;

import javax.swing.JComponent;
import javax.swing.JOptionPane;
import Chess.GUI.GUI;
import Chess.Lobby.LobbyScreen;
import Chess.Match.MatchMessages;
import Chess.Socket.SocketInstance;
import Chess.Events.Observer;

public class OpponentGiveUp implements Observer {
    private final JComponent component;

    public OpponentGiveUp(JComponent component) {
        this.component = component;
    }

    public void handle(String event) {
        if (!event.equals(MatchMessages.GIVE_UP_MESSAGE))
            return;
        SocketInstance.close();
        JOptionPane.showMessageDialog(component, "O oponente desistiu", "Vitória", JOptionPane.INFORMATION_MESSAGE);
        GUI.getInstance().goTo(new LobbyScreen());
    }
}
