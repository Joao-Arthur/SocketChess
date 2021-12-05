package Chess.Lobby.Services;

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
        assertEquals(encoded1, CreateMatchMessageService.encode(decoded1));
        assertEquals(encoded2, CreateMatchMessageService.encode(decoded2));
        assertEquals(encoded3, CreateMatchMessageService.encode(decoded3));
    }

    @Test
    @DisplayName("Should decode the string into a player")
    public void decode() {
        assertEquals(decoded1, CreateMatchMessageService.decode(encoded1));
        assertEquals(decoded2, CreateMatchMessageService.decode(encoded2));
        assertEquals(decoded3, CreateMatchMessageService.decode(encoded3));
    }
}
