public class Chess {
    public static void main(String args[]) {
        WindowManager.getInstance().goToLobby();
    }
}

/*
 * TODO
 * - separar movimentos das peças nos serviços específicos
 * - enviar movimentos pelo socket
 * - pegar os movimentos do socket e enviar pro serviço de atualizar a peça
 * - implementar pelo menos check e check mate
 * - criar serviço comum para verificar se está em check ou check mate
 */