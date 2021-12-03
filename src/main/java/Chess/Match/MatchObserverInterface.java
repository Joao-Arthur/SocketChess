package Chess.Match;

public interface MatchObserverInterface {
    public void handle(String event);

    public String getType();
}
