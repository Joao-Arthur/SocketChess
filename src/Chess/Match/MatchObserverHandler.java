package Chess.Match;

import java.awt.Point;

import javax.swing.JComponent;

public class MatchObserverHandler implements MatchObserverInterface {
    private final MatchService matchService;
    private final JComponent component;

    public MatchObserverHandler(MatchService matchService, JComponent component) {
        this.matchService = matchService;
        this.component = component;
    }

    public void handle(String event) {
        final var fromY = Integer.parseInt(event.substring(10, 11));
        final var fromX = Integer.parseInt(event.substring(13, 14));
        final var toY = Integer.parseInt(event.substring(19, 20));
        final var toX = Integer.parseInt(event.substring(22, 23));
        matchService.movePiece(new Point(fromX, fromY), new Point(toX, toY));
        component.repaint();
    }

    public String getType() {
        return MatchMessages.MOVE_MESSAGE_PREFIX;
    }
}
