package Chess.Match.Board;

import java.awt.image.BufferedImage;

import Chess.Match.Movement;

import java.awt.Point;

public class Controller {
    Model model;
    ImageLoader imageLoader;

    public Controller() {
        model = new Model();
        imageLoader = new ImageLoader();
    }

    public BufferedImage getPieceImage(Point indexPoint) {
        final var currentHouse = model.getModelHouse(indexPoint);
        if (currentHouse == null)
            return null;
        if (!imageLoader.imagesMap.containsKey(currentHouse.toString()))
            return null;
        return imageLoader.imagesMap.get(currentHouse.toString());
    }

    public void movePiece(Movement movement) {
        model.movePiece(movement);
    }
}
