package Chess;

import Chess.GUI.GUI;
import Chess.Lobby.LobbyScreen;

public class Chess {
    public static void main(String args[]) {
        GUI.getInstance().goTo(new LobbyScreen());
    }
}

/*
 * TODO
 * - eventos do lobby
 * - implementar uma jogada por jogador
 * - validar mover apenas as proprias peças
 */