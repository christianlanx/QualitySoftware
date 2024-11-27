package NQueens.metaAI.black;
import NQueens.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

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
}