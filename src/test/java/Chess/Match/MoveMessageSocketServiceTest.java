package Chess.Match;

import java.awt.Point;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoveMessageSocketServiceTest {

  @Test
  @DisplayName("Should encode the movement into a string")
  public void encode() {
    assertEquals(MoveMessageSocketService.encode(new MovementDTO(new Point(1, 2), new Point(3, 4))),
        "MOVE: (1,2) -> (3,4)");
  }

  @Test
  @DisplayName("Should decode the string into a movement")
  public void decode() {
    // assertEquals(MoveMessageSocketService.decode("MOVE: (1,2) -> (3,4)"),
    // new MovementDTO(new Point(1, 2), new Point(3, 4)));
  }

}