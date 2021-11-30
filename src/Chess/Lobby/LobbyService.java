package Chess.Lobby;

import Chess.Socket.SocketService;

final class LobbyService {
    public static final String CREATE_MATCH_MESSAGE = "NEW_MATCH";

    public void createServerForMatch() {
        SocketService.getInstance()
                .createServer()
                .setManager(new LobbySocketManager())
                .send(CREATE_MATCH_MESSAGE);
    }

    public void createClientForMatch() {
        SocketService.getInstance()
                .createClient()
                .setManager(new LobbySocketManager())
                .send(CREATE_MATCH_MESSAGE);
    }
}
