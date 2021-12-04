package Chess.Match;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import Chess.Match.Piece.MovePiece.InvalidArgsException;
import Chess.Match.Piece.MovePiece.InvalidMovementException;
import Chess.Match.Piece.MovePiece.NoSuchPieceException;

public class MatchObserverHandler implements MatchObserverInterface {
    private final MatchService matchService;
    private final JComponent component;

    public MatchObserverHandler(MatchService matchService, JComponent component) {
        this.matchService = matchService;
        this.component = component;
    }

    public void handle(String event) {
        try {
            matchService.movePiece(MoveMessageSocketService.decode(event));
            component.repaint();
        } catch (InvalidArgsException exception) {
            Logger.getLogger(MatchObserverHandler.class.getName()).log(Level.SEVERE, null, exception);
        } catch (InvalidMovementException exception) {
            // Logger.getLogger(MatchObserverHandler.class.getName()).log(Level.INFO, null,
            // exception);
        } catch (NoSuchPieceException exception) {
            // Logger.getLogger(MatchObserverHandler.class.getName()).log(Level.INFO, null,
            // exception);
        }

    }

    public String getType() {
        return MatchMessages.MOVE_MESSAGE_PREFIX;
    }
}
