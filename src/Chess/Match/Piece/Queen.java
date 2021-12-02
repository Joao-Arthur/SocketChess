package Chess.Match.Piece;

import Chess.Match.Piece.MovePiece.MovePieceService;
import Chess.Match.Piece.MovePiece.MovePieceDTO;
import Chess.Match.Piece.MovePiece.InvalidMovementException;

public class Queen implements PieceInterface {
    public void movePiece(MovePieceDTO movePieceDTO) {
        final var moveService = new MovePieceService();
        moveService.execute(movePieceDTO);
        if ((movePieceDTO.deltaX > 0 && movePieceDTO.deltaY > 0) && (movePieceDTO.deltaX != movePieceDTO.deltaY))
            throw new InvalidMovementException("deltaX > 0 and deltaY > 0 and deltaX != deltaY");
    }
}