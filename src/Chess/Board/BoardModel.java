package Board;

public class BoardModel {
    private BoardHouse[][] board = {
        {
            new BoardHouse(BoardPiece.ROOK, BoardPlayer.BLACK),
            new BoardHouse(BoardPiece.KNIGTH, BoardPlayer.BLACK),
            new BoardHouse(BoardPiece.BISHOP, BoardPlayer.BLACK),
            new BoardHouse(BoardPiece.KING, BoardPlayer.BLACK),
            new BoardHouse(BoardPiece.QUEEN, BoardPlayer.BLACK),
            new BoardHouse(BoardPiece.BISHOP, BoardPlayer.BLACK),
            new BoardHouse(BoardPiece.KNIGTH, BoardPlayer.BLACK),
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
            new BoardHouse(BoardPiece.KNIGTH, BoardPlayer.WHITE),
            new BoardHouse(BoardPiece.BISHOP, BoardPlayer.WHITE),
            new BoardHouse(BoardPiece.KING, BoardPlayer.WHITE),
            new BoardHouse(BoardPiece.QUEEN, BoardPlayer.WHITE),
            new BoardHouse(BoardPiece.BISHOP, BoardPlayer.WHITE),
            new BoardHouse(BoardPiece.KNIGTH, BoardPlayer.WHITE),
            new BoardHouse(BoardPiece.ROOK, BoardPlayer.WHITE)
        }
    };

    public void updateModel(BoardHouse from, BoardHouse to) {
        if (from == null)
            return;
        if (to == null)
            return;

    }
}
