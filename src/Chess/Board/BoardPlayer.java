package Board;

public enum BoardPlayer {
    NONE("NONE"), WHITE("WHITE"), BLACK("BLACK");

    public final String name;

    BoardPlayer(final String name) {
        this.name = name;
    }

    public String toString() {
        switch (this) {
        case NONE:
            return " ";
        case WHITE:
            return "W";
        case BLACK:
            return "B";
        default:
            return "-";
        }
    }
}
