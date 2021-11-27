package Board;

import junit.framework.*;

public class BoardTest extends TestCase {
    public BoardTest() {
        assert new BoardModel().toString() == "[[BR, BN, BB, BK, BQ, BB, BN, BR], "
                + "[BP, BP, BP, BP, BP, BP, BP, BP], " + "[  ,   ,   ,   ,   ,   ,   ,   ], "
                + "[  ,   ,   ,   ,   ,   ,   ,   ], " + "[  ,   ,   ,   ,   ,   ,   ,   ], "
                + "[  ,   ,   ,   ,   ,   ,   ,   ], " + "[WP, WP, WP, WP, WP, WP, WP, WP], "
                + "[WR, WN, WB, WK, WQ, WB, WN, WR]]";
    }
}
