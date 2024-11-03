package NQueens.copilot.prompt1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import NQueens.Nqueens;

import java.util.*;

public class NQueenscopilotTest {

    @Test
    public void testSolveNQueens_Example1() {
        Nqueens solution = new Nqueens();
        int n = 4;
        List<List<String>> expected = Arrays.asList(
                Arrays.asList(".Q..","...Q","Q...","..Q."),
                Arrays.asList("..Q.","Q...","...Q",".Q..")
        );
        List<List<String>> result = solution.solveNQueens(n);
        assertEquals(expected.size(), result.size());
        for (List<String> solutionResult : result) {
            assertTrue(expected.contains(solutionResult));
        }
    }

    @Test
    public void testSolveNQueens_Example2() {
        Nqueens solution = new Nqueens();
        int n = 1;
        List<List<String>> expected = Arrays.asList(
                Arrays.asList("Q")
        );
        List<List<String>> result = solution.solveNQueens(n);
        assertEquals(expected.size(), result.size());
        for (List<String> solutionResult : result) {
            assertTrue(expected.contains(solutionResult));
        }
    }

    // Add more test cases to cover edge cases and larger boards
    @Test
    public void testSolveNQueens_LargerBoard() {
        Nqueens solution = new Nqueens();
        int n = 8;
        List<List<String>> result = solution.solveNQueens(n);
        // Just checking if we get results for now, actual correctness would need manual verification or detailed checks
        assertTrue(result.size() > 0);
    }
}
