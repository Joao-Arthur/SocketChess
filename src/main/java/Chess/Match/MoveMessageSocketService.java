package Chess.Match;

public class MoveMessageSocketService {
    private static final String FROM_X = "1";
    private static final String FROM_Y = "2";
    private static final String TO_X = "3";
    private static final String TO_Y = "4";
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
        final var fromX = decodeCoordinate(message, FROM_X);
        final var fromY = decodeCoordinate(message, FROM_Y);
        final var toX = decodeCoordinate(message, TO_X);
        final var toY = decodeCoordinate(message, TO_Y);
        return MovementDTO.from(fromX, fromY, toX, toY);
    }

    private static int decodeCoordinate(String message, String coordinate) {
        return Integer.parseInt(String.valueOf(message.charAt(format.indexOf(coordinate))));
    }
}
