package Chess.Match.Board;

import java.awt.Point;

import Chess.Match.Movement;
import Chess.Match.Board.Piece.PieceEnum;
import Chess.Match.Board.Piece.PieceFactory;
import Chess.Match.Board.Piece.MovePiece.MovePieceDTO;
import Chess.Match.Player.PlayerEnum;

public class Model {
    private House[][] board;

    Model() {
        board = ModelInitialState.board;
    }

    public void movePiece(Movement movement) {
        final var fromHouse = getModelHouse(movement.from);
        final var toHouse = getModelHouse(movement.to);
        PieceFactory.from(fromHouse.piece)
                .movePiece(new MovePieceDTO(movement.from, fromHouse, movement.to, toHouse));
        update(movement);
    }

    public House getModelHouse(Point point) {
        return board[point.y][point.x];
    }

    private void update(Movement movement) {
        board[movement.to.y][movement.to.x] = new House(getModelHouse(movement.from));
        board[movement.from.y][movement.from.x] = new House(PlayerEnum.NONE, PieceEnum.NONE);
    }

    @Override
    public String toString() {
        return "";
    }

    public String toCLI() {
        final var boardRepresentation = new StringBuilder();
        for (var yIndex = 0; yIndex < 8; yIndex++) {
            for (var xIndex = 0; xIndex < 8; xIndex++) {
                boardRepresentation.append(board[yIndex][xIndex].toCLI());
            }
            boardRepresentation.append('\n');
        }
        return boardRepresentation.toString();
    }
}
