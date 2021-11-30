package Board.Piece;

import Board.Piece.MovePiece.MovePieceService;
import Board.Piece.MovePiece.MovePieceDTO;
import Board.Piece.MovePiece.InvalidMovementException;

public class Queen implements PieceInterface {
    public void movePiece(MovePieceDTO movePieceDTO) {
        final var moveService = new MovePieceService();
        moveService.execute(movePieceDTO);
        if ((movePieceDTO.deltaX > 0 && movePieceDTO.deltaY > 0) && (movePieceDTO.deltaX != movePieceDTO.deltaY))
            throw new InvalidMovementException("(deltaX > 0 && deltaY > 0) && (deltaX != deltaY)");
    }
}