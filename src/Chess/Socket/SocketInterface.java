package Chess.Socket;

public interface SocketInterface {
    public void setManager(SocketManager manager);

    public void receive(String message);

    public void send(String message);

    public void close();
}
