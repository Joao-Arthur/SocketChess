package Chess.Match.Observers;

import Chess.GUI.GUI;
import Chess.Lobby.LobbyScreen;
import Chess.Socket.SocketInstance;
import Chess.Socket.SocketMessages;
import javax.swing.JOptionPane;
import Chess.Events.Observer;

public class OpponentAbandoned implements Observer {
    public void handle(String event) {
        if (!event.equals(SocketMessages.NO_SUCH_ELEMENT))
            return;
        SocketInstance.close();
        JOptionPane.showMessageDialog(null, "Seu oponente abandonou a partida!", "Vitória",
                JOptionPane.INFORMATION_MESSAGE);
        GUI.getInstance().goTo(new LobbyScreen());
    }
}
