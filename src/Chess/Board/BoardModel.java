package Board;

import java.awt.Point;

import Board.Piece.PieceEnum;
import Board.Piece.PieceFactory;
import Board.Piece.MovePiece.MovePieceDTO;
import Board.Player.PlayerEnum;
import Board.Piece.MovePiece.InvalidArgsException;
import Board.Piece.MovePiece.InvalidMovementException;
import Board.Piece.MovePiece.NoSuchPieceException;
import java.util.logging.Logger;
import java.util.logging.Level;

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

    public void movePiece(Point from, Point to) {
        final var fromHouse = getModelHouse(from);
        final var toHouse = getModelHouse(to);
        if (fromHouse == null)
            return;
        if (toHouse == null)
            return;
        if (fromHouse.piece == PieceEnum.NONE)
            return;
        if (fromHouse.player == PlayerEnum.NONE)
            return;
        if (fromHouse.player == toHouse.player)
            return;

        final var distanceX = (int) from.getX() - (int) to.getX();
        final var deltaX = Math.abs(distanceX);
        final var distanceY = (int) from.getY() - (int) to.getY();
        final var deltaY = Math.abs(distanceY);

        switch (fromHouse.piece) {
            case NONE:
                return;
            case PAWN:
                var bool = false;
                try {
                    PieceFactory.from(fromHouse.piece)
                            .movePiece(new MovePieceDTO(from, fromHouse, to, toHouse));
                } catch (InvalidArgsException exception) {
                    Logger.getLogger(BoardModel.class.getName()).log(Level.SEVERE, null, exception);
                    bool = true;
                } catch (InvalidMovementException exception) {
                    Logger.getLogger(BoardModel.class.getName()).log(Level.INFO, null, exception);
                    bool = true;
                } catch (NoSuchPieceException exception) {
                    Logger.getLogger(BoardModel.class.getName()).log(Level.INFO, null, exception);
                    bool = true;
                }
                if (bool)
                    return;
                break;
            case ROOK:
                if (deltaX > 0 && deltaY > 0)
                    return;
                break;
            case BISHOP:
                if (deltaX != deltaY)
                    return;
                break;
            case KNIGHT:
                if ((deltaY != 2 || deltaX != 1) && (deltaX != 2 || deltaY != 1))
                    return;
                break;
            case KING:
                if (deltaX > 1 || deltaY > 1)
                    return;
                break;
            case QUEEN:
                if ((deltaX > 0 && deltaY > 0) && (deltaX != deltaY))
                    return;
                break;
        }
        update(from, to);
    }

    public BoardHouse getModelHouse(int yIndex, int xIndex) {
        return board[yIndex][xIndex];
    }

    public BoardHouse getModelHouse(Point point) {
        return getModelHouse((int) point.getY(), (int) point.getX());
    }

    private void update(Point from, Point to) {
        board[(int) to.getY()][(int) to.getX()] = new BoardHouse(getModelHouse(from));
        board[(int) from.getY()][(int) from.getX()] = new BoardHouse(PlayerEnum.NONE, PieceEnum.NONE);
    }
}
