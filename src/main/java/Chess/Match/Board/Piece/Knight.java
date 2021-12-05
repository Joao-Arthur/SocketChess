package Chess.Match.Board.Piece;

import Chess.Match.Board.Piece.MovePiece.InvalidMovementException;
import Chess.Match.Board.Piece.MovePiece.MovePieceDTO;
import Chess.Match.Board.Piece.MovePiece.MovePieceService;

public class Knight implements PieceInterface {
    public void movePiece(MovePieceDTO movePieceDTO) {
        final var moveService = new MovePieceService();
        moveService.execute(movePieceDTO);
        if ((movePieceDTO.deltaY != 2 || movePieceDTO.deltaX != 1)
                && (movePieceDTO.deltaX != 2 || movePieceDTO.deltaY != 1))
            throw new InvalidMovementException("deltaY != 2 or deltaX != 1) and (deltaX != 2 or deltaY != 1");
    }
}