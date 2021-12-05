package Chess.Match;

import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.util.HashMap;
import java.util.logging.Logger;
import java.util.logging.Level;
import Chess.Match.Piece.PieceEnum;
import Chess.Match.Player.PlayerEnum;

public class BoardImages {
    private BufferedImage blackBishop;
    private BufferedImage blackKing;
    private BufferedImage blackKnight;
    private BufferedImage blackPawn;
    private BufferedImage blackQueen;
    private BufferedImage blackRook;
    private BufferedImage whiteBishop;
    private BufferedImage whiteKing;
    private BufferedImage whiteKnight;
    private BufferedImage whitePawn;
    private BufferedImage whiteQueen;
    private BufferedImage whiteRook;
    public HashMap<String, BufferedImage> imagesMap;

    BoardImages() {
        loadImages();
        loadImagesMap();
    }

    private void loadImages() {
        try {
            blackBishop = loadImage("BlackBishop");
            blackKing = loadImage("BlackKing");
            blackKnight = loadImage("BlackKnight");
            blackPawn = loadImage("BlackPawn");
            blackQueen = loadImage("BlackQueen");
            blackRook = loadImage("BlackRook");
            whiteBishop = loadImage("WhiteBishop");
            whiteKing = loadImage("WhiteKing");
            whiteKnight = loadImage("WhiteKnight");
            whitePawn = loadImage("WhitePawn");
            whiteQueen = loadImage("WhiteQueen");
            whiteRook = loadImage("WhiteRook");
        } catch (IOException exception) {
            Logger.getLogger(BoardImages.class.getName()).log(Level.SEVERE, null, exception);
        }
    }

    private BufferedImage loadImage(String name) throws IOException {
        return ImageIO.read(getClass().getResource("Images/" + name + ".png"));
    }

    private void loadImagesMap() {
        imagesMap = new HashMap<String, BufferedImage>();
        imagesMap.put(new BoardHouse(PlayerEnum.BLACK, PieceEnum.BISHOP).toString(), blackBishop);
        imagesMap.put(new BoardHouse(PlayerEnum.BLACK, PieceEnum.KING).toString(), blackKing);
        imagesMap.put(new BoardHouse(PlayerEnum.BLACK, PieceEnum.KNIGHT).toString(), blackKnight);
        imagesMap.put(new BoardHouse(PlayerEnum.BLACK, PieceEnum.PAWN).toString(), blackPawn);
        imagesMap.put(new BoardHouse(PlayerEnum.BLACK, PieceEnum.QUEEN).toString(), blackQueen);
        imagesMap.put(new BoardHouse(PlayerEnum.BLACK, PieceEnum.ROOK).toString(), blackRook);
        imagesMap.put(new BoardHouse(PlayerEnum.WHITE, PieceEnum.BISHOP).toString(), whiteBishop);
        imagesMap.put(new BoardHouse(PlayerEnum.WHITE, PieceEnum.KING).toString(), whiteKing);
        imagesMap.put(new BoardHouse(PlayerEnum.WHITE, PieceEnum.KNIGHT).toString(), whiteKnight);
        imagesMap.put(new BoardHouse(PlayerEnum.WHITE, PieceEnum.PAWN).toString(), whitePawn);
        imagesMap.put(new BoardHouse(PlayerEnum.WHITE, PieceEnum.QUEEN).toString(), whiteQueen);
        imagesMap.put(new BoardHouse(PlayerEnum.WHITE, PieceEnum.ROOK).toString(), whiteRook);
    }
}
