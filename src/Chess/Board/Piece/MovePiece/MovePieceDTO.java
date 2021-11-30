package Board.Piece.MovePiece;

import Board.BoardHouse;
import java.awt.Point;

public class MovePieceDTO {
    public final Point from;
    public final BoardHouse fromHouse;
    public final Point to;
    public final BoardHouse toHouse;
    public final int distanceX;
    public final int deltaX;
    public final int distanceY;
    public final int deltaY;

    public MovePieceDTO(Point from, BoardHouse fromHouse, Point to, BoardHouse toHouse) {
        this.from = from;
        this.fromHouse = fromHouse;
        this.to = to;
        this.toHouse = toHouse;
        distanceX = (int) from.getX() - (int) to.getX();
        deltaX = Math.abs(distanceX);
        distanceY = (int) from.getY() - (int) to.getY();
        deltaY = Math.abs(distanceY);
    }
}
