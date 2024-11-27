package NQueens.metaAI.prompt0;
import NQueens.Nqueens;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.List;

public class NqueensTest {

    Nqueens nqueens = new Nqueens();

    // Test small boards
    @Test
    public void testSmallBoards() {
        assertEquals(2, nqueens.solveNQueens(4).size());
        assertEquals(92, nqueens.solveNQueens(8).size());
    }

    // Test larger boards
    @Test
    public void testLargerBoards() {
        assertEquals(352, nqueens.solveNQueens(10).size());
        assertEquals(724, nqueens.solveNQueens(11).size());
        assertEquals(2680, nqueens.solveNQueens(12).size());
    }

    // Test edge cases
    @Test
    public void testEdgeCases() {
        assertTrue(nqueens.solveNQueens(1).size() == 1);
        assertTrue(nqueens.solveNQueens(2).size() == 0);
        assertTrue(nqueens.solveNQueens(3).size() == 0);
    }

    // Test solution validity
    @Test
    public void testSolutionValidity() {
        List<List<String>> solutions = nqueens.solveNQueens(4);
        for (List<String> solution : solutions) {
            for (String row : solution) {
                assertTrue(row.matches("^[.Q]+$"));
                assertEquals(4, row.length());
            }
            assertEquals(4, solution.size());
        }
    }

    // Test extreme cases
    @Test
    public void testExtremeCases() {
        assertTrue(nqueens.solveNQueens(0).size() == 1); // Empty board
        assertTrue(nqueens.solveNQueens(-1).size() == 0); // Invalid input
    }
}