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
 * - implementar pelo menos check e check mate
 * - verificar a renderização do panel e como tirar o thread sleep
 * - verificar peças no meio do caminho
 * - tratar fechar o socket, manter aberto após partidas e etc
 */