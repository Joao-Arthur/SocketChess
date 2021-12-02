package Chess.Match;

import java.awt.Point;

public class MatchObserverHandler implements MatchObserverInterface {
    private final MatchService matchService;

    public MatchObserverHandler(MatchService matchService) {
        this.matchService = matchService;
    }

    public void handle(String event) {
        final var fromY = Integer.parseInt(event.substring(10, 11));
        final var fromX = Integer.parseInt(event.substring(13, 14));
        final var toY = Integer.parseInt(event.substring(19, 20));
        final var toX = Integer.parseInt(event.substring(22, 23));
        matchService.movePiece(new Point(fromX, fromY), new Point(toX, toY));

    }

    public String getType() {
        return MatchMessages.MOVE_MESSAGE_PREFIX;
    }
}
