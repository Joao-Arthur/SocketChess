import java.awt.*;
import javax.swing.*;

import Board.Board;

public class Match {
    public Match() {
        final var matchScreen = createMatchScreen();
        matchScreen.add(createSidebar(), BorderLayout.EAST);
        matchScreen.add(new Board());
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
        sidebarButton.setSize(200, 30);
        return sidebarButton;
    }
}
