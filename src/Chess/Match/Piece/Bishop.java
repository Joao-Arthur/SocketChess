package Chess.Board.Piece;

import Chess.Board.Piece.MovePiece.MovePieceService;
import Chess.Board.Piece.MovePiece.MovePieceDTO;
import Chess.Board.Piece.MovePiece.InvalidMovementException;

public class Bishop implements PieceInterface {
    public void movePiece(MovePieceDTO movePieceDTO) {
        final var moveService = new MovePieceService();
        moveService.execute(movePieceDTO);
        if (movePieceDTO.deltaX != movePieceDTO.deltaY)
            throw new InvalidMovementException("deltaX != deltaY");
    }
}