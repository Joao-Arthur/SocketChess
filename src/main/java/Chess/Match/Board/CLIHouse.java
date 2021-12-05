package Chess.Match.Board;

import java.util.HashMap;

import Chess.Match.Board.Piece.PieceEnum;
import Chess.Match.Player.PlayerEnum;

public class CLIHouse {
    public static final HashMap<String, String> cliMap = new HashMap<String, String>(12);

    private static void loadEntries() {
        if (cliMap.size() > 0)
            return;
        cliMap.put(new House(PlayerEnum.BLACK, PieceEnum.BISHOP).toString(), "♝");
        cliMap.put(new House(PlayerEnum.BLACK, PieceEnum.KING).toString(), "♚");
        cliMap.put(new House(PlayerEnum.BLACK, PieceEnum.KNIGHT).toString(), "♞");
        cliMap.put(new House(PlayerEnum.BLACK, PieceEnum.PAWN).toString(), "♟️");
        cliMap.put(new House(PlayerEnum.BLACK, PieceEnum.QUEEN).toString(), "♛");
        cliMap.put(new House(PlayerEnum.BLACK, PieceEnum.ROOK).toString(), "♜");
        cliMap.put(new House(PlayerEnum.WHITE, PieceEnum.BISHOP).toString(), "♗");
        cliMap.put(new House(PlayerEnum.WHITE, PieceEnum.KING).toString(), "♔");
        cliMap.put(new House(PlayerEnum.WHITE, PieceEnum.KNIGHT).toString(), "♘");
        cliMap.put(new House(PlayerEnum.WHITE, PieceEnum.PAWN).toString(), "♙");
        cliMap.put(new House(PlayerEnum.WHITE, PieceEnum.QUEEN).toString(), "♕");
        cliMap.put(new House(PlayerEnum.WHITE, PieceEnum.ROOK).toString(), "♖");
    }

    public static String get(String key) {
        loadEntries();
        if (!cliMap.containsKey(key))
            return " ";
        return cliMap.get(key);
    }
}
