package Chess.Match;

import java.awt.image.BufferedImage;

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

    public void movePiece(MovementDTO movement) {
        boardModel.movePiece(movement);
    }
}
