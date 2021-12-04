package Chess.Lobby;

import Chess.Socket.SocketServer;
import Chess.Socket.SocketInstance;
import Chess.Match.Player.PlayerEnum;
import Chess.Socket.SocketClient;

final class LobbyService {
    public void createServerForMatch() {
        SocketInstance.create(new SocketServer())
                .setManager(new LobbySocketManager())
                .send(CreateMatchMessageService.encode(PlayerEnum.WHITE));
    }

    public void createClientForMatch() {
        SocketInstance.create(new SocketClient())
                .setManager(new LobbySocketManager())
                .send(CreateMatchMessageService.encode(PlayerEnum.BLACK));
    }
}
