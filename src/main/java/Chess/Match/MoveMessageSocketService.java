package Chess.Match;

public class MoveMessageSocketService {
    private static final String FROM_X = "1";
    private static final String FROM_Y = "2";
    private static final String TO_X = "3";
    private static final String TO_Y = "4";
    private static final String format = "MOVE: (" + FROM_X + "," + FROM_Y + ") -> (" + TO_X + "," + TO_Y + ")";

    public static String encode(MovementDTO movement) {
        final var fromX = String.valueOf(movement.from.x);
        final var fromY = String.valueOf(movement.from.y);
        final var toX = String.valueOf(movement.to.x);
        final var toY = String.valueOf(movement.to.y);
        return "MOVE: (" + fromX + "," + fromY + ") -> (" + toX + "," + toY + ")";
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
