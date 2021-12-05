package Chess.Match;

import java.awt.Point;
import Chess.GUI.GUI;
import Chess.Lobby.LobbyScreen;
import Chess.Match.Board.Controller;
import Chess.Match.Observers.MovePiece;
import Chess.Match.Observers.OpponentAbandoned;
import Chess.Match.Observers.OpponentGiveUp;
import Chess.Match.Services.MoveMessageSocketService;
import Chess.Socket.SocketInstance;
import java.awt.image.BufferedImage;
import javax.swing.JComponent;

public class MatchService {
    final Controller controller;
    final MatchDispatcher dispatcher;

    MatchService(JComponent panel) {
        controller = new Controller();
        dispatcher = new MatchDispatcher();
        dispatcher.register(new OpponentAbandoned(panel));
        dispatcher.register(new OpponentGiveUp(panel));
        dispatcher.register(new MovePiece(controller, panel));
        SocketInstance.get().setManager(new MatchSocketManager(dispatcher));
    }

    public BufferedImage getPieceImage(Point indexPoint) {
        return controller.getPieceImage(indexPoint);
    }

    public void giveUp() {
        SocketInstance.get()
                .send(MatchMessages.GIVE_UP_MESSAGE)
                .close();
        GUI.getInstance().goTo(new LobbyScreen());
    }

    public void movePiece(Movement movement) {
        controller.movePiece(movement);
        sendMovementToOpponent(movement);
    }

    private void sendMovementToOpponent(Movement movement) {
        SocketInstance.get().send(MoveMessageSocketService.encode(movement));
    }
}
