package Board;

import java.awt.*;
import java.io.*;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class BoardPanel extends JPanel {
    Point currentClick;
    Point lastClick;
    BufferedImage BlackBishop;
    BufferedImage BlackKing;
    BufferedImage BlackKnight;
    BufferedImage BlackPawn;
    BufferedImage BlackQueen;
    BufferedImage BlackRook;
    BufferedImage WhiteBishop;
    BufferedImage WhiteKing;
    BufferedImage WhiteKnight;
    BufferedImage WhitePawn;
    BufferedImage WhiteQueen;
    BufferedImage WhiteRook;
    BoardModel boardModel;
    
    public BoardPanel() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                lastClick = currentClick;
                currentClick = e.getPoint();
                repaint();
            }
        });

       try {   
            BlackBishop = ImageIO.read(getClass().getResource("Images/BlackBishop.png"));
            BlackKing = ImageIO.read(getClass().getResource("Images/BlackKing.png"));
            BlackKnight  = ImageIO.read(getClass().getResource("Images/BlackKnight.png"));
            BlackPawn = ImageIO.read(getClass().getResource("Images/BlackPawn.png"));
            BlackQueen = ImageIO.read(getClass().getResource("Images/BlackQueen.png"));
            BlackRook = ImageIO.read(getClass().getResource("Images/BlackRook.png"));
            WhiteBishop = ImageIO.read(getClass().getResource("Images/WhiteBishop.png"));
            WhiteKing = ImageIO.read(getClass().getResource("Images/WhiteKing.png"));
            WhiteKnight = ImageIO.read(getClass().getResource("Images/WhiteKnight.png"));
            WhitePawn = ImageIO.read(getClass().getResource("Images/WhitePawn.png"));
            WhiteQueen = ImageIO.read(getClass().getResource("Images/WhiteQueen.png"));
            WhiteRook = ImageIO.read(getClass().getResource("Images/WhiteRook.png"));
       } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
       }

       boardModel = new BoardModel();
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
                
                final var currentHouse = boardModel.getModelHouse(boardWidthIndex, boardHeightIndex);
                if(currentHouse == null)continue;

                switch(currentHouse.piece.toString()) {
                    case "KING": 
                        switch(currentHouse.player.toString()) {
                            case "WHITE":
                                drawer.drawImage(WhiteKing, x, y, squareSize, squareSize, this);
                        break;
                            case "BLACK":
                                drawer.drawImage(BlackKing, x, y, squareSize, squareSize, this);
                        }
                        break;
                    case "QUEEN": 
                      switch(currentHouse.player.toString()) {
                          case "WHITE":
                               drawer.drawImage(WhiteQueen, x, y, squareSize, squareSize, this);
                      break;
                          case "BLACK":
                               drawer.drawImage(BlackQueen, x, y, squareSize, squareSize, this);
                      }
                      break;
                    case "ROOK": 
                      switch(currentHouse.player.toString()) {
                          case "WHITE":
                               drawer.drawImage(WhiteRook, x, y, squareSize, squareSize, this);
                      break;
                          case "BLACK":
                               drawer.drawImage(BlackRook, x, y, squareSize, squareSize, this);
                      }
                      break;
                    case "KNIGTH": 
                      switch(currentHouse.player.toString()) {
                          case "WHITE":
                               drawer.drawImage(WhiteKnight, x, y, squareSize, squareSize, this);
                      break;
                          case "BLACK":
                               drawer.drawImage(BlackKnight, x, y, squareSize, squareSize, this);
                      }
                      break;
                    case "BISHOP": 
                      switch(currentHouse.player.toString()) {
                          case "WHITE":
                               drawer.drawImage(WhiteBishop, x, y, squareSize, squareSize, this);
                      break;
                          case "BLACK":
                               drawer.drawImage(BlackBishop, x, y, squareSize, squareSize, this);
                      }
                      break;
                    case "PAWN": 
                      switch(currentHouse.player.toString()) {
                          case "WHITE":
                               drawer.drawImage(WhitePawn, x, y, squareSize, squareSize, this);
                      break;
                          case "BLACK":
                               drawer.drawImage(BlackPawn, x, y, squareSize, squareSize, this);
                      }
                      break;
                }
            }
        }
    }
}
