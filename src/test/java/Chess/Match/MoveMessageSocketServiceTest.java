package Chess.Match;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoveMessageSocketServiceTest {
  final MovementDTO decoded1 = MovementDTO.from(1, 2, 3, 4);
  final String encoded1 = "MOVE: (1,2) -> (3,4)";
  final MovementDTO decoded2 = MovementDTO.from(3, 1, 7, 3);
  final String encoded2 = "MOVE: (3,1) -> (7,3)";
  final MovementDTO decoded3 = MovementDTO.from(4, 3, 5, 3);
  final String encoded3 = "MOVE: (4,3) -> (5,3)";
  final MovementDTO decoded4 = MovementDTO.from(7, 4, 2, 4);
  final String encoded4 = "MOVE: (7,4) -> (2,4)";
  final MovementDTO decoded5 = MovementDTO.from(3, 3, 4, 4);
  final String encoded5 = "MOVE: (3,3) -> (4,4)";

  @Test
  @DisplayName("Should encode the movement into a string")
  public void encode() {
    assertEquals(MoveMessageSocketService.encode(decoded1), encoded1);
    assertEquals(MoveMessageSocketService.encode(decoded2), encoded2);
    assertEquals(MoveMessageSocketService.encode(decoded3), encoded3);
    assertEquals(MoveMessageSocketService.encode(decoded4), encoded4);
    assertEquals(MoveMessageSocketService.encode(decoded5), encoded5);
  }

  @Test
  @DisplayName("Should decode the string into a movement")
  public void decode() {
    assertEquals(MoveMessageSocketService.decode(encoded1), decoded1);
    assertEquals(MoveMessageSocketService.decode(encoded2), decoded2);
    assertEquals(MoveMessageSocketService.decode(encoded3), decoded3);
    assertEquals(MoveMessageSocketService.decode(encoded4), decoded4);
    assertEquals(MoveMessageSocketService.decode(encoded5), decoded5);
  }
}