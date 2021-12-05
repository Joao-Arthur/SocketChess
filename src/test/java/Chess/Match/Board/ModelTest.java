package Chess.Match.Board;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ModelTest {
    final String initialBoard = new StringBuilder()
            .append("♜♞♝♚♛♝♞♜").append("\n")
            .append("♟️♟️♟️♟️♟️♟️♟️♟️").append("\n")
            .append("        ").append("\n")
            .append("        ").append("\n")
            .append("        ").append("\n")
            .append("        ").append("\n")
            .append("♙♙♙♙♙♙♙♙").append("\n")
            .append("♖♘♗♔♕♗♘♖").append("\n")
            .toString();

    @Test
    @DisplayName("Should mount initial state into a printable form")
    public void toCLI() {
        assertEquals(initialBoard, new Model().toCLI());
    }
}
