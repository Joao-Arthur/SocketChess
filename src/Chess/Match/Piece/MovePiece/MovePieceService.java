package Chess.Match.Piece.MovePiece;

import Chess.Match.Player.PlayerEnum;

public class MovePieceService {
    public void execute(MovePieceDTO movePieceDTO) {
        if (movePieceDTO.from == null)
            throw new InvalidArgsException("from == null");
        if (movePieceDTO.fromHouse == null)
            throw new InvalidArgsException("fromHouse == null");
        if (movePieceDTO.to == null)
            throw new InvalidArgsException("to == null");
        if (movePieceDTO.toHouse == null)
            throw new InvalidArgsException("toHouse == null");
        if (movePieceDTO.fromHouse.player == PlayerEnum.NONE)
            throw new InvalidMovementException("fromHouse.player == PlayerEnum.NONE");
        if (movePieceDTO.fromHouse.player == movePieceDTO.toHouse.player)
            throw new InvalidMovementException("fromHouse.player == toHouse.player");
    }
}
