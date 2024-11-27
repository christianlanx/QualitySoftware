package NQueens.metaAI.prompt1;
import NQueens.Nqueens;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

public class NqueensTest {

    Nqueens nqueens = new Nqueens();

    @Test
    public void testNQueens_Example1() {
        int n = 4;
        List<List<String>> expected = List.of(
            List.of(".Q..", "...Q", "Q...", "..Q."),
            List.of("..Q.", "Q...", "...Q", ".Q..")
        );
        List<List<String>> actual = nqueens.solveNQueens(n);
        assertEquals(expected, actual);
    }

    @Test
    public void testNQueens_Example2() {
        int n = 1;
        List<List<String>> expected = List.of(List.of("Q"));
        List<List<String>> actual = nqueens.solveNQueens(n);
        assertEquals(expected, actual);
    }

    @Test
    public void testNQueens_Constraints_LowerBound() {
        int n = 1;
        List<List<String>> actual = nqueens.solveNQueens(n);
        assertNotNull(actual);
    }

    @Test
    public void testNQueens_Constraints_UpperBound() {
        int n = 9;
        List<List<String>> actual = nqueens.solveNQueens(n);
        assertNotNull(actual);
    }

    @Test
    public void testNQueens_EmptyBoard() {
        int n = 0;
        List<List<String>> actual = nqueens.solveNQueens(n);
        assertTrue(actual.isEmpty());
    }

    @Test
    public void testNQueens_Null() {
        int n = -1;
        List<List<String>> actual = nqueens.solveNQueens(n);
        assertTrue(actual.isEmpty());
    }
}