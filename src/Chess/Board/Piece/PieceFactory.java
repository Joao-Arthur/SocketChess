package Board.Piece;

public interface PieceFactory {
    public static PieceInterface from(final PieceEnum type) {
        switch (type) {
            case NONE:
                return new None();
            case KING:
                return new King();
            case QUEEN:
                return new Queen();
            case ROOK:
                return new Rook();
            case KNIGHT:
                return new Knight();
            case BISHOP:
                return new Bishop();
            case PAWN:
                return new Pawn();
            default:
                return null;
        }
    }
}
