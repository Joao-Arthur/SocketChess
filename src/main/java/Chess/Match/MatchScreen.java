package Chess.Match;

import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import Chess.GUI.GUIScreen;
import Chess.Match.Board.BoardPanel;
import Chess.Match.Player.PlayerEnum;

public class MatchScreen implements GUIScreen {
    private final JFrame matchScreen;
    private final MatchService matchService;

    public MatchScreen(PlayerEnum player) {
        matchScreen = createMatchScreen();
        matchScreen.add(createSidebar(), BorderLayout.EAST);
        final var boardPanel = new BoardPanel(player);
        matchService = new MatchService(boardPanel, player);
        boardPanel.setService(matchService);
        matchScreen.add(boardPanel);
    }

    private JFrame createMatchScreen() {
        final var matchScreen = new JFrame();
        matchScreen.setVisible(true);
        matchScreen.setSize(800, 650);
        matchScreen.setTitle("Match | Socket Chess");
        matchScreen.setLocationRelativeTo(null);
        matchScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return matchScreen;
    }

    private JPanel createSidebar() {
        final var sidebar = new JPanel();
        final var giveUpButton = createSidebarButton("desistir");
        giveUpButton.addActionListener(e -> {
            if (JOptionPane.showConfirmDialog(matchScreen, "Tem certeza que quer desistir?", "Desistir", JOptionPane.WARNING_MESSAGE) != JOptionPane.YES_OPTION) return;
            matchService.giveUp();
        });
        sidebar.add(giveUpButton);
        return sidebar;
    }

    private JButton createSidebarButton(String title) {
        final var sidebarButton = new JButton(title);
        final var size = new Dimension(200, 30);
        sidebarButton.setPreferredSize(size);
        return sidebarButton;
    }

    public void dispose() {
        matchScreen.dispose();
    }

    public JFrame getScreen() {
        return matchScreen;
    }

    public void enable() {
    }

    public void disable() {
    }
}
