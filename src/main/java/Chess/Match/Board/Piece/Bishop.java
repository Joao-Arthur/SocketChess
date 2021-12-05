package Chess.Match.Board.Piece;

import Chess.Match.Board.Piece.MovePiece.InvalidMovementException;
import Chess.Match.Board.Piece.MovePiece.MovePieceDTO;
import Chess.Match.Board.Piece.MovePiece.MovePieceService;

public class Bishop implements PieceInterface {
    public void movePiece(MovePieceDTO movePieceDTO) {
        final var moveService = new MovePieceService();
        moveService.execute(movePieceDTO);
        if (movePieceDTO.deltaX != movePieceDTO.deltaY)
            throw new InvalidMovementException("deltaX != deltaY");
    }
}