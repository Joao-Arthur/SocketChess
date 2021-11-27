package Board;

import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.util.HashMap;

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
            blackKnight  = loadImage("BlackKnight");
            blackPawn = loadImage("BlackPawn");
            blackQueen = loadImage("BlackQueen");
            blackRook = loadImage("BlackRook");
            whiteBishop = loadImage("WhiteBishop");
            whiteKing = loadImage("WhiteKing");
            whiteKnight = loadImage("WhiteKnight");
            whitePawn = loadImage("WhitePawn");
            whiteQueen = loadImage("WhiteQueen");
            whiteRook = loadImage("WhiteRook");
        } catch (IOException e) { }
    }

    private BufferedImage loadImage(String name) throws IOException {
        return ImageIO.read(getClass().getResource("Images/" + name + ".png"));
    }

    private void loadImagesMap() {
        imagesMap = new HashMap<String, BufferedImage>();
        imagesMap.put("BLACK_BISHOP", blackBishop);
        imagesMap.put("BLACK_KING", blackKing);
        imagesMap.put("BLACK_KNIGHT", blackKnight);
        imagesMap.put("BLACK_PAWN", blackPawn);
        imagesMap.put("BLACK_QUEEN", blackQueen);
        imagesMap.put("BLACK_ROOK", blackRook);
        imagesMap.put("WHITE_BISHOP", whiteBishop);
        imagesMap.put("WHITE_KING", whiteKing);
        imagesMap.put("WHITE_KNIGHT", whiteKnight);
        imagesMap.put("WHITE_PAWN", whitePawn);
        imagesMap.put("WHITE_QUEEN", whiteQueen);
        imagesMap.put("WHITE_ROOK", whiteRook);
    }
}
