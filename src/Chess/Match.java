import java.awt.*;
import javax.swing.*;

import Board.Board;

public class Match {
    public Match() {
        final var matchScreen = createMatchScreen();
        matchScreen.add(new Board(), BorderLayout.CENTER);

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

}
