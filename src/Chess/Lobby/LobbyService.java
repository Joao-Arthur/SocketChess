package Chess.Lobby;

import Chess.Socket.SocketServer;
import Chess.Socket.Socket;
import Chess.Socket.SocketClient;

final class LobbyService {

    public void createServerForMatch() {
        final var server = Socket.create(new SocketServer(new LobbySocketManager()));
        server.send(LobbyMessages.NEW_MATCH_MESSAGE);
    }

    public void createClientForMatch() {
        final var client = Socket.create(new SocketClient(new LobbySocketManager()));
        client.send(LobbyMessages.NEW_MATCH_MESSAGE);
    }
}
