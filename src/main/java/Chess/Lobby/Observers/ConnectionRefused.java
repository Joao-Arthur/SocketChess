package Chess.Lobby.Observers;

import Chess.Events.Observer;
import Chess.Socket.SocketMessages;

public class ConnectionRefused implements Observer {
    public void handle(String event) {
        if (!event.equals(SocketMessages.CONNECTION_REFUSED))
            return;
        System.out.println("CONNECTION_REFUSED");
    }
}
