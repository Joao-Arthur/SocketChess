package Chess.Match.Board;

import java.awt.image.BufferedImage;
import java.awt.Point;
import Chess.Match.Movement;
import Chess.Match.Player.PlayerEnum;

public class Controller {
    private final Model model;
    private final ImageLoader imageLoader = new ImageLoader();

    public Controller(PlayerEnum player) {
        model = new Model(player);
    }

    public BufferedImage getPieceImage(Point indexPoint) {
        final var currentHouse = model.getModelHouse(indexPoint);
        if (currentHouse == null)
            return null;
        if (!imageLoader.imagesMap.containsKey(currentHouse.toString()))
            return null;
        return imageLoader.imagesMap.get(currentHouse.toString());
    }

    public void movePlayerPiece(Movement movement) {
        model.movePlayerPiece(movement);
    }

    public void moveOpponentPiece(Movement movement) {
        model.moveOpponentPiece(movement);
    }

}
