package Chess.Match;

import Chess.GUI.GUI;
import Chess.Lobby.LobbyScreen;
import Chess.Socket.SocketInstance;
import java.awt.image.BufferedImage;
import java.awt.Point;

public class MatchService {
    ModelToView modelToView;

    MatchService() {
        SocketInstance.get().setManager(new MatchSocketManager());
        modelToView = new ModelToView();
    }

    public BufferedImage getPieceImage(int xIndex, int yIndex) {
        return modelToView.getPieceImage(xIndex, yIndex);
    }

    public void giveUp() {
        SocketInstance.get()
                .send(MatchMessages.GIVE_UP_MESSAGE)
                .close();
        GUI.getInstance().goTo(new LobbyScreen());
    }

    public void movePiece(Point from, Point to) {
        modelToView.movePiece(from, to);
    }

    public void sendMovementToOpponent(Point from, Point to) {
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
                        .append(to.y)
                        .append("]")
                        .append("[")
                        .append(to.x)
                        .append("]")
                        .toString());
    }
}
