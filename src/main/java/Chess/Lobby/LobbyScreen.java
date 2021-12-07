package Chess.Lobby;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.Box;
import java.awt.Dimension;
import Chess.GUI.GUIScreen;

public class LobbyScreen implements GUIScreen {
    private final JFrame lobbyScreen;
    private final LobbyService lobbyService;
    private JButton createMatch;
    private JButton connectMatch;

    public LobbyScreen() {
        lobbyScreen = createLobbyScreen();
        lobbyScreen.add(createButtonsPanel());
        lobbyService = new LobbyService(this);
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

    private JPanel createButtonsPanel() {
        final var content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        content.add(Box.createVerticalGlue());
        createMatch = createButton("criar partida");
        createMatch.addActionListener(e -> {
            if (!createMatch.isEnabled())
                return;
            disable();
            lobbyService.createServerForMatch();
        });
        content.add(createMatch);
        content.add(Box.createVerticalGlue());
        connectMatch = createButton("conectar à partida");
        connectMatch.addActionListener(e -> {
            if (!connectMatch.isEnabled())
                return;
            disable();
            lobbyService.createClientForMatch();  
        });
        content.add(connectMatch);
        content.add(Box.createVerticalGlue());
        final var container = new JPanel(new FlowLayout());
        container.setLayout(new BoxLayout(container, BoxLayout.LINE_AXIS));
        container.add(Box.createVerticalGlue());
        container.add(Box.createHorizontalGlue());
        container.add(content);
        container.add(Box.createVerticalGlue());
        container.add(Box.createHorizontalGlue());
        return container;
    }

    private JButton createButton(String title) {
        final var contentButton = new JButton(title);
        final var size = new Dimension(250, 35);
        contentButton.setPreferredSize(size);
        contentButton.setMaximumSize(size);
        return contentButton;
    }

    public void dispose() {
        lobbyScreen.dispose();
    }

    public JFrame getScreen() {
        return lobbyScreen;
    }

    public void enable() {
        createMatch.setEnabled(true);
        connectMatch.setEnabled(true);
    }

    public void disable() {
        createMatch.setEnabled(false);
        connectMatch.setEnabled(false);
    }
}
