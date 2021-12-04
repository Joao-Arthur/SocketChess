package Chess.Match;

import java.awt.Point;
import Chess.GUI.GUI;
import Chess.Lobby.LobbyScreen;
import Chess.Socket.SocketInstance;
import java.awt.image.BufferedImage;

public class MatchService {
    BoardController boardController;

    MatchService() {
        SocketInstance.get().setManager(new MatchSocketManager());
        boardController = new BoardController();
    }

    public BufferedImage getPieceImage(Point indexPoint) {
        return boardController.getPieceImage(indexPoint);
    }

    public void giveUp() {
        SocketInstance.get()
                .send(MatchMessages.GIVE_UP_MESSAGE)
                .close();
        GUI.getInstance().goTo(new LobbyScreen());
    }

    public void movePiece(MovementDTO movement) {
        boardController.movePiece(movement);
        sendMovementToOpponent(movement);
    }

    private void sendMovementToOpponent(MovementDTO movement) {
        SocketInstance.get().send(MoveMessageSocketService.encode(movement));
    }
}
