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
 * --- check e check mate
 * --- definir se é brancas ou pretas
 * --- peças no meio do caminho
 * -- colocar uma lista pra exibir o que foi enviado pelo socket
 * -- tratar fechar o socket, manter aberto após partidas e etc
 * - verificar a renderização do panel
 */