package Board;

import java.awt.Point;

import Board.Piece.PieceEnum;

public class BoardModel {
    private BoardHouse[][] board = {
            {
                    new BoardHouse(BoardPiece.ROOK, BoardPlayer.BLACK),
                    new BoardHouse(BoardPiece.KNIGHT, BoardPlayer.BLACK),
                    new BoardHouse(BoardPiece.BISHOP, BoardPlayer.BLACK),
                    new BoardHouse(BoardPiece.KING, BoardPlayer.BLACK),
                    new BoardHouse(BoardPiece.QUEEN, BoardPlayer.BLACK),
                    new BoardHouse(BoardPiece.BISHOP, BoardPlayer.BLACK),
                    new BoardHouse(BoardPiece.KNIGHT, BoardPlayer.BLACK),
                    new BoardHouse(BoardPiece.ROOK, BoardPlayer.BLACK)
        }, {
                    new BoardHouse(BoardPiece.PAWN, BoardPlayer.BLACK),
                    new BoardHouse(BoardPiece.PAWN, BoardPlayer.BLACK),
                    new BoardHouse(BoardPiece.PAWN, BoardPlayer.BLACK),
                    new BoardHouse(BoardPiece.PAWN, BoardPlayer.BLACK),
                    new BoardHouse(BoardPiece.PAWN, BoardPlayer.BLACK),
                    new BoardHouse(BoardPiece.PAWN, BoardPlayer.BLACK),
                    new BoardHouse(BoardPiece.PAWN, BoardPlayer.BLACK),
                    new BoardHouse(BoardPiece.PAWN, BoardPlayer.BLACK)
        },{
                    new BoardHouse(BoardPiece.NONE, BoardPlayer.NONE),
                    new BoardHouse(BoardPiece.NONE, BoardPlayer.NONE),
                    new BoardHouse(BoardPiece.NONE, BoardPlayer.NONE),
                    new BoardHouse(BoardPiece.NONE, BoardPlayer.NONE),
                    new BoardHouse(BoardPiece.NONE, BoardPlayer.NONE),
                    new BoardHouse(BoardPiece.NONE, BoardPlayer.NONE),
                    new BoardHouse(BoardPiece.NONE, BoardPlayer.NONE),
                    new BoardHouse(BoardPiece.NONE, BoardPlayer.NONE)
        }, {
                    new BoardHouse(BoardPiece.NONE, BoardPlayer.NONE),
                    new BoardHouse(BoardPiece.NONE, BoardPlayer.NONE),
                    new BoardHouse(BoardPiece.NONE, BoardPlayer.NONE),
                    new BoardHouse(BoardPiece.NONE, BoardPlayer.NONE),
                    new BoardHouse(BoardPiece.NONE, BoardPlayer.NONE),
                    new BoardHouse(BoardPiece.NONE, BoardPlayer.NONE),
                    new BoardHouse(BoardPiece.NONE, BoardPlayer.NONE),
                    new BoardHouse(BoardPiece.NONE, BoardPlayer.NONE)
        }, {
                    new BoardHouse(BoardPiece.NONE, BoardPlayer.NONE),
                    new BoardHouse(BoardPiece.NONE, BoardPlayer.NONE),
                    new BoardHouse(BoardPiece.NONE, BoardPlayer.NONE),
                    new BoardHouse(BoardPiece.NONE, BoardPlayer.NONE),
                    new BoardHouse(BoardPiece.NONE, BoardPlayer.NONE),
                    new BoardHouse(BoardPiece.NONE, BoardPlayer.NONE),
                    new BoardHouse(BoardPiece.NONE, BoardPlayer.NONE),
                    new BoardHouse(BoardPiece.NONE, BoardPlayer.NONE)
        }, {
                    new BoardHouse(BoardPiece.NONE, BoardPlayer.NONE),
                    new BoardHouse(BoardPiece.NONE, BoardPlayer.NONE),
                    new BoardHouse(BoardPiece.NONE, BoardPlayer.NONE),
                    new BoardHouse(BoardPiece.NONE, BoardPlayer.NONE),
                    new BoardHouse(BoardPiece.NONE, BoardPlayer.NONE),
                    new BoardHouse(BoardPiece.NONE, BoardPlayer.NONE),
                    new BoardHouse(BoardPiece.NONE, BoardPlayer.NONE),
                    new BoardHouse(BoardPiece.NONE, BoardPlayer.NONE)
        }, {
                    new BoardHouse(BoardPiece.PAWN, BoardPlayer.WHITE),
                    new BoardHouse(BoardPiece.PAWN, BoardPlayer.WHITE),
                    new BoardHouse(BoardPiece.PAWN, BoardPlayer.WHITE),
                    new BoardHouse(BoardPiece.PAWN, BoardPlayer.WHITE),
                    new BoardHouse(BoardPiece.PAWN, BoardPlayer.WHITE),
                    new BoardHouse(BoardPiece.PAWN, BoardPlayer.WHITE),
                    new BoardHouse(BoardPiece.PAWN, BoardPlayer.WHITE),
                    new BoardHouse(BoardPiece.PAWN, BoardPlayer.WHITE)
        }, {
                    new BoardHouse(BoardPiece.ROOK, BoardPlayer.WHITE),
                    new BoardHouse(BoardPiece.KNIGHT, BoardPlayer.WHITE),
                    new BoardHouse(BoardPiece.BISHOP, BoardPlayer.WHITE),
                    new BoardHouse(BoardPiece.KING, BoardPlayer.WHITE),
                    new BoardHouse(BoardPiece.QUEEN, BoardPlayer.WHITE),
                    new BoardHouse(BoardPiece.BISHOP, BoardPlayer.WHITE),
                    new BoardHouse(BoardPiece.KNIGHT, BoardPlayer.WHITE),
                    new BoardHouse(BoardPiece.ROOK, BoardPlayer.WHITE)
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
        board[(int) from.getY()][(int) from.getX()] = new BoardHouse(PieceEnum.NONE, BoardPlayer.NONE);
    }
}
