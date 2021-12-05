package Chess.Match;

import java.awt.Point;
import Chess.Match.Piece.PieceEnum;
import Chess.Match.Piece.PieceFactory;
import Chess.Match.Piece.MovePiece.MovePieceDTO;
import Chess.Match.Player.PlayerEnum;

public class BoardModel {
    private BoardHouse[][] board = {
            {
                    new BoardHouse(PlayerEnum.BLACK, PieceEnum.ROOK),
                    new BoardHouse(PlayerEnum.BLACK, PieceEnum.KNIGHT),
                    new BoardHouse(PlayerEnum.BLACK, PieceEnum.BISHOP),
                    new BoardHouse(PlayerEnum.BLACK, PieceEnum.KING),
                    new BoardHouse(PlayerEnum.BLACK, PieceEnum.QUEEN),
                    new BoardHouse(PlayerEnum.BLACK, PieceEnum.BISHOP),
                    new BoardHouse(PlayerEnum.BLACK, PieceEnum.KNIGHT),
                    new BoardHouse(PlayerEnum.BLACK, PieceEnum.ROOK)
            },
            {
                    new BoardHouse(PlayerEnum.BLACK, PieceEnum.PAWN),
                    new BoardHouse(PlayerEnum.BLACK, PieceEnum.PAWN),
                    new BoardHouse(PlayerEnum.BLACK, PieceEnum.PAWN),
                    new BoardHouse(PlayerEnum.BLACK, PieceEnum.PAWN),
                    new BoardHouse(PlayerEnum.BLACK, PieceEnum.PAWN),
                    new BoardHouse(PlayerEnum.BLACK, PieceEnum.PAWN),
                    new BoardHouse(PlayerEnum.BLACK, PieceEnum.PAWN),
                    new BoardHouse(PlayerEnum.BLACK, PieceEnum.PAWN)
            },
            {
                    new BoardHouse(PlayerEnum.NONE, PieceEnum.NONE),
                    new BoardHouse(PlayerEnum.NONE, PieceEnum.NONE),
                    new BoardHouse(PlayerEnum.NONE, PieceEnum.NONE),
                    new BoardHouse(PlayerEnum.NONE, PieceEnum.NONE),
                    new BoardHouse(PlayerEnum.NONE, PieceEnum.NONE),
                    new BoardHouse(PlayerEnum.NONE, PieceEnum.NONE),
                    new BoardHouse(PlayerEnum.NONE, PieceEnum.NONE),
                    new BoardHouse(PlayerEnum.NONE, PieceEnum.NONE)
            },
            {
                    new BoardHouse(PlayerEnum.NONE, PieceEnum.NONE),
                    new BoardHouse(PlayerEnum.NONE, PieceEnum.NONE),
                    new BoardHouse(PlayerEnum.NONE, PieceEnum.NONE),
                    new BoardHouse(PlayerEnum.NONE, PieceEnum.NONE),
                    new BoardHouse(PlayerEnum.NONE, PieceEnum.NONE),
                    new BoardHouse(PlayerEnum.NONE, PieceEnum.NONE),
                    new BoardHouse(PlayerEnum.NONE, PieceEnum.NONE),
                    new BoardHouse(PlayerEnum.NONE, PieceEnum.NONE)
            },
            {
                    new BoardHouse(PlayerEnum.NONE, PieceEnum.NONE),
                    new BoardHouse(PlayerEnum.NONE, PieceEnum.NONE),
                    new BoardHouse(PlayerEnum.NONE, PieceEnum.NONE),
                    new BoardHouse(PlayerEnum.NONE, PieceEnum.NONE),
                    new BoardHouse(PlayerEnum.NONE, PieceEnum.NONE),
                    new BoardHouse(PlayerEnum.NONE, PieceEnum.NONE),
                    new BoardHouse(PlayerEnum.NONE, PieceEnum.NONE),
                    new BoardHouse(PlayerEnum.NONE, PieceEnum.NONE)
            },
            {
                    new BoardHouse(PlayerEnum.NONE, PieceEnum.NONE),
                    new BoardHouse(PlayerEnum.NONE, PieceEnum.NONE),
                    new BoardHouse(PlayerEnum.NONE, PieceEnum.NONE),
                    new BoardHouse(PlayerEnum.NONE, PieceEnum.NONE),
                    new BoardHouse(PlayerEnum.NONE, PieceEnum.NONE),
                    new BoardHouse(PlayerEnum.NONE, PieceEnum.NONE),
                    new BoardHouse(PlayerEnum.NONE, PieceEnum.NONE),
                    new BoardHouse(PlayerEnum.NONE, PieceEnum.NONE)
            },
            {
                    new BoardHouse(PlayerEnum.WHITE, PieceEnum.PAWN),
                    new BoardHouse(PlayerEnum.WHITE, PieceEnum.PAWN),
                    new BoardHouse(PlayerEnum.WHITE, PieceEnum.PAWN),
                    new BoardHouse(PlayerEnum.WHITE, PieceEnum.PAWN),
                    new BoardHouse(PlayerEnum.WHITE, PieceEnum.PAWN),
                    new BoardHouse(PlayerEnum.WHITE, PieceEnum.PAWN),
                    new BoardHouse(PlayerEnum.WHITE, PieceEnum.PAWN),
                    new BoardHouse(PlayerEnum.WHITE, PieceEnum.PAWN)
            },
            {
                    new BoardHouse(PlayerEnum.WHITE, PieceEnum.ROOK),
                    new BoardHouse(PlayerEnum.WHITE, PieceEnum.KNIGHT),
                    new BoardHouse(PlayerEnum.WHITE, PieceEnum.BISHOP),
                    new BoardHouse(PlayerEnum.WHITE, PieceEnum.KING),
                    new BoardHouse(PlayerEnum.WHITE, PieceEnum.QUEEN),
                    new BoardHouse(PlayerEnum.WHITE, PieceEnum.BISHOP),
                    new BoardHouse(PlayerEnum.WHITE, PieceEnum.KNIGHT),
                    new BoardHouse(PlayerEnum.WHITE, PieceEnum.ROOK)
            }
    };

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
