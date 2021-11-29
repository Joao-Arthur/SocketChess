package Board.Piece;

import Board.Piece.MovePiece.MovePieceService;

public class Knight implements PieceInterface {
    public void movePiece() {
        final var moveService = new MovePieceService();
        moveService.execute();
    }
}