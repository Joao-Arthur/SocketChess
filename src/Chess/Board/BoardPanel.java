package Board;

import java.awt.*;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BoardPanel extends JPanel {
    Point currentClick;
    Point lastClick;
    BoardImages boardImages;
    ModelToView modelToView;
    
    public BoardPanel() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                lastClick = currentClick;
                currentClick = e.getPoint();
                repaint();
            }
        });

       modelToView = new ModelToView();
       boardImages = new BoardImages();
    }

    private boolean isValueInLimits(int point, int initialValue, int finalValue) {
        return point >= initialValue && point <= finalValue;
    }

    private boolean isPointInDimension(double value, int dimension, int size) {
        return isValueInLimits((int) value, dimension, dimension + size);
    }

    private boolean isPointClicked(int x, int y, int squareSize, Point point) {
        return isPointInDimension(point.getX(), x, squareSize) && isPointInDimension(point.getY(), y, squareSize);
    }

    private boolean isSquareClicked(int x, int y, int squareSize) {
        if (currentClick == null)
            return false;
        final var isCurrentClicked = isPointClicked(x, y, squareSize, currentClick);
        if (lastClick == null)
            return isCurrentClicked;
        final var isLastClicked = isPointClicked(x, y, squareSize, lastClick);
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
        for (int yIndex = 0; yIndex < 8; yIndex++) {
            darkSquare = !darkSquare;
            for (int xIndex = 0; xIndex < 8; xIndex++) {
                if (darkSquare) {
                    drawer.setPaint(BoardColors.DARK);
                } else {
                    drawer.setPaint(BoardColors.LIGHT);
                }

                darkSquare = !darkSquare;

                final var x = paddingX + xIndex * squareSize;
                final var y = paddingY + yIndex * squareSize;

                if (isSquareClicked(x, y, squareSize))
                    drawer.setPaint(BoardColors.FOCUS);

                drawer.fillRect(x, y, squareSize, squareSize);    

                final var imageToDraw = modelToView.getPieceImage(yIndex, xIndex);
                if(imageToDraw != null)
                    drawer.drawImage(imageToDraw, x, y, squareSize, squareSize, this);
            }
        }
    }
}
