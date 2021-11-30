package Chess.Board.Piece;

import Chess.Board.Piece.MovePiece.MovePieceService;
import Chess.Board.Piece.MovePiece.MovePieceDTO;
import Chess.Board.Piece.MovePiece.InvalidMovementException;

public class Rook implements PieceInterface {
    public void movePiece(MovePieceDTO movePieceDTO) {
        final var moveService = new MovePieceService();
        moveService.execute(movePieceDTO);
        if (movePieceDTO.deltaX > 0 && movePieceDTO.deltaY > 0)
            throw new InvalidMovementException("deltaX > 0 && deltaY > 0");
    }
}
