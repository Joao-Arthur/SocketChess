package Board.Piece;

import Board.Piece.MovePiece.MovePieceDTO;
import Board.Piece.MovePiece.InvalidMovementException;

public class None implements PieceInterface {
    public void movePiece(MovePieceDTO movePieceDTO) {
        throw new InvalidMovementException("fromHouse.piece == PieceEnum.NONE");
    }
}