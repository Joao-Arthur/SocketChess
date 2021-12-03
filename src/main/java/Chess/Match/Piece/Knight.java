package Chess.Match.Piece;

import Chess.Match.Piece.MovePiece.MovePieceService;
import Chess.Match.Piece.MovePiece.MovePieceDTO;
import Chess.Match.Piece.MovePiece.InvalidMovementException;

public class Knight implements PieceInterface {
    public void movePiece(MovePieceDTO movePieceDTO) {
        final var moveService = new MovePieceService();
        moveService.execute(movePieceDTO);
        if ((movePieceDTO.deltaY != 2 || movePieceDTO.deltaX != 1)
                && (movePieceDTO.deltaX != 2 || movePieceDTO.deltaY != 1))
            throw new InvalidMovementException("deltaY != 2 or deltaX != 1) and (deltaX != 2 or deltaY != 1");
    }
}