package Chess.Match;

import java.awt.*;
import javax.swing.*;

import Chess.Board.BoardPanel;

public class Match {
    private final JFrame matchScreen;

    public Match() {
        matchScreen = createMatchScreen();
        matchScreen.add(createSidebar(), BorderLayout.EAST);
        matchScreen.add(new BoardPanel());
    }

    private JFrame createMatchScreen() {
        final var matchScreen = new JFrame();
        matchScreen.setVisible(true);
        matchScreen.setSize(1366, 768);
        matchScreen.setTitle("Match | Socket Chess");
        matchScreen.setLocationRelativeTo(null);
        matchScreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        return matchScreen;
    }

    private JPanel createSidebar() {
        final var sidebar = new JPanel();
        sidebar.add(createSidebarButton("desistir"));
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
