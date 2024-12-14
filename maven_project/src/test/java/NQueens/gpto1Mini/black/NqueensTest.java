package NQueens.gpto1Mini.black;

import NQueens.Nqueens;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
        List<List<String>> actual = nqueens.solveNQueens(n);
        assertEquals(expected, actual, "Failed for n=1");
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
        List<List<String>> actual = nqueens.solveNQueens(n);
        assertEquals(expected.size(), actual.size(), "Number of solutions mismatch for n=4");
        for (List<String> solution : expected) {
            assertEquals(true, actual.contains(solution), "Expected solution not found for n=4");
        }
    }

    @Test
    @DisplayName("Test solveNQueens with n=5")
    public void testSolveNQueens_n5() {
        int n = 5;
        List<List<String>> actual = nqueens.solveNQueens(n);
        assertEquals(10, actual.size(), "Number of solutions mismatch for n=5");
    }

    @Test
    @DisplayName("Test solveNQueens with n=9")
    public void testSolveNQueens_n9() {
        int n = 9;
        List<List<String>> actual = nqueens.solveNQueens(n);
        // The number of solutions for n=9 is known to be 352
        assertEquals(352, actual.size(), "Number of solutions mismatch for n=9");
    }

    @Test
    @DisplayName("Test solveNQueens with minimum n")
    public void testSolveNQueens_minN() {
        int n = 1;
        List<List<String>> actual = nqueens.solveNQueens(n);
        assertEquals(1, actual.size(), "Number of solutions mismatch for minimum n=1");
    }

    @Test
    @DisplayName("Test solveNQueens with maximum n")
    public void testSolveNQueens_maxN() {
        int n = 9;
        List<List<String>> actual = nqueens.solveNQueens(n);
        assertEquals(352, actual.size(), "Number of solutions mismatch for maximum n=9");
    }
}