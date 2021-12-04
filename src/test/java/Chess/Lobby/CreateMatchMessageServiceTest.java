package Chess.Lobby;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import Chess.Match.Player.PlayerEnum;

public class CreateMatchMessageServiceTest {
    final PlayerEnum decoded1 = PlayerEnum.BLACK;
    final String encoded1 = "NEW_MATCH: BLACK";
    final PlayerEnum decoded2 = PlayerEnum.WHITE;
    final String encoded2 = "NEW_MATCH: WHITE";
    final PlayerEnum decoded3 = PlayerEnum.NONE;
    final String encoded3 = "NEW_MATCH: NONE";

    @Test
    @DisplayName("Should encode the player into a string")
    public void encode() {
        assertEquals(CreateMatchMessageService.encode(decoded1), encoded1);
        assertEquals(CreateMatchMessageService.encode(decoded2), encoded2);
        assertEquals(CreateMatchMessageService.encode(decoded3), encoded3);
    }

    @Test
    @DisplayName("Should decode the string into a player")
    public void decode() {
        assertEquals(CreateMatchMessageService.decode(encoded1), decoded1);
        assertEquals(CreateMatchMessageService.decode(encoded2), decoded2);
        assertEquals(CreateMatchMessageService.decode(encoded3), decoded3);
    }
}
