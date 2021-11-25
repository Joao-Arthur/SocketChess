import javax.swing.JFrame;

public class Lobby extends JFrame {
    JFrame LobbyScreen;

    public Lobby() {
        LobbyScreen = new JFrame();
        LobbyScreen.setVisible(true);
        LobbyScreen.setSize(1366, 768);
        LobbyScreen.setTitle("Lobby | Socket Chess");
        LobbyScreen.setLocationRelativeTo(null);
        LobbyScreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
