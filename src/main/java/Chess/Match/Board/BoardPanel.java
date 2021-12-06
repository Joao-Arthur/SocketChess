package Chess.Match.Board;

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
import Chess.Match.MatchService;
import Chess.Match.Movement;
import Chess.Match.Board.Piece.MovePiece.InvalidArgsException;
import Chess.Match.Board.Piece.MovePiece.InvalidMovementException;
import Chess.Match.Board.Piece.MovePiece.NoSuchPieceException;
import Chess.Match.Board.Piece.MovePiece.RepeatedMoveException;
import Chess.Match.Player.PlayerEnum;

public class BoardPanel extends JPanel {
    private final PlayerEnum player;

    private MatchService matchService;
    Point currentClick;
    Point lastClick;

    public BoardPanel(PlayerEnum player) {
        this.player = player;
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                lastClick = currentClick;
                currentClick = e.getPoint();
                verifyMovedPiece();
                repaint();
            }
        });
    }

    public void setService(MatchService matchService) {
        this.matchService = matchService;
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
        final var from = player == PlayerEnum.BLACK
                ? new Point(7 - lastXClicked, 7 - lastYClicked)
                : new Point(lastXClicked, lastYClicked);
        final var currentXClicked = (currentClick.x - paddingX) / squareSize;
        final var currentYClicked = (currentClick.y - paddingY) / squareSize;
        final var to = player == PlayerEnum.BLACK
                ? new Point(7 - currentXClicked, 7 - currentYClicked)
                : new Point(currentXClicked, currentYClicked);
        if (from.equals(to))
            return;
        final var movement = Movement.from(from, to);
        move(movement);
        currentClick = null;
        lastClick = null;
    }

    private void move(Movement movement) {
        try {
            matchService.movePlayerPiece(movement);
        } catch (InvalidArgsException exception) {
            Logger.getLogger(BoardPanel.class.getName()).log(Level.SEVERE, null, exception);
        } catch (InvalidMovementException
                | NoSuchPieceException
                | RepeatedMoveException exception) {
            Logger.getLogger(BoardPanel.class.getName()).log(Level.FINEST, null, exception);
        } catch (Exception exception) {
            Logger.getLogger(BoardPanel.class.getName()).log(Level.WARNING, null, exception);
        }
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
                final var indexPoint = player == PlayerEnum.BLACK
                        ? new Point(7 - xIndex, 7 - yIndex)
                        : new Point(xIndex, yIndex);
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
            return Colors.FOCUS;
        if ((indexPoint.x + indexPoint.y) % 2 == 1) {
            return Colors.DARK;
        } else {
            return Colors.LIGHT;
        }
    }
}
