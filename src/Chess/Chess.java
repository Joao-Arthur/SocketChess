package Chess;

public class Chess {
    public static void main(String args[]) {
        WindowManager.getInstance().goToLobby();
    }
}

/*
 * TODO
 * - REFACTOR SOCKET
 * - trocar de singleton pra um builder
 * ----- definir se é client ou servidor
 * ----- criar classe com a funcionalidade comum
 * 
 * 
 * - enviar movimentos pelo socket
 * - pegar os movimentos do socket e enviar pro serviço de atualizar a peça
 * - implementar pelo menos check e check mate
 * - criar serviço comum para verificar se está em check ou check mate
 * - verificar peças no meio do caminho
 * 
 * - tratar fechar o socket
 */