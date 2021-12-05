package Chess.Lobby;

import java.awt.Component;
import Chess.Socket.SocketServer;
import Chess.Socket.SocketInstance;
import Chess.Lobby.Observers.ClientConnectionCreated;
import Chess.Lobby.Observers.ConnectionRefused;
import Chess.Lobby.Observers.CreateMatch;
import Chess.Lobby.Observers.PortInUse;
import Chess.Lobby.Observers.ServerConnectionCreated;
import Chess.Socket.SocketClient;

final class LobbyService {
    final LobbyDispatcher dispatcher;

    public LobbyService(Component frame) {
        dispatcher = new LobbyDispatcher();
        dispatcher.register(new CreateMatch());
        dispatcher.register(new ClientConnectionCreated());
        dispatcher.register(new ServerConnectionCreated());
        dispatcher.register(new ConnectionRefused(frame));
        dispatcher.register(new PortInUse(frame));
    }

    public void createServerForMatch() {
        SocketInstance
                .create(new SocketServer())
                .setManager(new LobbySocketManager(dispatcher));
    }

    public void createClientForMatch() {
        SocketInstance
                .create(new SocketClient())
                .setManager(new LobbySocketManager(dispatcher));
    }
}
