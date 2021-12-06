package Chess.Match.Board;

import java.awt.Point;
import Chess.Match.Movement;
import Chess.Match.Board.Piece.PieceEnum;
import Chess.Match.Board.Piece.PieceFactory;
import Chess.Match.Board.Piece.MovePiece.InvalidMovementException;
import Chess.Match.Board.Piece.MovePiece.MovePieceDTO;
import Chess.Match.Board.Piece.MovePiece.RepeatedMoveException;
import Chess.Match.Player.PlayerEnum;
import Chess.Match.Services.GetPlayerByOpponentService;

public class Model {
    private House[][] board;
    private final PlayerEnum player;
    private PlayerEnum lastPlayerToMove = PlayerEnum.BLACK;

    Model(PlayerEnum player) {
        board = ModelInitialState.board;
        this.player = player;
    }

    public void movePlayerPiece(Movement movement) {
        final var dto = getDTO(movement);
        if (dto.fromHouse.player != player)
            throw new InvalidMovementException("fromPlayer != player");
        if (dto.fromHouse.player == lastPlayerToMove)
            throw new RepeatedMoveException();
        PieceFactory.from(dto.fromHouse.piece).movePiece(dto);
        update(movement);
    }

    public void moveOpponentPiece(Movement movement) {
        final var dto = getDTO(movement);
        if (dto.fromHouse.player == player)
            throw new InvalidMovementException("fromPlayer == player");
        if (dto.fromHouse.player == lastPlayerToMove)
            throw new RepeatedMoveException();
        PieceFactory.from(dto.fromHouse.piece).movePiece(dto);
        update(movement);
    }

    private MovePieceDTO getDTO(Movement movement) {
        final var fromHouse = getModelHouse(movement.from);
        final var toHouse = getModelHouse(movement.to);
        return new MovePieceDTO(player, movement.from, fromHouse, movement.to, toHouse);
    }

    public House getModelHouse(Point point) {
        return board[point.y][point.x];
    }

    private void update(Movement movement) {
        lastPlayerToMove = new GetPlayerByOpponentService(lastPlayerToMove).get();
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
