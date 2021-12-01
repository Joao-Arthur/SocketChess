package Chess.Lobby;

import Chess.Socket.SocketServer;
import Chess.Socket.SocketInstance;
import Chess.Socket.SocketClient;

final class LobbyService {

    public void createServerForMatch() {
        SocketInstance.create(new SocketServer())
                .setManager(new LobbySocketManager())
                .send(LobbyMessages.NEW_MATCH_MESSAGE);
    }

    public void createClientForMatch() {
        SocketInstance.create(new SocketClient())
                .setManager(new LobbySocketManager())
                .send(LobbyMessages.NEW_MATCH_MESSAGE);
    }
}
