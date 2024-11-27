package NQueens.metaAI.white;
import NQueens.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.ArrayList;

public class NqueensTest {

    private Nqueens nqueens = new Nqueens();

    @Test
    public void testSolveNQueens_Example1() {
        int n = 4;
        List<List<String>> expected = List.of(
            List.of(".Q..", "...Q", "Q...", "..Q."),
            List.of("..Q.", "Q...", "...Q", ".Q..")
        );
        List<List<String>> actual = nqueens.solveNQueens(n);
        assertTrue(expected.containsAll(actual) && actual.containsAll(expected));
    }

    @Test
    public void testSolveNQueens_Example2() {
        int n = 1;
        List<List<String>> expected = List.of(List.of("Q"));
        List<List<String>> actual = nqueens.solveNQueens(n);
        assertTrue(expected.containsAll(actual) && actual.containsAll(expected));
    }

    @Test
    public void testSolveNQueens_NEquals2() {
        int n = 2;
        List<List<String>> expected = List.of();
        List<List<String>> actual = nqueens.solveNQueens(n);
        assertTrue(expected.containsAll(actual) && actual.containsAll(expected));
    }

    @Test
    public void testSolveNQueens_NEquals3() {
        int n = 3;
        List<List<String>> expected = List.of();
        List<List<String>> actual = nqueens.solveNQueens(n);
        assertTrue(expected.containsAll(actual) && actual.containsAll(expected));
    }

    @Test
    public void testSolveNQueens_NEquals9() {
        int n = 9;
        List<List<String>> actual = nqueens.solveNQueens(n);
        assertNotNull(actual);
        assertFalse(actual.isEmpty());
    }

    @Test
    public void testPutBoard() {
        int[][] board = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        List<List<String>> ret = new ArrayList<>();
        nqueens.putBoard(board, ret);
        assertEquals(1, ret.size());
        assertEquals(3, ret.get(0).size());
        assertEquals("Q..", ret.get(0).get(0));
        assertEquals(".Q.", ret.get(0).get(1));
        assertEquals("..Q", ret.get(0).get(2));
    }

    @Test
    public void testValidBoard_Valid() {
        int[][] board = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        boolean actual = nqueens.validBoard(board, 2, 2);
        assertTrue(actual);
    }

    @Test
    public void testValidBoard_Invalid() {
        int[][] board = {{1, 0, 0}, {0, 1, 1}, {0, 0, 1}};
        boolean actual = nqueens.validBoard(board, 2, 2);
        assertFalse(actual);
    }
}