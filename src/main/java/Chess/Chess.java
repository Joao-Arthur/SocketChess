package Chess;

import Chess.GUI.GUI;
import Chess.Lobby.LobbyScreen;

public class Chess {
    public static void main(String args[]) {
        GUI.getInstance().goTo(new LobbyScreen());
    }
}