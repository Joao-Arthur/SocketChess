
import java.awt.*;
import javax.swing.*;

public class Board extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        this.getHeight();
        this.getWidth();
        final var totalSize = Math.min(getHeight(), getWidth());
        final var squareSize = totalSize / 8;

        super.paintComponent(g);
        final var drawer = (Graphics2D) g;
        drawer.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        var blueSquare = true;
        for (int boardWidthIndex = 0; boardWidthIndex < 8; boardWidthIndex++) {
            blueSquare = !blueSquare;
            for (int boardHeightIndex = 0; boardHeightIndex < 8; boardHeightIndex++) {
                if (blueSquare) {
                    drawer.setPaint(Color.BLUE);
                } else {
                    drawer.setPaint(Color.BLACK);
                }
                blueSquare = !blueSquare;
                drawer.fillRect((boardHeightIndex) * squareSize, (boardWidthIndex) * squareSize, squareSize,
                        squareSize);
            }
        }

    }
}
