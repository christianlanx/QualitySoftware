package NQueens.ai21Jamba15Large.white;
import NQueens.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class NqueensTest {

    @Test
    void testSolveNQueens_4() {
        Nqueens nqueens = new Nqueens();
        List<List<String>> expected = Arrays.asList(
            Arrays.asList(".Q..", "...Q", "Q...", "..Q."),
            Arrays.asList("..Q.", "Q...", "...Q", ".Q..")
        );
        assertEquals(expected, nqueens.solveNQueens(4));
    }

    @Test
    void testSolveNQueens_1() {
        Nqueens nqueens = new Nqueens();
        List<List<String>> expected = Arrays.asList(
            Arrays.asList("Q")
        );
        assertEquals(expected, nqueens.solveNQueens(1));
    }

    @Test
    void testSolveNQueens_0() {
        Nqueens nqueens = new Nqueens();
        List<List<String>> expected = Arrays.asList();
        assertEquals(expected, nqueens.solveNQueens(0));
    }

    @Test
    void testSolveNQueens_2() {
        Nqueens nqueens = new Nqueens();
        List<List<String>> expected = Arrays.asList();
        assertEquals(expected, nqueens.solveNQueens(2));
    }

    @Test
    void testSolveNQueens_8() {
        Nqueens nqueens = new Nqueens();
        List<List<String>> result = nqueens.solveNQueens(8);
        assertTrue(result.size() > 0);
        for (List<String> board : result) {
            assertTrue(board.size() == 8);
            for (String row : board) {
                assertTrue(row.length() == 8);
            }
        }
    }
}