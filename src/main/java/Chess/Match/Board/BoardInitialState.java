package Chess.Match.Board;

import Chess.Match.Board.Piece.PieceEnum;
import Chess.Match.Player.PlayerEnum;

public class BoardInitialState {
        public static BoardHouse[][] boardInitialState = {
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
}
