package Chess.Match;

import java.awt.Point;
import Chess.GUI.GUI;
import Chess.Lobby.LobbyScreen;
import Chess.Match.Observers.OpponentAbandoned;
import Chess.Match.Observers.OpponentGiveUp;
import Chess.Match.Services.MoveMessageSocketService;
import Chess.Socket.SocketInstance;
import java.awt.image.BufferedImage;

public class MatchService {
    final BoardController boardController;

    MatchService() {
        final MatchDispatcher dispatcher;
        dispatcher = new MatchDispatcher();
        dispatcher.register(new OpponentAbandoned());
        dispatcher.register(new OpponentGiveUp());
        dispatcher.register(new MovePiece())
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
