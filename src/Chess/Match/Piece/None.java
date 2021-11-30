package Chess.Match.Piece;

import Chess.Match.Piece.MovePiece.MovePieceDTO;
import Chess.Match.Piece.MovePiece.InvalidMovementException;

public class None implements PieceInterface {
    public void movePiece(MovePieceDTO movePieceDTO) {
        throw new InvalidMovementException("fromHouse.piece == PieceEnum.NONE");
    }
}