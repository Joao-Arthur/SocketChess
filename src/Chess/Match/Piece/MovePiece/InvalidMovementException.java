package Chess.Board.Piece.MovePiece;

public class InvalidMovementException extends RuntimeException {
    public InvalidMovementException(String message) {
        super(message);
    }
}
