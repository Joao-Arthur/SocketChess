package Chess.Match.Board.Piece.MovePiece;

import java.awt.Point;
import Chess.Match.Board.House;
import Chess.Match.Player.PlayerEnum;

public class MovePieceDTO {
    public final PlayerEnum player;
    public final Point from;
    public final House fromHouse;
    public final Point to;
    public final House toHouse;
    public final int distanceX;
    public final int deltaX;
    public final int distanceY;
    public final int deltaY;

    public MovePieceDTO(PlayerEnum player, Point from, House fromHouse, Point to, House toHouse) {
        this.player = player;
        this.from = from;
        this.fromHouse = fromHouse;
        this.to = to;
        this.toHouse = toHouse;
        distanceX = from.x - to.x;
        deltaX = Math.abs(distanceX);
        distanceY = from.y - to.y;
        deltaY = Math.abs(distanceY);
    }
}
