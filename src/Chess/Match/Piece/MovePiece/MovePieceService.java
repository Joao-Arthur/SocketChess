package Chess.Match.Piece.MovePiece;

import Chess.Match.Piece.PieceEnum;
import Chess.Match.Player.PlayerEnum;

public class MovePieceService {
    public void execute(MovePieceDTO movePieceDTO) {
        if (movePieceDTO.from == null)
            throw new InvalidArgsException("from = null");
        if (movePieceDTO.fromHouse == null)
            throw new InvalidArgsException("fromHouse = null");
        if (movePieceDTO.to == null)
            throw new InvalidArgsException("to = null");
        if (movePieceDTO.toHouse == null)
            throw new InvalidArgsException("toHouse = null");
        if (movePieceDTO.fromHouse.player == PlayerEnum.NONE)
            throw new InvalidMovementException("fromPlayer = NONE");
        if (movePieceDTO.fromHouse.player == movePieceDTO.toHouse.player)
            throw new InvalidMovementException("fromPlayer = toPlayer");
        if (movePieceDTO.toHouse.piece == PieceEnum.KING)
            throw new InvalidMovementException("toPiece = KING");
    }
}
