package Chess.Match.Board.Piece;

import Chess.Match.Board.Piece.MovePiece.InvalidMovementException;
import Chess.Match.Board.Piece.MovePiece.MovePieceDTO;
import Chess.Match.Board.Piece.MovePiece.MovePieceService;

public class King implements PieceInterface {
    public void movePiece(MovePieceDTO movePieceDTO) {
        final var moveService = new MovePieceService();
        moveService.execute(movePieceDTO);
        if (movePieceDTO.deltaX > 1 || movePieceDTO.deltaY > 1)
            throw new InvalidMovementException("deltaX > 1 or deltaY > 1");
    }
}