package Chess.Lobby.Observers;

import Chess.Events.Observer;
import Chess.Lobby.Services.CreateMatchMessageService;
import Chess.Match.Player.PlayerEnum;
import Chess.Socket.SocketInstance;
import Chess.Socket.SocketMessages;

public class ClientConnectionCreated implements Observer {
    public void handle(String event) {
        if (!event.equals(SocketMessages.CLIENT_CREATED))
            return;
        SocketInstance.get().send(CreateMatchMessageService.encode(PlayerEnum.BLACK));
    }
}
