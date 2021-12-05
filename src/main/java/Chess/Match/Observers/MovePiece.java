package Chess.Match.Observers;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import Chess.Events.Observer;
import Chess.Match.MatchMessages;
import Chess.Match.MatchService;
import Chess.Match.Piece.MovePiece.InvalidArgsException;
import Chess.Match.Piece.MovePiece.InvalidMovementException;
import Chess.Match.Piece.MovePiece.NoSuchPieceException;
import Chess.Match.Services.MoveMessageSocketService;

public class MovePiece implements Observer {
    private final MatchService matchService;
    private final JComponent component;

    public MovePiece(MatchService matchService, JComponent component) {
        this.matchService = matchService;
        this.component = component;
    }

    public void handle(String event) {
        if (!event.startsWith(MatchMessages.MOVE_MESSAGE_PREFIX))
            return;
        try {
            matchService.movePiece(MoveMessageSocketService.decode(event));
            component.repaint();
        } catch (InvalidArgsException exception) {
            Logger.getLogger(MovePiece.class.getName()).log(Level.SEVERE, null, exception);
        } catch (InvalidMovementException exception) {
            // Logger.getLogger(MatchObserverHandler.class.getName()).log(Level.INFO, null,
            // exception);
        } catch (NoSuchPieceException exception) {
            // Logger.getLogger(MatchObserverHandler.class.getName()).log(Level.INFO, null,
            // exception);
        }
    }
}
