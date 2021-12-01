package Chess.Lobby;

import Chess.Socket.SocketServer;
import Chess.Socket.SocketInstance;
import Chess.Socket.SocketClient;

final class LobbyService {

    public void createServerForMatch() {
        SocketInstance.create(new SocketServer());
        SocketInstance.get().setManager(new LobbySocketManager());
        SocketInstance.get().send(LobbyMessages.NEW_MATCH_MESSAGE);
    }

    public void createClientForMatch() {
        SocketInstance.create(new SocketClient());
        SocketInstance.get().setManager(new LobbySocketManager());
        SocketInstance.get().send(LobbyMessages.NEW_MATCH_MESSAGE);
    }
}
