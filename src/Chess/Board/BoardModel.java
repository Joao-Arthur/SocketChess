package Board;

import java.awt.Point;

import Board.Piece.PieceEnum;

public class BoardModel {
    private BoardHouse[][] board = {
            {
                    new BoardHouse(BoardPlayer.BLACK, PieceEnum.ROOK),
                    new BoardHouse(BoardPlayer.BLACK, PieceEnum.KNIGHT),
                    new BoardHouse(BoardPlayer.BLACK, PieceEnum.BISHOP),
                    new BoardHouse(BoardPlayer.BLACK, PieceEnum.KING),
                    new BoardHouse(BoardPlayer.BLACK, PieceEnum.QUEEN),
                    new BoardHouse(BoardPlayer.BLACK, PieceEnum.BISHOP),
                    new BoardHouse(BoardPlayer.BLACK, PieceEnum.KNIGHT),
                    new BoardHouse(BoardPlayer.BLACK, PieceEnum.ROOK)
            },
            {
                    new BoardHouse(BoardPlayer.BLACK, PieceEnum.PAWN),
                    new BoardHouse(BoardPlayer.BLACK, PieceEnum.PAWN),
                    new BoardHouse(BoardPlayer.BLACK, PieceEnum.PAWN),
                    new BoardHouse(BoardPlayer.BLACK, PieceEnum.PAWN),
                    new BoardHouse(BoardPlayer.BLACK, PieceEnum.PAWN),
                    new BoardHouse(BoardPlayer.BLACK, PieceEnum.PAWN),
                    new BoardHouse(BoardPlayer.BLACK, PieceEnum.PAWN),
                    new BoardHouse(BoardPlayer.BLACK, PieceEnum.PAWN)
            },
            {
                    new BoardHouse(BoardPlayer.NONE, PieceEnum.NONE),
                    new BoardHouse(BoardPlayer.NONE, PieceEnum.NONE),
                    new BoardHouse(BoardPlayer.NONE, PieceEnum.NONE),
                    new BoardHouse(BoardPlayer.NONE, PieceEnum.NONE),
                    new BoardHouse(BoardPlayer.NONE, PieceEnum.NONE),
                    new BoardHouse(BoardPlayer.NONE, PieceEnum.NONE),
                    new BoardHouse(BoardPlayer.NONE, PieceEnum.NONE),
                    new BoardHouse(BoardPlayer.NONE, PieceEnum.NONE)
            },
            {
                    new BoardHouse(BoardPlayer.NONE, PieceEnum.NONE),
                    new BoardHouse(BoardPlayer.NONE, PieceEnum.NONE),
                    new BoardHouse(BoardPlayer.NONE, PieceEnum.NONE),
                    new BoardHouse(BoardPlayer.NONE, PieceEnum.NONE),
                    new BoardHouse(BoardPlayer.NONE, PieceEnum.NONE),
                    new BoardHouse(BoardPlayer.NONE, PieceEnum.NONE),
                    new BoardHouse(BoardPlayer.NONE, PieceEnum.NONE),
                    new BoardHouse(BoardPlayer.NONE, PieceEnum.NONE)
            },
            {
                    new BoardHouse(BoardPlayer.NONE, PieceEnum.NONE),
                    new BoardHouse(BoardPlayer.NONE, PieceEnum.NONE),
                    new BoardHouse(BoardPlayer.NONE, PieceEnum.NONE),
                    new BoardHouse(BoardPlayer.NONE, PieceEnum.NONE),
                    new BoardHouse(BoardPlayer.NONE, PieceEnum.NONE),
                    new BoardHouse(BoardPlayer.NONE, PieceEnum.NONE),
                    new BoardHouse(BoardPlayer.NONE, PieceEnum.NONE),
                    new BoardHouse(BoardPlayer.NONE, PieceEnum.NONE)
            },
            {
                    new BoardHouse(BoardPlayer.NONE, PieceEnum.NONE),
                    new BoardHouse(BoardPlayer.NONE, PieceEnum.NONE),
                    new BoardHouse(BoardPlayer.NONE, PieceEnum.NONE),
                    new BoardHouse(BoardPlayer.NONE, PieceEnum.NONE),
                    new BoardHouse(BoardPlayer.NONE, PieceEnum.NONE),
                    new BoardHouse(BoardPlayer.NONE, PieceEnum.NONE),
                    new BoardHouse(BoardPlayer.NONE, PieceEnum.NONE),
                    new BoardHouse(BoardPlayer.NONE, PieceEnum.NONE)
            },
            {
                    new BoardHouse(BoardPlayer.WHITE, PieceEnum.PAWN),
                    new BoardHouse(BoardPlayer.WHITE, PieceEnum.PAWN),
                    new BoardHouse(BoardPlayer.WHITE, PieceEnum.PAWN),
                    new BoardHouse(BoardPlayer.WHITE, PieceEnum.PAWN),
                    new BoardHouse(BoardPlayer.WHITE, PieceEnum.PAWN),
                    new BoardHouse(BoardPlayer.WHITE, PieceEnum.PAWN),
                    new BoardHouse(BoardPlayer.WHITE, PieceEnum.PAWN),
                    new BoardHouse(BoardPlayer.WHITE, PieceEnum.PAWN)
            },
            {
                    new BoardHouse(BoardPlayer.WHITE, PieceEnum.ROOK),
                    new BoardHouse(BoardPlayer.WHITE, PieceEnum.KNIGHT),
                    new BoardHouse(BoardPlayer.WHITE, PieceEnum.BISHOP),
                    new BoardHouse(BoardPlayer.WHITE, PieceEnum.KING),
                    new BoardHouse(BoardPlayer.WHITE, PieceEnum.QUEEN),
                    new BoardHouse(BoardPlayer.WHITE, PieceEnum.BISHOP),
                    new BoardHouse(BoardPlayer.WHITE, PieceEnum.KNIGHT),
                    new BoardHouse(BoardPlayer.WHITE, PieceEnum.ROOK)
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
        if (fromHouse.player == BoardPlayer.NONE)
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
                if (deltaX > 1)
                    return;
                if ((deltaX == 1 && toHouse.piece == PieceEnum.NONE))
                    return;
                if (deltaY > 2)
                    return;
                if (fromHouse.player == BoardPlayer.WHITE) {
                    if (deltaY == 2 && (int) from.getY() != 6)
                        return;
                    if (distanceY != 1)
                        return;
                }
                if (fromHouse.player == BoardPlayer.BLACK) {
                    if (deltaY == 2 && (int) from.getY() != 1)
                        return;
                    if (distanceY != -1)
                        return;
                }
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

    public BoardHouse getModelHouse(int i, int j) {
        return board[i][j];
    }

    public BoardHouse getModelHouse(Point point) {
        return board[(int) point.getY()][(int) point.getX()];
    }

    private void update(Point from, Point to) {
        board[(int) to.getY()][(int) to.getX()] = getModelHouse(from);
        board[(int) from.getY()][(int) from.getX()] = new BoardHouse(BoardPlayer.NONE, PieceEnum.NONE);
    }
}
