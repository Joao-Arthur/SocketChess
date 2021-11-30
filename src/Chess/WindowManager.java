package Chess;

import Chess.Lobby.LobbyScreen;
import Chess.Match.MatchScreen;

public class WindowManager {
    private static WindowManager instance;
    private LobbyScreen lobbyScreen;
    private MatchScreen matchScreen;

    public static WindowManager getInstance() {
        if (instance == null)
            instance = new WindowManager();
        return instance;
    }

    public void goToLobby() {
        if (matchScreen != null) {
            matchScreen.dispose();
            matchScreen = null;
        }
        lobbyScreen = new LobbyScreen();
    }

    public void goToMatch() {
        if (lobbyScreen != null) {
            lobbyScreen.dispose();
            lobbyScreen = null;
        }
        matchScreen = new MatchScreen();
    }
}
