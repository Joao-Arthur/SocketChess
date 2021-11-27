package Board;

public enum BoardPiece {
    NONE("NONE"),
    KING("KING"),
    QUEEN("QUEEN"),
    ROOK("ROOK"),
    KNIGTH("KNIGTH"),
    BISHOP("BISHOP"),
    PAWN("PAWN");

    public final String name;

    BoardPiece(final String name) {
        this.name = name;
    }
}
