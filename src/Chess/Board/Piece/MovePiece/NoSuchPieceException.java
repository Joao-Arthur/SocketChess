package Board.Piece.MovePiece;

public class NoSuchPieceException extends RuntimeException {
    public NoSuchPieceException(String message) {
        super(message);
    }
}
