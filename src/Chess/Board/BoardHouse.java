package Board;

public class BoardHouse {
    public final BoardPiece piece;
    public final BoardPlayer player;

    public BoardHouse(BoardPiece piece, BoardPlayer player) {
        this.piece = piece;
        this.player = player;
    }

    @Override
    public String toString() {
        return player + "_" + piece;
    }
}