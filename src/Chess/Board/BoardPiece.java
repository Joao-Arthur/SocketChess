package Board;

public enum BoardPiece {
    NONE("NONE"), KING("KING"), QUEEN("QUEEN"), ROOK("ROOK"), KNIGTH("KNIGTH"), BISHOP("BISHOP"), PAWN("PAWN");

    public final String name;

    BoardPiece(final String name) {
        this.name = name;
    }

    public String toString() {
        switch (this) {
        case NONE:
            return " ";
        case KING:
            return "K";
        case QUEEN:
            return "Q";
        case ROOK:
            return "R";
        case KNIGTH:
            return "N";
        case BISHOP:
            return "B";
        case PAWN:
            return "P";
        default:
            return "-";
        }
    }
}
