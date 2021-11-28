import javax.swing.JFrame;
import javax.swing.JPanel;

import Socket.SocketService;

import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.Box;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Lobby extends JFrame {

    public Lobby() {
        final var lobbyScreen = createLobbyScreen();
        lobbyScreen.add(createSidebar());
    }

    private JFrame createLobbyScreen() {
        final var lobbyScreen = new JFrame();
        lobbyScreen.setVisible(true);
        lobbyScreen.setSize(500, 300);
        lobbyScreen.setTitle("Socket Chess");
        lobbyScreen.setLocationRelativeTo(null);
        lobbyScreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        return lobbyScreen;
    }

    private JPanel createSidebar() {
        final var sidebar = new JPanel();
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.LINE_AXIS));
        sidebar.add(Box.createVerticalGlue());
        sidebar.add(Box.createHorizontalGlue());
        final var createMatchButton = createSidebarButton("criar partida");
        createMatchButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                SocketService.getInstance().createServer();
            }
        });
        sidebar.add(createMatchButton);
        sidebar.add(Box.createVerticalGlue());
        sidebar.add(Box.createHorizontalGlue());
        final var connectToMatchButton = createSidebarButton("conectar à partida");
        connectToMatchButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                SocketService.getInstance().createClient();
                SocketService.getInstance().send("S");
            }
        });
        sidebar.add(connectToMatchButton);
        sidebar.add(Box.createVerticalGlue());
        sidebar.add(Box.createHorizontalGlue());
        return sidebar;
    }

    private JButton createSidebarButton(String title) {
        final var sidebarButton = new JButton(title);
        sidebarButton.setSize(300, 30);
        return sidebarButton;
    }
}
