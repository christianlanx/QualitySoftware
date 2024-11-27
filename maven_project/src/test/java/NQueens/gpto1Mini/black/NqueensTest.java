package NQueens.gpto1Mini.black;
import NQueens.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

public class NqueensTest {

    private Nqueens nqueens;

    @BeforeEach
    public void setUp() {
        nqueens = new Nqueens();
    }

    @Test
    @DisplayName("Test solveNQueens with n=1")
    public void testSolveNQueens_n1() {
        int n = 1;
        List<List<String>> expected = Arrays.asList(
            Arrays.asList("Q")
        );
        List<List<String>> result = nqueens.solveNQueens(n);
        assertEquals(expected, result, "n=1 should return one solution with a single queen.");
    }

    @Test
    @DisplayName("Test solveNQueens with n=2 (no solutions)")
    public void testSolveNQueens_n2() {
        int n = 2;
        List<List<String>> expected = Collections.emptyList();
        List<List<String>> result = nqueens.solveNQueens(n);
        assertEquals(expected, result, "n=2 should return no solutions.");
    }

    @Test
    @DisplayName("Test solveNQueens with n=3 (no solutions)")
    public void testSolveNQueens_n3() {
        int n = 3;
        List<List<String>> expected = Collections.emptyList();
        List<List<String>> result = nqueens.solveNQueens(n);
        assertEquals(expected, result, "n=3 should return no solutions.");
    }

    @Test
    @DisplayName("Test solveNQueens with n=4")
    public void testSolveNQueens_n4() {
        int n = 4;
        List<List<String>> expected = Arrays.asList(
            Arrays.asList(".Q..",
                          "...Q",
                          "Q...",
                          "..Q."),
            Arrays.asList("..Q.",
                          "Q...",
                          "...Q",
                          ".Q..")
        );
        List<List<String>> result = nqueens.solveNQueens(n);
        assertEquals(expected.size(), result.size(), "n=4 should have two distinct solutions.");
        for (List<String> solution : expected) {
            assertTrue(containsSolution(result, solution), "Result should contain all expected solutions for n=4.");
        }
    }

    @Test
    @DisplayName("Test solveNQueens with n=5")
    public void testSolveNQueens_n5() {
        int n = 5;
        List<List<String>> result = nqueens.solveNQueens(n);
        int expectedCount = 10;
        assertEquals(expectedCount, result.size(), "n=5 should have ten distinct solutions.");
        for (List<String> solution : result) {
            assertTrue(isValidSolution(solution, n), "Each solution for n=5 should be valid.");
        }
    }

    @Test
    @DisplayName("Test solveNQueens with n=8")
    public void testSolveNQueens_n8() {
        int n = 8;
        List<List<String>> result = nqueens.solveNQueens(n);
        int expectedCount = 92;
        assertEquals(expectedCount, result.size(), "n=8 should have ninety-two distinct solutions.");
    }

    @Test
    @DisplayName("Test solveNQueens with n=9")
    public void testSolveNQueens_n9() {
        int n = 9;
        List<List<String>> result = nqueens.solveNQueens(n);
        int expectedCount = 352;
        assertEquals(expectedCount, result.size(), "n=9 should have three hundred fifty-two distinct solutions.");
    }

    /**
     * Helper method to check if the result contains a specific solution.
     * Since the order of solutions does not matter, we check for equality of any solution.
     */
    private boolean containsSolution(List<List<String>> result, List<String> target) {
        for (List<String> solution : result) {
            if (solution.equals(target)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Helper method to validate a single solution.
     * Ensures that no two queens attack each other.
     */
    private boolean isValidSolution(List<String> board, int n) {
        int[] queens = new int[n];
        for (int row = 0; row < n; row++) {
            String rowStr = board.get(row);
            int col = rowStr.indexOf('Q');
            if (col == -1 || rowStr.lastIndexOf('Q') != col) {
                return false; // Must have exactly one queen per row
            }
            queens[row] = col;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (queens[i] == queens[j] ||
                    Math.abs(queens[i] - queens[j]) == Math.abs(i - j)) {
                    return false; // Queens attack each other
                }
            }
        }
        return true;
    }
}