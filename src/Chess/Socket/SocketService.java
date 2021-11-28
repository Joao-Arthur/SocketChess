package Socket;

public class SocketService {
    private static SocketService instance;
    static final int PORT = 54321;
    private SocketServer server;
    private SocketClient client;

    public static SocketService getInstance() {
        if (instance == null)
            instance = new SocketService();
        return instance;
    }

    public SocketServer createServer() {
        server = new SocketServer();
        return server;
    }

    public SocketClient createClient() {
        client = new SocketClient();
        return client;
    }

    public void send(String message) {
        System.out.println(message);
        client.send(message);
    }
}
