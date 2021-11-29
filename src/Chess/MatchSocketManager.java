import Socket.SocketManager;

public class MatchSocketManager implements SocketManager {
    public void handleMessage(String message) {
        System.out.println("MatchSocketManager: " + message);
    }
}
