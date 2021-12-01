package Chess.Match;

import Chess.Socket.SocketInstance;

public class MatchService {
    MatchService() {
        SocketInstance.get().setManager(new MatchSocketManager());
    }

    public void giveUp() {
        SocketInstance.get().send(MatchMessages.GIVE_UP_MESSAGE);
        SocketInstance.close();
    }

    public void movePiece() {

    }
}
