import Socket.SocketManager;

public class LobbySocketManager implements SocketManager {
    public void handleMessage(String message) {
        System.out.println("LobbySocketManager: " + message);
    }
}
