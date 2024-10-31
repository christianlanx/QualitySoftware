package NQueens.chatGPTo1Preview.prompt0;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;
import NQueens.Nqueens;

public class NQueensTest {

    @Test
    public void testNEqualsZero() {
        Nqueens nqueens = new Nqueens();
        List<List<String>> solutions = nqueens.solveNQueens(0);
        assertEquals(0, solutions.size());
    }

    @Test
    public void testNEqualsOne() {
        Nqueens nqueens = new Nqueens();
        List<List<String>> solutions = nqueens.solveNQueens(1);
        List<List<String>> expected = Arrays.asList(
            Arrays.asList("Q")
        );
        assertEquals(1, solutions.size());
        assertTrue(solutions.containsAll(expected));
    }

    @Test
    public void testNEqualsTwo() {
        Nqueens nqueens = new Nqueens();
        List<List<String>> solutions = nqueens.solveNQueens(2);
        assertEquals(0, solutions.size());
    }

    @Test
    public void testNEqualsThree() {
        Nqueens nqueens = new Nqueens();
        List<List<String>> solutions = nqueens.solveNQueens(3);
        assertEquals(0, solutions.size());
    }

    @Test
    public void testNEqualsFour() {
        Nqueens nqueens = new Nqueens();
        List<List<String>> solutions = nqueens.solveNQueens(4);
        List<List<String>> expected = Arrays.asList(
            Arrays.asList(".Q..",  // Solution 1
                          "...Q",
                          "Q...",
                          "..Q."),
            Arrays.asList("..Q.",  // Solution 2
                          "Q...",
                          "...Q",
                          ".Q..")
        );
        assertEquals(2, solutions.size());
        assertTrue(containsAllSolutions(solutions, expected));
    }

    @Test
    public void testNEqualsFive() {
        Nqueens nqueens = new Nqueens();
        List<List<String>> solutions = nqueens.solveNQueens(5);
        // There are 10 solutions for n=5
        assertEquals(10, solutions.size());
        assertTrue(allSolutionsValid(solutions));
    }

    @Test
    public void testNEqualsEight() {
        Nqueens nqueens = new Nqueens();
        List<List<String>> solutions = nqueens.solveNQueens(8);
        // There are 92 solutions for n=8
        assertEquals(92, solutions.size());
        assertTrue(allSolutionsValid(solutions));
    }

    /**
     * Helper method to check if all solutions are valid.
     * It verifies that no two queens attack each other.
     *
     * @param solutions List of solutions to validate
     * @return true if all solutions are valid, false otherwise
     */
    private boolean allSolutionsValid(List<List<String>> solutions) {
        for (List<String> board : solutions) {
            if (!isValidSolution(board)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Helper method to validate a single N-Queens solution.
     *
     * @param board A single solution represented as a list of strings
     * @return true if the solution is valid, false otherwise
     */
    private boolean isValidSolution(List<String> board) {
        int n = board.size();
        int[] queens = new int[n]; // queens[row] = col

        for (int i = 0; i < n; i++) {
            String row = board.get(i);
            int col = row.indexOf('Q');
            if (col == -1) {
                return false; // No queen found in this row
            }
            queens[i] = col;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (queens[i] == queens[j]) {
                    return false; // Same column
                }
                if (Math.abs(queens[i] - queens[j]) == j - i) {
                    return false; // Same diagonal
                }
            }
        }
        return true;
    }

    /**
     * Helper method to check if the actual solutions contain all the expected solutions.
     *
     * @param actual   The actual solutions returned by the solveNQueens method
     * @param expected The expected solutions
     * @return true if all expected solutions are present in actual solutions
     */
    private boolean containsAllSolutions(List<List<String>> actual, List<List<String>> expected) {
        for (List<String> expSol : expected) {
            boolean found = false;
            for (List<String> actSol : actual) {
                if (areBoardsEqual(actSol, expSol)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return false; // Expected solution not found in actual solutions
            }
        }
        return true;
    }

    /**
     * Helper method to compare two boards for equality.
     *
     * @param board1 The first board
     * @param board2 The second board
     * @return true if boards are equal, false otherwise
     */
    private boolean areBoardsEqual(List<String> board1, List<String> board2) {
        if (board1.size() != board2.size()) {
            return false;
        }
        for (int i = 0; i < board1.size(); i++) {
            if (!board1.get(i).equals(board2.get(i))) {
                return false;
            }
        }
        return true;
    }
}
