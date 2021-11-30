package Chess.Match;

import Chess.GUI.GUI;
import Chess.Lobby.LobbyScreen;
import Chess.Socket.SocketManager;
import java.util.logging.Level;
import java.util.logging.Logger;

final class MatchSocketManager implements SocketManager {
    public void handleMessage(String message) {
        switch (message) {
            case MatchMessages.GIVE_UP_MESSAGE:
                System.out.println("GIVE_UP_MESSAGE");
                // GUI.getInstance().goTo(new LobbyScreen());
                break;
            default:
                Logger.getLogger(MatchSocketManager.class.getName()).log(Level.WARNING,
                        new StringBuilder()
                                .append("Received message \"")
                                .append(message)
                                .append("\" is not valid.")
                                .toString());
        }
    }
}
