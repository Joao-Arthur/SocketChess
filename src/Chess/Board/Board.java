package Board;

import java.awt.*;
import javax.swing.*;

public class Board extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        final var drawer = (Graphics2D) g;
        drawer.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        final var height = getHeight();
        final var width = getWidth();

        final var totalSize = Math.min(height, width);
        final var paddingX = (width - totalSize) / 2;
        final var paddingY = (height - totalSize) / 2;

        final var squareSize = totalSize / 8;

        var darkSquare = true;
        for (int boardWidthIndex = 0; boardWidthIndex < 8; boardWidthIndex++) {
            darkSquare = !darkSquare;
            for (int boardHeightIndex = 0; boardHeightIndex < 8; boardHeightIndex++) {
                if (darkSquare) {
                    drawer.setPaint(BoardColors.DARK);
                } else {
                    drawer.setPaint(BoardColors.LIGHT);
                }
                darkSquare = !darkSquare;

                final var x = paddingX + boardHeightIndex * squareSize;
                final var y = paddingY + boardWidthIndex * squareSize;

                drawer.fillRect(x, y, squareSize, squareSize);
            }
        }
    }

}
