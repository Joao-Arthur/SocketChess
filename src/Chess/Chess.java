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
 * - verificar a renderização do panel
 * - criar servico para transformar a mensagem do movimento 
 * - verificar peças no meio do caminho
 * - colocar uma lista pra exibir o que foi enviado pelo socket
 * - tratar fechar o socket, manter aberto após partidas e etc
 */