package Chess.Match.Services;

import java.util.logging.Level;
import java.util.logging.Logger;

import Chess.Match.Player.PlayerEnum;

public class GetPlayerByOpponentService {
    private final PlayerEnum opponent;

    public GetPlayerByOpponentService(final PlayerEnum opponent) {
        this.opponent = opponent;
    }

    public PlayerEnum get() {
        switch (opponent) {
            case BLACK:
                return PlayerEnum.WHITE;
            case WHITE:
                return PlayerEnum.BLACK;
            default:
                Logger.getLogger(GetPlayerByOpponentService.class.getName()).log(Level.WARNING,
                        opponent + " is not a valid player for a match");
                return null;
        }
    }
}
