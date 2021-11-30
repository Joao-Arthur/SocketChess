package Chess.Socket;

public class Socket {
    private static SocketInterface socket;

    public static SocketInterface create(SocketInterface socket) {
        Socket.socket = socket;
        return socket;
    }

    public static SocketInterface get() {
        return socket;
    }
}
