package Chess.Match;

import java.awt.Point;

public class MoveMessageSocketService {
    private static final String FROM_X = "fx";
    private static final String FROM_Y = "fy";
    private static final String TO_X = "tx";
    private static final String TO_Y = "ty";
    private static final String format = "MOVE: (" + FROM_X + "," + FROM_Y + ") -> (" + TO_X + "," + TO_Y + ")";

    public static String encode(MovementDTO movement) {
        return encode(movement.from.x, movement.from.y, movement.to.x, movement.to.y);
    }

    private static String encode(int fromX, int fromY, int toX, int toY) {
        return format.replace(FROM_X, String.valueOf(fromX))
                .replace(FROM_Y, String.valueOf(fromY))
                .replace(TO_X, String.valueOf(toX))
                .replace(TO_Y, String.valueOf(toY));
    }

    public static MovementDTO decode(String message) {
        int fromX = decodeCoordinate(message, FROM_X);
        int fromY = decodeCoordinate(message, FROM_Y);
        int toX = decodeCoordinate(message, TO_X);
        int toY = decodeCoordinate(message, TO_Y);
        return new MovementDTO(new Point(fromX, fromY), new Point(toX, toY));
    }

    private static int decodeCoordinate(String message, String coordinate) {
        return Integer.valueOf(message.charAt(format.indexOf(coordinate)));
    }
}
