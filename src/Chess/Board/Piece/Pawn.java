package Chess.Board.Piece;

import Chess.Board.Piece.MovePiece.MovePieceService;
import Chess.Board.Player.PlayerEnum;
import Chess.Board.Piece.MovePiece.MovePieceDTO;
import Chess.Board.Piece.MovePiece.InvalidMovementException;

public class Pawn implements PieceInterface {
    public void movePiece(MovePieceDTO movePieceDTO) {
        final var moveService = new MovePieceService();
        moveService.execute(movePieceDTO);

        final var verticalMove = movePieceDTO.deltaX == 0;
        final var diagonalMove = !verticalMove;

        if (movePieceDTO.deltaX > 1 || movePieceDTO.deltaY > 2)
            throw new InvalidMovementException("deltaX > 1 || deltaY > 2");

        if (movePieceDTO.fromHouse.hasMoved && movePieceDTO.deltaY == 2)
            throw new InvalidMovementException("fromHouse.hasMoved && deltaY == 2");

        if (diagonalMove && movePieceDTO.deltaY == 0)
            throw new InvalidMovementException("diagonalMove && deltaY == 0");

        if ((diagonalMove && movePieceDTO.toHouse.piece == PieceEnum.NONE))
            throw new InvalidMovementException("diagonalMove && toHouse.piece == PieceEnum.NONE");

        if ((verticalMove && movePieceDTO.toHouse.piece != PieceEnum.NONE))
            throw new InvalidMovementException("verticalMove && toHouse.piece != PieceEnum.NONE");

        if (movePieceDTO.fromHouse.player == PlayerEnum.WHITE && movePieceDTO.distanceY < 0)
            throw new InvalidMovementException("fromHouse.player == PlayerEnum.WHITE && distanceY < 0");

        if (movePieceDTO.fromHouse.player == PlayerEnum.BLACK && movePieceDTO.distanceY > 0)
            throw new InvalidMovementException("fromHouse.player == PlayerEnum.BLACK && distanceY > 0");
    }
}