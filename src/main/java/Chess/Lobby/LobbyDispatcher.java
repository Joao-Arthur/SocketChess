package Chess.Lobby;

import java.util.LinkedList;
import java.util.List;
import Chess.Events.Dispatcher;
import Chess.Events.Observer;

final class LobbyDispatcher implements Dispatcher {
    public final List<Observer> observers = new LinkedList<Observer>();

    public void dispatch(String event) {
        for (final var observer : observers)
            observer.handle(event);
    }

    public void register(Observer observer) {
        observers.add(observer);
    }
}
