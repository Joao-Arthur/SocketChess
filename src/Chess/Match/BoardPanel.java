package Chess.Match;

import javax.swing.JPanel;
import java.awt.Point;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BoardPanel extends JPanel {
    private final MatchService matchService;
    Point currentClick;
    Point lastClick;
    BoardImages boardImages;
    ModelToView modelToView;

    public BoardPanel(MatchService matchService) {
        this.matchService = matchService;
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                lastClick = currentClick;
                currentClick = e.getPoint();
                verifyMovedPiece();
                repaint();
            }
        });
        modelToView = new ModelToView();
        boardImages = new BoardImages();
    }

    private void verifyMovedPiece() {
        if (currentClick == null)
            return;
        if (lastClick == null)
            return;
        final var height = getHeight();
        final var width = getWidth();
        final var totalSize = Math.min(height, width);
        final var paddingX = (width - totalSize) / 2;
        final var paddingY = (height - totalSize) / 2;
        final var squareSize = totalSize / 8;
        final var currentXClicked = (((int) currentClick.getX() - paddingX) / squareSize);
        final var lastXClicked = (((int) lastClick.getX() - paddingX) / squareSize);
        final var currentYClicked = (((int) currentClick.getY() - paddingY) / squareSize);
        final var lastYClicked = (((int) lastClick.getY() - paddingY) / squareSize);
        final var from = new Point(lastXClicked, lastYClicked);
        final var to = new Point(currentXClicked, currentYClicked);
        if (from.equals(to))
            return;
        modelToView.movePiece(from, to);
        currentClick = null;
        lastClick = null;
    }

    private boolean isPointClicked(int x, int y, Point point) {
        final var height = getHeight();
        final var width = getWidth();
        final var totalSize = Math.min(height, width);
        final var paddingX = (width - totalSize) / 2;
        final var paddingY = (height - totalSize) / 2;
        final var squareSize = totalSize / 8;
        return ((((int) point.getX() - paddingX) / squareSize) == (x - paddingX) / squareSize &&
                (((int) point.getY() - paddingY) / squareSize) == (y - paddingY) / squareSize);
    }

    private boolean isSquareClicked(int x, int y, int squareSize) {
        if (currentClick == null)
            return false;
        final var isCurrentClicked = isPointClicked(x, y, currentClick);
        if (lastClick == null)
            return isCurrentClicked;
        final var isLastClicked = isPointClicked(x, y, lastClick);
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
        for (int yIndex = 0; yIndex < 8; yIndex++) {
            for (int xIndex = 0; xIndex < 8; xIndex++) {
                final var x = paddingX + xIndex * squareSize;
                final var y = paddingY + yIndex * squareSize;
                drawer.setPaint(getSquareColor(x, y, squareSize, xIndex, yIndex));
                drawer.fillRect(x, y, squareSize, squareSize);
                final var imageToDraw = modelToView.getPieceImage(xIndex, yIndex);
                if (imageToDraw != null)
                    drawer.drawImage(imageToDraw, x, y, squareSize, squareSize, this);
            }
        }
    }

    private Color getSquareColor(int x, int y, int squareSize, int xIndex, int yIndex) {
        if (isSquareClicked(x, y, squareSize))
            return BoardColors.FOCUS;
        if ((xIndex + yIndex) % 2 == 1) {
            return BoardColors.DARK;
        } else {
            return BoardColors.LIGHT;
        }
    }
}
