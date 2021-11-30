package Board.Piece;

import Board.Piece.MovePiece.InvalidMovementException;
import Board.Piece.MovePiece.MovePieceDTO;

public class None implements PieceInterface {
    public void movePiece(MovePieceDTO movePieceDTO) {
        throw new InvalidMovementException("fromHouse.piece == PieceEnum.NONE");
    }
}