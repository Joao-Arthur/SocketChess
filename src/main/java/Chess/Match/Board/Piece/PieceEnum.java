package Chess.Match.Board.Piece;

public enum PieceEnum {
    NONE("NONE"),
    KING("KING"),
    QUEEN("QUEEN"),
    ROOK("ROOK"),
    KNIGHT("KNIGHT"),
    BISHOP("BISHOP"),
    PAWN("PAWN");

    public final String name;

    PieceEnum(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
