package Chess.Match.Board;

import Chess.Match.Board.Piece.PieceEnum;
import Chess.Match.Player.PlayerEnum;

public class ModelInitialState {
    public static House[][] board = {
            {
                    new House(PlayerEnum.BLACK, PieceEnum.ROOK),
                    new House(PlayerEnum.BLACK, PieceEnum.KNIGHT),
                    new House(PlayerEnum.BLACK, PieceEnum.BISHOP),
                    new House(PlayerEnum.BLACK, PieceEnum.QUEEN),
                    new House(PlayerEnum.BLACK, PieceEnum.KING),
                    new House(PlayerEnum.BLACK, PieceEnum.BISHOP),
                    new House(PlayerEnum.BLACK, PieceEnum.KNIGHT),
                    new House(PlayerEnum.BLACK, PieceEnum.ROOK)
            },
            {
                    new House(PlayerEnum.BLACK, PieceEnum.PAWN),
                    new House(PlayerEnum.BLACK, PieceEnum.PAWN),
                    new House(PlayerEnum.BLACK, PieceEnum.PAWN),
                    new House(PlayerEnum.BLACK, PieceEnum.PAWN),
                    new House(PlayerEnum.BLACK, PieceEnum.PAWN),
                    new House(PlayerEnum.BLACK, PieceEnum.PAWN),
                    new House(PlayerEnum.BLACK, PieceEnum.PAWN),
                    new House(PlayerEnum.BLACK, PieceEnum.PAWN)
            },
            {
                    new House(PlayerEnum.NONE, PieceEnum.NONE),
                    new House(PlayerEnum.NONE, PieceEnum.NONE),
                    new House(PlayerEnum.NONE, PieceEnum.NONE),
                    new House(PlayerEnum.NONE, PieceEnum.NONE),
                    new House(PlayerEnum.NONE, PieceEnum.NONE),
                    new House(PlayerEnum.NONE, PieceEnum.NONE),
                    new House(PlayerEnum.NONE, PieceEnum.NONE),
                    new House(PlayerEnum.NONE, PieceEnum.NONE)
            },
            {
                    new House(PlayerEnum.NONE, PieceEnum.NONE),
                    new House(PlayerEnum.NONE, PieceEnum.NONE),
                    new House(PlayerEnum.NONE, PieceEnum.NONE),
                    new House(PlayerEnum.NONE, PieceEnum.NONE),
                    new House(PlayerEnum.NONE, PieceEnum.NONE),
                    new House(PlayerEnum.NONE, PieceEnum.NONE),
                    new House(PlayerEnum.NONE, PieceEnum.NONE),
                    new House(PlayerEnum.NONE, PieceEnum.NONE)
            },
            {
                    new House(PlayerEnum.NONE, PieceEnum.NONE),
                    new House(PlayerEnum.NONE, PieceEnum.NONE),
                    new House(PlayerEnum.NONE, PieceEnum.NONE),
                    new House(PlayerEnum.NONE, PieceEnum.NONE),
                    new House(PlayerEnum.NONE, PieceEnum.NONE),
                    new House(PlayerEnum.NONE, PieceEnum.NONE),
                    new House(PlayerEnum.NONE, PieceEnum.NONE),
                    new House(PlayerEnum.NONE, PieceEnum.NONE)
            },
            {
                    new House(PlayerEnum.NONE, PieceEnum.NONE),
                    new House(PlayerEnum.NONE, PieceEnum.NONE),
                    new House(PlayerEnum.NONE, PieceEnum.NONE),
                    new House(PlayerEnum.NONE, PieceEnum.NONE),
                    new House(PlayerEnum.NONE, PieceEnum.NONE),
                    new House(PlayerEnum.NONE, PieceEnum.NONE),
                    new House(PlayerEnum.NONE, PieceEnum.NONE),
                    new House(PlayerEnum.NONE, PieceEnum.NONE)
            },
            {
                    new House(PlayerEnum.WHITE, PieceEnum.PAWN),
                    new House(PlayerEnum.WHITE, PieceEnum.PAWN),
                    new House(PlayerEnum.WHITE, PieceEnum.PAWN),
                    new House(PlayerEnum.WHITE, PieceEnum.PAWN),
                    new House(PlayerEnum.WHITE, PieceEnum.PAWN),
                    new House(PlayerEnum.WHITE, PieceEnum.PAWN),
                    new House(PlayerEnum.WHITE, PieceEnum.PAWN),
                    new House(PlayerEnum.WHITE, PieceEnum.PAWN)
            },
            {
                    new House(PlayerEnum.WHITE, PieceEnum.ROOK),
                    new House(PlayerEnum.WHITE, PieceEnum.KNIGHT),
                    new House(PlayerEnum.WHITE, PieceEnum.BISHOP),
                    new House(PlayerEnum.WHITE, PieceEnum.QUEEN),
                    new House(PlayerEnum.WHITE, PieceEnum.KING),
                    new House(PlayerEnum.WHITE, PieceEnum.BISHOP),
                    new House(PlayerEnum.WHITE, PieceEnum.KNIGHT),
                    new House(PlayerEnum.WHITE, PieceEnum.ROOK)
            }
    };
}
