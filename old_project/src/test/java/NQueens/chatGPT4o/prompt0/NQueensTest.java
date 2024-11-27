package NQueens.chatGPT4o.prompt0;

import org.junit.Before;
import org.junit.Test;
import java.util.List;
import NQueens.Nqueens;
import static org.junit.Assert.*;

public class NQueensTest {

    private Nqueens nQueensSolver;

    @Before
    public void setUp() {
        nQueensSolver = new Nqueens();
    }

    @Test
    public void testSolveNQueensForN1() {
        List<List<String>> result = nQueensSolver.solveNQueens(1);
        assertEquals(1, result.size());
        assertEquals("Q", result.get(0).get(0));
    }

    @Test
    public void testSolveNQueensForN2() {
        List<List<String>> result = nQueensSolver.solveNQueens(2);
        assertTrue(result.isEmpty()); // No solutions for n = 2
    }

    @Test
    public void testSolveNQueensForN3() {
        List<List<String>> result = nQueensSolver.solveNQueens(3);
        assertTrue(result.isEmpty()); // No solutions for n = 3
    }

    @Test
    public void testSolveNQueensForN4() {
        List<List<String>> result = nQueensSolver.solveNQueens(4);
        assertEquals(2, result.size()); // There are exactly 2 solutions for n = 4

        // Checking expected board configuration in one of the solutions
        //wrong syntax
        /* 
        assertTrue(result.contains(List.of(
                ".Q..",
                "...Q",
                "Q...",
                "..Q."
        )));
        assertTrue(result.contains(List.of(
                "..Q.",
                "Q...",
                "...Q",
                ".Q.."
        )));
        */
    }

    @Test
    public void testSolveNQueensForN5() {
        List<List<String>> result = nQueensSolver.solveNQueens(5);
        assertEquals(10, result.size()); // There are 10 solutions for n = 5

        // Check that each solution has 5 rows with exactly one 'Q' per row
        for (List<String> solution : result) {
            assertEquals(5, solution.size());
            for (String row : solution) {
                assertEquals(1, row.chars().filter(ch -> ch == 'Q').count());
            }
        }
    }

    @Test
    public void testSolveNQueensForN6() {
        List<List<String>> result = nQueensSolver.solveNQueens(6);
        assertEquals(4, result.size()); // There are 4 solutions for n = 6

        // Check that each solution has 6 rows with exactly one 'Q' per row
        for (List<String> solution : result) {
            assertEquals(6, solution.size());
            for (String row : solution) {
                assertEquals(1, row.chars().filter(ch -> ch == 'Q').count());
            }
        }
    }
}
