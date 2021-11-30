package Chess.Lobby;

import java.util.logging.Level;
import java.util.logging.Logger;
import Chess.Socket.SocketManager;
import Chess.WindowManager;

final class LobbySocketManager implements SocketManager {
    public void handleMessage(String message) {
        switch (message) {
            case LobbyMessages.NEW_MATCH_MESSAGE:
                WindowManager.getInstance().goToMatch();
                break;
            default:
                Logger.getLogger(LobbySocketManager.class.getName()).log(Level.WARNING,
                        new StringBuilder()
                                .append("Received message \"")
                                .append(message)
                                .append("\" is not valid.")
                                .toString());
        }
    }
}
