package Chess.Match.Board;

import java.awt.image.BufferedImage;
import Chess.Match.Movement;
import Chess.Match.Player.PlayerEnum;

import java.awt.Point;

public class Controller {
    Model model;
    ImageLoader imageLoader;

    public Controller(PlayerEnum player) {
        model = new Model(player);
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
