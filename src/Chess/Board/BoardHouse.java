package Board;

public class BoardHouse {
    public BoardPiece piece;
    public BoardPlayer player;

    public BoardHouse(BoardPiece piece, BoardPlayer player) {
        this.piece = piece;
        this.player = player;
    }
}