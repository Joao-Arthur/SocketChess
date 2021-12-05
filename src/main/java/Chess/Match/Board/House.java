package Chess.Match.Board;

import Chess.Match.Board.Piece.PieceEnum;
import Chess.Match.Player.PlayerEnum;

public class House implements Printable {
    public final PieceEnum piece;
    public final PlayerEnum player;
    public final boolean hasMoved;

    public House(PlayerEnum player, PieceEnum piece) {
        this.piece = piece;
        this.player = player;
        hasMoved = false;
    }

    public House(House house) {
        this.piece = house.piece;
        this.player = house.player;
        hasMoved = true;
    }

    @Override
    public String toString() {
        return player + "_" + piece;
    }

    public String toCLI() {
        return CLIHouse.get(toString());
    }
}