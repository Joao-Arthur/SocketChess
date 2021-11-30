package Board.Piece;

import Board.Piece.MovePiece.MovePieceService;
import Board.Piece.MovePiece.MovePieceDTO;

public class Bishop implements PieceInterface {
    public void movePiece(MovePieceDTO movePieceDTO) {
        final var moveService = new MovePieceService();
        moveService.execute(movePieceDTO);
    }
}