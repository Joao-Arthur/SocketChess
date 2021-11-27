package Board;

public class BoardHouse {
    BoardPiece piece;
    BoardPlayer player;

    public BoardHouse(BoardPiece piece, BoardPlayer player) {
        this.piece = piece;
        this.player = player;
    }

    @Override
    public String toString() {
        return player + "" + piece;
    }
}