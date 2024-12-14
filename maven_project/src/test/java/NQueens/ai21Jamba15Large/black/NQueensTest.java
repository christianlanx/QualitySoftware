package NQueens.ai21Jamba15Large.black;

import NQueens.Nqueens;
import java.util.List;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NQueensTest {

    @Test
    void testSolveNQueens_1() {
        Nqueens nqueens = new Nqueens();
        int n = 1;
        List<List<String>> expected = new ArrayList<>();
        List<String> board = new ArrayList<>();
        board.add("Q");
        expected.add(board);
        assertEquals(expected, nqueens.solveNQueens(n));
    }

    @Test
    void testSolveNQueens_4() {
        Nqueens nqueens = new Nqueens();
        int n = 4;
        List<List<String>> expected = new ArrayList<>();

        // Solution 1
        List<String> board1 = new ArrayList<>();
        board1.add(".Q..");
        board1.add("...Q");
        board1.add("Q...");
        board1.add("..Q.");
        expected.add(board1);

        // Solution 2
        List<String> board2 = new ArrayList<>();
        board2.add("..Q.");
        board2.add("Q...");
        board2.add("...Q");
        board2.add(".Q..");
        expected.add(board2);

        assertEquals(expected, nqueens.solveNQueens(n));
    }

    @Test
    void testSolveNQueens_9() {
        Nqueens nqueens = new Nqueens();
        int n = 9;
        List<List<String>> expected = nqueens.solveNQueens(n);
        assertFalse(expected.isEmpty());
        assertTrue(expected.size() > 0);
    }

    @Test
    void testSolveNQueens_invalidInput() {
        Nqueens nqueens = new Nqueens();
        int n = 0;
        assertThrows(IllegalArgumentException.class, () -> nqueens.solveNQueens(n));
    }
}