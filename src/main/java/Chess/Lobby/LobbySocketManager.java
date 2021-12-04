package Chess.Lobby;

import java.util.logging.Level;
import java.util.logging.Logger;
import Chess.GUI.GUI;
import Chess.Match.MatchScreen;
import Chess.Socket.SocketManager;

final class LobbySocketManager implements SocketManager {
    public void handleMessage(String message) {
        if (message.startsWith(CreateMatchMessageService.PREFIX)) {
            GUI.getInstance().goTo(new MatchScreen(CreateMatchMessageService.decode(message)));
        } else {
            Logger.getLogger(LobbySocketManager.class.getName()).log(Level.WARNING,
                    new StringBuilder()
                            .append("Received message \"")
                            .append(message)
                            .append("\" is not valid.")
                            .toString());
        }
    }
}
