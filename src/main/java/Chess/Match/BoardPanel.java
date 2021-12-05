package Chess.Match;

import javax.swing.JPanel;
import java.awt.Point;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Logger;
import java.util.logging.Level;
import Chess.Match.Piece.MovePiece.InvalidArgsException;
import Chess.Match.Piece.MovePiece.InvalidMovementException;
import Chess.Match.Piece.MovePiece.NoSuchPieceException;

public class BoardPanel extends JPanel {
    private final MatchService matchService;
    Point currentClick;
    Point lastClick;
    BoardImages boardImages;

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
        MatchDispatcher.register(new MatchObserverHandler(matchService, this));
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
        final var lastXClicked = (lastClick.x - paddingX) / squareSize;
        final var lastYClicked = (lastClick.y - paddingY) / squareSize;
        final var from = new Point(lastXClicked, lastYClicked);
        final var currentXClicked = (currentClick.x - paddingX) / squareSize;
        final var currentYClicked = (currentClick.y - paddingY) / squareSize;
        final var to = new Point(currentXClicked, currentYClicked);
        if (from.equals(to))
            return;
        final var movement = MovementDTO.from(from, to);
        try {
            matchService.movePiece(movement);
        } catch (InvalidArgsException exception) {
            Logger.getLogger(BoardModel.class.getName()).log(Level.SEVERE, null, exception);
        } catch (InvalidMovementException exception) {
            // Logger.getLogger(BoardModel.class.getName()).log(Level.INFO, null,
            // exception);
        } catch (NoSuchPieceException exception) {
            // Logger.getLogger(BoardModel.class.getName()).log(Level.INFO, null,
            // exception);
        }

        currentClick = null;
        lastClick = null;
    }

    private boolean isPointClicked(Point currentPoint, Point clickPoint) {
        final var height = getHeight();
        final var width = getWidth();
        final var totalSize = Math.min(height, width);
        final var paddingX = (width - totalSize) / 2;
        final var paddingY = (height - totalSize) / 2;
        final var squareSize = totalSize / 8;
        return (((clickPoint.x - paddingX) / squareSize) == (currentPoint.x - paddingX) / squareSize &&
                ((clickPoint.y - paddingY) / squareSize) == (currentPoint.y - paddingY) / squareSize);
    }

    private boolean isSquareClicked(Point point, int squareSize) {
        if (currentClick == null)
            return false;
        final var isCurrentClicked = isPointClicked(point, currentClick);
        if (lastClick == null)
            return isCurrentClicked;
        final var isLastClicked = isPointClicked(point, lastClick);
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
                final var point = new Point(x, y);
                final var indexPoint = new Point(xIndex, yIndex);
                drawer.setPaint(getSquareColor(squareSize, point, indexPoint));
                drawer.fillRect(x, y, squareSize, squareSize);
                final var imageToDraw = matchService.getPieceImage(indexPoint);
                if (imageToDraw != null)
                    drawer.drawImage(imageToDraw, x, y, squareSize, squareSize, this);
            }
        }
    }

    private Color getSquareColor(int squareSize, Point point, Point indexPoint) {
        if (isSquareClicked(point, squareSize))
            return BoardColors.FOCUS;
        if ((indexPoint.x + indexPoint.y) % 2 == 1) {
            return BoardColors.DARK;
        } else {
            return BoardColors.LIGHT;
        }
    }
}
