package Chess.Match;

import java.awt.Point;

import Chess.Match.Piece.PieceEnum;
import Chess.Match.Piece.PieceFactory;
import Chess.Match.Piece.MovePiece.MovePieceDTO;
import Chess.Match.Player.PlayerEnum;
import Chess.Match.Piece.MovePiece.InvalidArgsException;
import Chess.Match.Piece.MovePiece.InvalidMovementException;
import Chess.Match.Piece.MovePiece.NoSuchPieceException;
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
        try {
            PieceFactory.from(fromHouse.piece).movePiece(new MovePieceDTO(from, fromHouse, to, toHouse));
            update(from, to);
        } catch (InvalidArgsException exception) {
            Logger.getLogger(BoardModel.class.getName()).log(Level.SEVERE, null, exception);
        } catch (InvalidMovementException exception) {
            Logger.getLogger(BoardModel.class.getName()).log(Level.INFO, null, exception);
        } catch (NoSuchPieceException exception) {
            Logger.getLogger(BoardModel.class.getName()).log(Level.INFO, null, exception);
        }
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