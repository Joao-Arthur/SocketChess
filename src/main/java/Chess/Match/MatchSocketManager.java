package Chess.Match;

import Chess.Socket.SocketManager;

final class MatchSocketManager implements SocketManager {
    final MatchDispatcher dispatcher;

    MatchSocketManager(MatchDispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    public void handleMessage(String message) {
        dispatcher.dispatch(message);
    }
}
