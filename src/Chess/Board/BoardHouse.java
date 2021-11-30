package Chess.Board;

import Chess.Board.Piece.PieceEnum;
import Chess.Board.Player.PlayerEnum;

public class BoardHouse {
    public final PieceEnum piece;
    public final PlayerEnum player;
    public final boolean hasMoved;

    public BoardHouse(PlayerEnum player, PieceEnum piece) {
        this.piece = piece;
        this.player = player;
        hasMoved = false;
    }

    public BoardHouse(BoardHouse house) {
        this.piece = house.piece;
        this.player = house.player;
        hasMoved = true;
    }

    @Override
    public String toString() {
        return new StringBuilder().append(player).append("_").append(piece).toString();
    }
}