package Chess.Match.Board.Piece;

import Chess.Match.Board.Piece.MovePiece.InvalidMovementException;
import Chess.Match.Board.Piece.MovePiece.MovePieceDTO;

public class None implements PieceInterface {
    public void movePiece(MovePieceDTO movePieceDTO) {
        throw new InvalidMovementException("fromPiece = NONE");
    }
}