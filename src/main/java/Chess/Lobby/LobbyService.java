package Chess.Lobby;

import Chess.Socket.SocketServer;
import Chess.Socket.SocketInstance;
import Chess.Lobby.Observers.CreateMatchObserver;
import Chess.Lobby.Services.CreateMatchMessageService;
import Chess.Match.Player.PlayerEnum;
import Chess.Socket.SocketClient;

final class LobbyService {
    final LobbyDispatcher dispatcher;

    public LobbyService() {
        dispatcher = new LobbyDispatcher();
        dispatcher.register(new CreateMatchObserver());
    }

    public void createServerForMatch() {
        SocketInstance.create(new SocketServer())
                .setManager(new LobbySocketManager(dispatcher))
                .send(CreateMatchMessageService.encode(PlayerEnum.WHITE));
    }

    public void createClientForMatch() {
        SocketInstance.create(new SocketClient())
                .setManager(new LobbySocketManager(dispatcher))
                .send(CreateMatchMessageService.encode(PlayerEnum.BLACK));
    }
}
