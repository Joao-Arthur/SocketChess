package Chess.Match.Observers;

import Chess.GUI.GUI;
import Chess.Lobby.LobbyScreen;
import Chess.Match.MatchMessages;
import Chess.Socket.SocketInstance;
import javax.swing.JOptionPane;
import Chess.Events.Observer;

public class OpponentGiveUp implements Observer {
    public void handle(String event) {
        if (!event.equals(MatchMessages.GIVE_UP_MESSAGE))
            return;
        SocketInstance.close();
        JOptionPane.showMessageDialog(null, "Seu oponente desistiu.", "Vitória",
                JOptionPane.INFORMATION_MESSAGE);
        GUI.getInstance().goTo(new LobbyScreen());
    }
}
