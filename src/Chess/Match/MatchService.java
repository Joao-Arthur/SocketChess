package Chess.Match;

import Chess.Socket.Socket;
import Chess.Socket.SocketInterface;

public class MatchService {
    public void giveUp() {
        final var socket = Socket.get();
        socket.send(MatchMessages.GIVE_UP_MESSAGE);
    }

    public void movePiece() {

    }
}
