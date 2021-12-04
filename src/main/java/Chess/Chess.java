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
 * - tratar fechar o socket, manter aberto após partidas e etc
 * - peças no meio do caminho
 * - definir se é brancas ou pretas
 */