package NQueens.claudeSonnet.prompt1;

import org.junit.Test;

import NQueens.Nqueens;

import org.junit.Before;
import static org.junit.Assert.*;
import java.util.*;

public class NQueensclaudeSonnetTest {
    private Nqueens solution;

    @Before
    public void setUp() {
        solution = new Nqueens();
    }

    @Test
    public void testNQueensWithN1() {
        List<List<String>> result = solution.solveNQueens(1);
        assertEquals(1, result.size());
        assertEquals(Collections.singletonList("Q"), result.get(0));
    }

    @Test
    public void testNQueensWithN4() {
        List<List<String>> result = solution.solveNQueens(4);
        assertEquals(2, result.size());
        
        // Expected solutions for n=4
        List<List<String>> expected = Arrays.asList(
            Arrays.asList(".Q..", "...Q", "Q...", "..Q."),
            Arrays.asList("..Q.", "Q...", "...Q", ".Q..")
        );
        
        // Sort both lists to ensure consistent comparison
        result = new ArrayList<>(result);
        expected = new ArrayList<>(expected);
        
        result.sort(this::compareNqueenss);
        expected.sort(this::compareNqueenss);
        
        assertEquals(expected, result);
    }

    @Test
    public void testNQueensWithN8() {
        List<List<String>> result = solution.solveNQueens(8);
        assertEquals(92, result.size()); // 8-queens has 92 distinct solutions
        validateNqueenss(result, 8);
    }

    @Test
    public void testEmptyResultForN2() {
        List<List<String>> result = solution.solveNQueens(2);
        assertTrue(result.isEmpty()); // No solution exists for n=2
    }

    @Test
    public void testEmptyResultForN3() {
        List<List<String>> result = solution.solveNQueens(3);
        assertTrue(result.isEmpty()); // No solution exists for n=3
    }

    @Test
    public void testValidBoardSize() {
        for (int n = 1; n <= 9; n++) {
            List<List<String>> result = solution.solveNQueens(n);
            for (List<String> board : result) {
                assertEquals(n, board.size()); // Check number of rows
                for (String row : board) {
                    assertEquals(n, row.length()); // Check number of columns
                }
            }
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidInputZero() {
        solution.solveNQueens(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidInputNegative() {
        solution.solveNQueens(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidInputTooLarge() {
        solution.solveNQueens(10);
    }

    // Helper method to validate that solutions are valid n-queens configurations
    private void validateNqueenss(List<List<String>> solutions, int n) {
        for (List<String> board : solutions) {
            assertTrue(isValidNqueens(board, n));
        }
    }

    // Helper method to check if a solution is valid
    private boolean isValidNqueens(List<String> board, int n) {
        // Check board size
        if (board.size() != n) return false;
        for (String row : board) {
            if (row.length() != n) return false;
        }

        // Convert board to queen positions
        int[] queens = new int[n];
        for (int i = 0; i < n; i++) {
            String row = board.get(i);
            int queenPos = row.indexOf('Q');
            if (queenPos == -1) return false;
            queens[i] = queenPos;
        }

        // Check for conflicts
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // Check same column
                if (queens[i] == queens[j]) return false;
                
                // Check diagonals
                if (Math.abs(queens[i] - queens[j]) == Math.abs(i - j)) return false;
            }
        }
        return true;
    }

    // Helper method to compare two solutions for consistent ordering
    private int compareNqueenss(List<String> solution1, List<String> solution2) {
        for (int i = 0; i < solution1.size(); i++) {
            int comparison = solution1.get(i).compareTo(solution2.get(i));
            if (comparison != 0) return comparison;
        }
        return 0;
    }
}