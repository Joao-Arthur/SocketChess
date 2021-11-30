package Board.Piece;

import Board.Piece.MovePiece.MovePieceService;
import Board.Piece.MovePiece.MovePieceDTO;
import Board.Piece.MovePiece.InvalidMovementException;

public class Bishop implements PieceInterface {
    public void movePiece(MovePieceDTO movePieceDTO) {
        final var moveService = new MovePieceService();
        moveService.execute(movePieceDTO);
        if (movePieceDTO.deltaX != movePieceDTO.deltaY)
            throw new InvalidMovementException("deltaX != deltaY");
    }
}