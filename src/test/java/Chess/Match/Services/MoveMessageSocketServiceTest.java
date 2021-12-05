package Chess.Match.Services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import Chess.Match.Movement;

public class MoveMessageSocketServiceTest {
  final Movement decoded1 = Movement.from(1, 2, 3, 4);
  final String encoded1 = "MOVE: (1,2) -> (3,4)";
  final Movement decoded2 = Movement.from(3, 1, 7, 3);
  final String encoded2 = "MOVE: (3,1) -> (7,3)";
  final Movement decoded3 = Movement.from(4, 3, 5, 3);
  final String encoded3 = "MOVE: (4,3) -> (5,3)";
  final Movement decoded4 = Movement.from(7, 4, 2, 4);
  final String encoded4 = "MOVE: (7,4) -> (2,4)";
  final Movement decoded5 = Movement.from(3, 3, 4, 4);
  final String encoded5 = "MOVE: (3,3) -> (4,4)";

  @Test
  @DisplayName("Should encode the movement into a string")
  public void encode() {
    assertEquals(encoded1, MoveMessageSocketService.encode(decoded1));
    assertEquals(encoded2, MoveMessageSocketService.encode(decoded2));
    assertEquals(encoded3, MoveMessageSocketService.encode(decoded3));
    assertEquals(encoded4, MoveMessageSocketService.encode(decoded4));
    assertEquals(encoded5, MoveMessageSocketService.encode(decoded5));
  }

  @Test
  @DisplayName("Should decode the string into a movement")
  public void decode() {
    assertEquals(decoded1, MoveMessageSocketService.decode(encoded1));
    assertEquals(decoded2, MoveMessageSocketService.decode(encoded2));
    assertEquals(decoded3, MoveMessageSocketService.decode(encoded3));
    assertEquals(decoded4, MoveMessageSocketService.decode(encoded4));
    assertEquals(decoded5, MoveMessageSocketService.decode(encoded5));
  }
}