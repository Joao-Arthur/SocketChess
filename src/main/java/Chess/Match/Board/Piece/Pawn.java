package Chess.Match.Board.Piece;

import Chess.Match.Board.Piece.MovePiece.InvalidMovementException;
import Chess.Match.Board.Piece.MovePiece.MovePieceDTO;
import Chess.Match.Board.Piece.MovePiece.MovePieceService;
import Chess.Match.Player.PlayerEnum;

public class Pawn implements PieceInterface {
    public void movePiece(MovePieceDTO movePieceDTO) {
        final var moveService = new MovePieceService();
        moveService.execute(movePieceDTO);

        final var verticalMove = movePieceDTO.deltaX == 0;
        final var diagonalMove = !verticalMove;

        if (movePieceDTO.deltaX > 1 || movePieceDTO.deltaY > 2)
            throw new InvalidMovementException("deltaX > 1 and deltaY > 2");

        if (movePieceDTO.fromHouse.hasMoved && movePieceDTO.deltaY == 2)
            throw new InvalidMovementException("fromHasMoved and deltaY = 2");

        if (diagonalMove && movePieceDTO.deltaY == 0)
            throw new InvalidMovementException("diagonalMove and deltaY = 0");

        if ((diagonalMove && movePieceDTO.toHouse.piece == PieceEnum.NONE))
            throw new InvalidMovementException("diagonalMove and toPiece = NONE");

        if ((verticalMove && movePieceDTO.toHouse.piece != PieceEnum.NONE))
            throw new InvalidMovementException("verticalMove and toPiece != NONE");

        if (movePieceDTO.fromHouse.player == PlayerEnum.WHITE && movePieceDTO.distanceY < 0)
            throw new InvalidMovementException("fromPlayer = WHITE and distanceY < 0");

        if (movePieceDTO.fromHouse.player == PlayerEnum.BLACK && movePieceDTO.distanceY > 0)
            throw new InvalidMovementException("fromPlayer = BLACK and distanceY > 0");
    }
}