package Chess.Match;

import java.awt.image.BufferedImage;
import java.awt.Point;

public class BoardController {
    BoardModel boardModel;
    BoardImages boardImages;

    BoardController() {
        boardModel = new BoardModel();
        boardImages = new BoardImages();
    }

    public BufferedImage getPieceImage(Point indexPoint) {
        final var currentHouse = boardModel.getModelHouse(indexPoint);
        if (currentHouse == null)
            return null;
        if (!boardImages.imagesMap.containsKey(currentHouse.toString()))
            return null;
        return boardImages.imagesMap.get(currentHouse.toString());
    }

    public void movePiece(Movement movement) {
        boardModel.movePiece(movement);
    }
}
