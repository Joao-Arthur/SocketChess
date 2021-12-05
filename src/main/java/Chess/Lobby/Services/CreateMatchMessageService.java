package Chess.Lobby.Services;

import Chess.Match.Player.PlayerEnum;

public class CreateMatchMessageService {
    public static final String PREFIX = "NEW_MATCH: ";

    public static String encode(PlayerEnum player) {
        return PREFIX + player;
    }

    public static PlayerEnum decode(String message) {
        return PlayerEnum.valueOf(message.replace(PREFIX, ""));
    }
}
