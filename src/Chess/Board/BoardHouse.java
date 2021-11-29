package Board;

import Board.Piece.PieceEnum;

public class BoardHouse {
    public final PieceEnum piece;
    public final BoardPlayer player;

    public BoardHouse(PieceEnum piece, BoardPlayer player) {
        this.piece = piece;
        this.player = player;
    }

    @Override
    public String toString() {
        return player + "_" + piece;
    }
}