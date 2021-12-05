package Chess.Match;

import java.awt.Point;
import Chess.Match.Piece.PieceEnum;
import Chess.Match.Piece.PieceFactory;
import Chess.Match.Piece.MovePiece.MovePieceDTO;
import Chess.Match.Player.PlayerEnum;

public class BoardModel {
    private BoardHouse[][] board;

    BoardModel() {
        board = BoardInitialState.boardInitialState;
    }

    public void movePiece(Movement movement) {
        final var fromHouse = getModelHouse(movement.from);
        final var toHouse = getModelHouse(movement.to);
        PieceFactory.from(fromHouse.piece)
                .movePiece(new MovePieceDTO(movement.from, fromHouse, movement.to, toHouse));
        update(movement);
    }

    public BoardHouse getModelHouse(Point point) {
        return board[point.y][point.x];
    }

    private void update(Movement movement) {
        board[movement.to.y][movement.to.x] = new BoardHouse(getModelHouse(movement.from));
        board[movement.from.y][movement.from.x] = new BoardHouse(PlayerEnum.NONE, PieceEnum.NONE);
    }

    @Override
    public String toString() {
        return "";
    }
}
