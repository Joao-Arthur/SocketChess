package Chess.Match.Piece;

import Chess.Match.Piece.MovePiece.MovePieceService;
import Chess.Match.Piece.MovePiece.MovePieceDTO;
import Chess.Match.Piece.MovePiece.InvalidMovementException;

public class King implements PieceInterface {
    public void movePiece(MovePieceDTO movePieceDTO) {
        final var moveService = new MovePieceService();
        moveService.execute(movePieceDTO);
        if (movePieceDTO.deltaX > 1 || movePieceDTO.deltaY > 1)
            throw new InvalidMovementException("deltaX > 1 || deltaY > 1");
    }
}