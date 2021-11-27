package Board;

import java.awt.Point;

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
        if (fromHouse.piece == BoardPiece.NONE)
            return;
        if (fromHouse.player == BoardPlayer.NONE)
            return;
        System.out.println(fromHouse);
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
        board[(int) from.getY()][(int) from.getX()] = new BoardHouse(BoardPiece.NONE, BoardPlayer.NONE);
    }
}
