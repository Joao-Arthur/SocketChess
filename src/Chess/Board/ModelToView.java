package Board;

import java.awt.image.BufferedImage;

public class ModelToView {
    BoardModel boardModel;
    BoardImages boardImages;

    ModelToView() {
        boardModel = new BoardModel();
        boardImages = new BoardImages();
    }

    public BufferedImage getPieceImage(int yIndex, int xIndex) {
        final var currentHouse = boardModel.getModelHouse(yIndex, xIndex);
        if(currentHouse == null)
            return null;
        if (!boardImages.imagesMap.containsKey(currentHouse.player.toString() + "_" + currentHouse.piece.toString()))
        return null;
        return boardImages.imagesMap.get(currentHouse.player.toString() + "_" + currentHouse.piece.toString());
    }
}
