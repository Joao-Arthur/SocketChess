package Chess.Board.Piece;

import Chess.Board.Piece.MovePiece.MovePieceDTO;
import Chess.Board.Piece.MovePiece.InvalidMovementException;

public class None implements PieceInterface {
    public void movePiece(MovePieceDTO movePieceDTO) {
        throw new InvalidMovementException("fromHouse.piece == PieceEnum.NONE");
    }
}