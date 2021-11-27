package Board;

import java.awt.image.BufferedImage;
import java.awt.Point;

public class ModelToView {
    BoardModel boardModel;
    BoardImages boardImages;

    ModelToView() {
        boardModel = new BoardModel();
        boardImages = new BoardImages();
    }

    public BufferedImage getPieceImage(int xIndex, int yIndex) {
        final var currentHouse = boardModel.getModelHouse(yIndex, xIndex);
        if (currentHouse == null)
            return null;
        if (!boardImages.imagesMap.containsKey(currentHouse.toString()))
            return null;
        return boardImages.imagesMap.get(currentHouse.toString());
    }

    public void movePiece(Point from, Point to) {
        final var fromHouse = boardModel.getModelHouse((int) from.getX(), (int) from.getY());
        final var toHouse = boardModel.getModelHouse((int) to.getX(), (int) to.getY());
        System.out.println(fromHouse + " -> " + toHouse);

    }
}
