package Board;
public enum BoardPlayer {
    NONE("NONE"),
    WHITE("WHITE"),
    BLACK("BLACK");

    public final String name;

    BoardPlayer(final String name) {
        this.name = name;
    }
}
