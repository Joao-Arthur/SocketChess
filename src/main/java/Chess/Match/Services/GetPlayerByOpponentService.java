package Chess.Match.Services;

import Chess.Match.Player.PlayerEnum;

public class GetPlayerByOpponentService {
    public static PlayerEnum get(PlayerEnum opponent) {
        switch (opponent) {
            case BLACK:
                return PlayerEnum.WHITE;
            case WHITE:
                return PlayerEnum.BLACK;
            default:
                return null;
        }
    }
}
