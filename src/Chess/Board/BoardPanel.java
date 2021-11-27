package Board;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class BoardPanel extends JPanel {
    Point currentClick;
    Point lastClick;

    public BoardPanel() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                lastClick = currentClick;
                currentClick = e.getPoint();
                repaint();
            }
        });
    }

    private boolean isValueInLimits(int point, int initialValue, int finalValue) {
        return point >= initialValue && point <= finalValue;
    }

    private boolean isPointInDimension(double value, int dimension, int size) {
        return isValueInLimits((int) value, dimension, dimension + size);
    }

    private boolean isPointClicked(int x, int y, int size, Point point) {
        return isPointInDimension(point.getX(), x, size) && isPointInDimension(point.getY(), y, size);
    }

    private boolean isSquareClicked(int x, int y, int size) {
        if (currentClick == null)
            return false;
        final var isCurrentClicked = isPointClicked(x, y, size, currentClick);
        if (lastClick == null)
            return isCurrentClicked;
        final var isLastClicked = isPointClicked(x, y, size, lastClick);
        if (isLastClicked && isCurrentClicked) {
            currentClick = null;
            return false;
        }
        return isCurrentClicked;

    }

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

                if (isSquareClicked(x, y, squareSize))
                    drawer.setPaint(BoardColors.FOCUS);

                drawer.fillRect(x, y, squareSize, squareSize);
            }
        }
    }

}