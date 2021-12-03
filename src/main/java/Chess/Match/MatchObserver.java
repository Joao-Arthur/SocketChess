package Chess.Match;

import java.util.List;
import java.util.LinkedList;

public class MatchObserver {
    public static List<MatchObserverInterface> observers = new LinkedList<MatchObserverInterface>();

    public static void dispatch(String type, String payload) {
        for (final var observer : observers) {
            if (observer.getType().equals(type)) {
                observer.handle(payload);
            }
        }
    }

    public static void register(MatchObserverInterface observer) {
        observers.add(observer);
    }
}
