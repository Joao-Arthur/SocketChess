package Chess;

import Chess.Socket.SocketManager;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MatchSocketManager implements SocketManager {
    public void handleMessage(String message) {
        switch (message) {
            case "temp":
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
