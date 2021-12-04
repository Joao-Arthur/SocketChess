package Chess.Match;

import Chess.GUI.GUI;
import Chess.Lobby.LobbyScreen;
import Chess.Socket.SocketInstance;
import java.awt.image.BufferedImage;

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

    public void movePiece(MovementDTO movement) {
        modelToView.movePiece(movement);
    }

    public void sendMovementToOpponent(MovementDTO movement) {
        SocketInstance.get().send(MoveMessageSocketService.encode(movement));
    }
}
