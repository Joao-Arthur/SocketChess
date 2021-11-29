import Socket.SocketManager;

public class LobbySocketManager implements SocketManager {
    public void handleMessage(String message) {
        switch(message) {
            case NewMatchService.CREATE_MATCH_MESSAGE:
                WindowManager.getInstance().goToMatch();
        }
    }
}
