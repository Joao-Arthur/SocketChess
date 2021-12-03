package Chess.Socket;

public interface SocketInterface {
    public SocketInterface setManager(SocketManager manager);

    public void receive(String message);

    public SocketInterface send(String message);

    public void close();
}
