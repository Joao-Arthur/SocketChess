package Chess.Board.Player;

public enum PlayerEnum {
    NONE("NONE"),
    WHITE("WHITE"),
    BLACK("BLACK");

    public final String name;

    PlayerEnum(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
