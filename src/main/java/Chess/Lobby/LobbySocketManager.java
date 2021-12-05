package Chess.Lobby;

import Chess.Socket.SocketManager;

final class LobbySocketManager implements SocketManager {
    final LobbyDispatcher dispatcher;

    LobbySocketManager(LobbyDispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    public void handleMessage(String message) {
        dispatcher.dispatch(message);
    }
}
