package Chess.Match;

import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import Chess.GUI.GUIScreen;

public class MatchScreen implements GUIScreen {
    private final JFrame matchScreen;
    private final MatchService matchService;

    public MatchScreen() {
        matchScreen = createMatchScreen();
        matchScreen.add(createSidebar(), BorderLayout.EAST);
        matchService = new MatchService();
        matchScreen.add(new BoardPanel(matchService));
    }

    private JFrame createMatchScreen() {
        final var matchScreen = new JFrame();
        matchScreen.setVisible(true);
        matchScreen.setSize(1000, 768);
        matchScreen.setTitle("Match | Socket Chess");
        matchScreen.setLocationRelativeTo(null);
        matchScreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        return matchScreen;
    }

    private JPanel createSidebar() {
        final var sidebar = new JPanel();
        final var giveUpButton = createSidebarButton("desistir");
        giveUpButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                matchService.giveUp();
            }
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
}
