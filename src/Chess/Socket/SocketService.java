package Chess.Socket;

public class SocketService {
    private static SocketService instance;
    public static final String URL = "localhost";
    public static final int PORT = 54321;

    public static SocketService getInstance() {
        if (instance == null)
            instance = new SocketService();
        return instance;
    }


}
