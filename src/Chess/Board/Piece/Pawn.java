package Board.Piece;

import Board.Piece.MovePiece.MovePieceService;
import Board.Piece.MovePiece.InvalidMovementException;
import Board.Piece.MovePiece.MovePieceDTO;

public class Pawn implements PieceInterface {
    public void movePiece(MovePieceDTO movePieceDTO) {
        final var moveService = new MovePieceService();
        moveService.execute(movePieceDTO);

        if (movePieceDTO.deltaX > 1 || movePieceDTO.deltaY > 2)
            throw new InvalidMovementException("deltaX > 1 || deltaY > 2");

        if (movePieceDTO.fromHouse.hasMoved && movePieceDTO.deltaY > 1)
            throw new InvalidMovementException("fromHouse.hasMoved && deltaY > 1");

        if (movePieceDTO.deltaX == 1 && movePieceDTO.deltaY == 0)
            throw new InvalidMovementException("deltaX == 1 && deltaY == 0");

        if ((movePieceDTO.deltaX == 1 && movePieceDTO.toHouse.piece == PieceEnum.NONE))
            throw new InvalidMovementException("deltaX == 1 && toHouse.piece == PieceEnum.NONE");

        switch (movePieceDTO.fromHouse.player) {
            case WHITE:
                if (movePieceDTO.distanceY < 0)
                    throw new InvalidMovementException("distanceY < 0");
                break;
            case BLACK:
                if (movePieceDTO.distanceY > 0)
                    throw new InvalidMovementException("distanceY > 0");
                break;
            default:
                break;
        }
    }
}