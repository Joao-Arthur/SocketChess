package Chess.Match;

import Chess.GUI.GUI;
import Chess.Lobby.LobbyScreen;
import Chess.Socket.SocketInstance;
import Chess.Socket.SocketMessages;
import Chess.Socket.SocketManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

final class MatchSocketManager implements SocketManager {
    public void handleMessage(String message) {
        switch (message) {
            case MatchMessages.GIVE_UP_MESSAGE:
                SocketInstance.close();
                JOptionPane.showMessageDialog(null, "Seu oponente desistiu.", "Vitória",
                        JOptionPane.INFORMATION_MESSAGE);
                GUI.getInstance().goTo(new LobbyScreen());
                break;
            case SocketMessages.NO_SUCH_ELEMENT:
                SocketInstance.close();
                JOptionPane.showMessageDialog(null, "Seu oponente abandonou a partida!", "Vitória",
                        JOptionPane.INFORMATION_MESSAGE);
                GUI.getInstance().goTo(new LobbyScreen());
                break;
            default:
                if (message.startsWith(MatchMessages.MOVE_MESSAGE_PREFIX)) {
                    MatchObserver.dispatch(MatchMessages.MOVE_MESSAGE_PREFIX, message);
                    break;
                }
                Logger.getLogger(MatchSocketManager.class.getName()).log(Level.WARNING,
                        new StringBuilder()
                                .append("Received message \"")
                                .append(message)
                                .append("\" is not valid.")
                                .toString());
        }
    }
}
