package Chess.Match;

import Chess.GUI.GUI;
import Chess.Lobby.LobbyScreen;
import Chess.Socket.SocketInstance;
import java.awt.Point;

public class MatchService {
    MatchService() {
        SocketInstance.get().setManager(new MatchSocketManager());
    }

    public void giveUp() {
        SocketInstance.get()
                .send(MatchMessages.GIVE_UP_MESSAGE)
                .close();
        GUI.getInstance().goTo(new LobbyScreen());
    }

    public void movePiece(Point from, Point to) {
        SocketInstance.get().send(
            new StringBuilder("MOVE")
                .append("_")
                .append("FROM")
                .append("[")
                .append(from.y)
                .append("]")
                .append("[")
                .append(from.x)
                .append("]")
                .append("_")
                .append("TO")
                .append("[")
                .append(from.y)
                .append("]")
                .append("[")
                .append(from.x)
                .append("]")
                .toString()
        );
    }
}
