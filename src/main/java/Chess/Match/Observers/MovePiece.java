package Chess.Match.Observers;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import Chess.Events.Observer;
import Chess.Match.Board.BoardController;
import Chess.Match.Board.Piece.MovePiece.InvalidArgsException;
import Chess.Match.Board.Piece.MovePiece.InvalidMovementException;
import Chess.Match.Board.Piece.MovePiece.NoSuchPieceException;
import Chess.Match.Services.MoveMessageSocketService;

public class MovePiece implements Observer {
    private final BoardController boardController;
    private final JComponent component;

    public MovePiece(BoardController boardController, JComponent component) {
        this.boardController = boardController;
        this.component = component;
    }

    public void handle(String event) {
        if (!event.startsWith(MoveMessageSocketService.PREFIX))
            return;
        try {
            boardController.movePiece(MoveMessageSocketService.decode(event));
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
