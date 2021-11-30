import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.Box;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Lobby {
    private final JFrame lobbyScreen;
    private final NewMatchService newMatchService;

    public Lobby() {
        lobbyScreen = createLobbyScreen();
        lobbyScreen.add(createSidebar());
        newMatchService = new NewMatchService();
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
                newMatchService.createServerForMatch();
            }
        });
        sidebar.add(createMatchButton);
        sidebar.add(Box.createVerticalGlue());
        sidebar.add(Box.createHorizontalGlue());
        final var connectToMatchButton = createSidebarButton("conectar à partida");
        connectToMatchButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                newMatchService.createClientForMatch();
            }
        });
        sidebar.add(connectToMatchButton);
        sidebar.add(Box.createVerticalGlue());
        sidebar.add(Box.createHorizontalGlue());
        return sidebar;
    }

    private JButton createSidebarButton(String title) {
        final var sidebarButton = new JButton(title);
        final var size = new Dimension(150, 30);
        sidebarButton.setPreferredSize(size);
        return sidebarButton;
    }

    public void dispose() {
        lobbyScreen.dispose();
    }
}
