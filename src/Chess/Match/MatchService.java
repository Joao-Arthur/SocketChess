package Chess.Match;

import Chess.GUI.GUI;
import Chess.Lobby.LobbyScreen;
import Chess.Socket.SocketInstance;

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

    public void movePiece() {

    }
}
