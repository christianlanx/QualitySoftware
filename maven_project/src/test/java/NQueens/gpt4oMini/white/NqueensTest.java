package NQueens.gpt4oMini.white;

import NQueens.Nqueens;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class NqueensTest {

    private final Nqueens nqueens = new Nqueens();

    @Test
    public void testSolveNQueens_1() {
        List<List<String>> result = nqueens.solveNQueens(1);
        assertEquals(1, result.size());
        assertEquals(List.of("Q"), result.get(0));
    }

    @Test
    public void testSolveNQueens_2() {
        List<List<String>> result = nqueens.solveNQueens(2);
        assertEquals(0, result.size());
    }

    @Test
    public void testSolveNQueens_3() {
        List<List<String>> result = nqueens.solveNQueens(3);
        assertEquals(0, result.size());
    }

    @Test
    public void testSolveNQueens_4() {
        List<List<String>> result = nqueens.solveNQueens(4);
        assertEquals(2, result.size());
        assertTrue(result.contains(List.of("Q...", "...Q", ".Q..", "..Q.")));
        assertTrue(result.contains(List.of(".Q..", "...Q", "Q...", "..Q.")));
    }

    @Test
    public void testSolveNQueens_5() {
        List<List<String>> result = nqueens.solveNQueens(5);
        assertEquals(10, result.size());
    }

    @Test
    public void testSolveNQueens_6() {
        List<List<String>> result = nqueens.solveNQueens(6);
        assertEquals(4, result.size());  // This is an assumed expected value; it may need adjustments.
    }

    @Test
    public void testSolveNQueens_Negative() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            nqueens.solveNQueens(-1);
        });
        assertEquals("N must be non-negative", exception.getMessage());
    }

    @Test
    public void testSolveNQueens_Integration() {
        List<List<String>> result = nqueens.solveNQueens(8);
        assertFalse(result.isEmpty());
        // Optionally check the structure of the solution for validity here
    }
}