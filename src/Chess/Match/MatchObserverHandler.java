package Chess.Match;

import javax.swing.JComponent;

public class MatchObserverHandler implements MatchObserverInterface {
    private final MatchService matchService;
    private final JComponent component;

    public MatchObserverHandler(MatchService matchService, JComponent component) {
        this.matchService = matchService;
        this.component = component;
    }

    public void handle(String event) {
        matchService.movePiece(MoveMessageSocketService.decode(event));
        component.repaint();
    }

    public String getType() {
        return MatchMessages.MOVE_MESSAGE_PREFIX;
    }
}
