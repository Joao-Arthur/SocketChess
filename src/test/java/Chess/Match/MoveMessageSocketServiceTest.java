package Chess.Match;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoveMessageSocketServiceTest {
  final MovementDTO decoded = MovementDTO.from(1, 2, 3, 4);
  final String encoded = "MOVE: (1,2) -> (3,4)";

  @Test
  @DisplayName("Should encode the movement into a string")
  public void encode() {
    assertEquals(MoveMessageSocketService.encode(decoded), encoded);
  }

  @Test
  @DisplayName("Should decode the string into a movement")
  public void decode() {
    assertEquals(MoveMessageSocketService.decode(encoded), decoded);
  }

}