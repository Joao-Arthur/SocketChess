package Chess.Socket;

//transformar em interface e factory
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

    public SocketService createServer() {
        server = new SocketServer();
        return this;
    }

    public SocketService createClient() {
        client = new SocketClient();
        return this;
    }

    public SocketService send(String message) {
        if (server != null)
            server.send(message);
        if (client != null)
            client.send(message);
        return this;
    }

    public SocketService setManager(SocketManager manager) {
        if (server != null)
            server.setManager(manager);
        if (client != null)
            client.setManager(manager);
        return this;
    }
}
