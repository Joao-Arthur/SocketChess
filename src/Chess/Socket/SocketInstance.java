package Chess.Socket;

public class SocketInstance {
    private static SocketInterface socket;

    public static SocketInterface create(SocketInterface socket) {
        SocketInstance.socket = socket;
        return socket;
    }

    public static SocketInterface get() {
        return socket;
    }

    public static void close() {
        socket.close();
        socket = null;
    }
}
