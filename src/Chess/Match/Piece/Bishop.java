package Chess.Match.Piece;

import Chess.Match.Piece.MovePiece.MovePieceService;
import Chess.Match.Piece.MovePiece.MovePieceDTO;
import Chess.Match.Piece.MovePiece.InvalidMovementException;

public class Bishop implements PieceInterface {
    public void movePiece(MovePieceDTO movePieceDTO) {
        final var moveService = new MovePieceService();
        moveService.execute(movePieceDTO);
        if (movePieceDTO.deltaX != movePieceDTO.deltaY)
            throw new InvalidMovementException("deltaX != deltaY");
    }
}