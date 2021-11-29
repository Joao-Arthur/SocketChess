public class WindowManager {
    private static WindowManager instance;
    private Lobby lobbyScreen;
    private Match matchScreen;

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
        lobbyScreen = new Lobby();
    }

    public void goToMatch() {
        if (lobbyScreen != null) {
            lobbyScreen.dispose();
            lobbyScreen = null;
        }
        matchScreen = new Match();
    }
}
