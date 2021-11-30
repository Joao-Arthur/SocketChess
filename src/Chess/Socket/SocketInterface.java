package Chess.Socket;

public interface SocketInterface {
    public void receive(String message);
    public void send(String message);
    public void close();
}
