package Board;

public enum BoardPiece {
    NONE("NONE"),
    KING("KING"),
    QUEEN("QUEEN"),
    ROOK("ROOK"),
    KNIGHT("KNIGHT"),
    BISHOP("BISHOP"),
    PAWN("PAWN");

    public final String name;

    BoardPiece(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
