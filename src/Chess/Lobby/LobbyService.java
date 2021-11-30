package Chess.Lobby;

import Chess.Socket.SocketServer;
import Chess.Socket.SocketClient;

final class LobbyService {
    public static final String CREATE_MATCH_MESSAGE = "NEW_MATCH";

    public void createServerForMatch() {
        final var server = new SocketServer(new LobbySocketManager());
        server.send(CREATE_MATCH_MESSAGE);
    }

    public void createClientForMatch() {
        final var client = new SocketClient(new LobbySocketManager());
        client.send(CREATE_MATCH_MESSAGE);
    }
}
