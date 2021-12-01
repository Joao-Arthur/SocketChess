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
 * - enviar movimentos pelo socket
 * - pegar os movimentos do socket e enviar pro serviço de atualizar a peça
 * - implementar pelo menos check e check mate
 * - criar serviço comum para verificar se está em check ou check mate
 * - verificar peças no meio do caminho
 * - tratar fechar o socket, manter aberto após partidas e etc
 */