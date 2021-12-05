package Chess.Match;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.awt.Component;
import Chess.GUI.GUI;
import Chess.Lobby.LobbyScreen;
import Chess.Match.Board.Controller;
import Chess.Match.Observers.MovePiece;
import Chess.Match.Observers.OpponentAbandoned;
import Chess.Match.Observers.OpponentGiveUp;
import Chess.Match.Services.MoveMessageSocketService;
import Chess.Socket.SocketInstance;

public class MatchService {
    final Controller controller;
    final MatchDispatcher dispatcher;

    MatchService(Component component) {
        controller = new Controller();
        dispatcher = new MatchDispatcher();
        dispatcher.register(new OpponentAbandoned(component));
        dispatcher.register(new OpponentGiveUp(component));
        dispatcher.register(new MovePiece(controller, component));
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
