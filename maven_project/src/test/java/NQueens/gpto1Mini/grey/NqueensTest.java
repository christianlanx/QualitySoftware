package NQueens.gpto1Mini.grey;

import NQueens.Nqueens;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import java.util.List;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

public class NqueensTest {

    @Test
    @DisplayName("Test solveNQueens with n = 1")
    void testSolveNQueens1() {
        Nqueens solver = new Nqueens();
        List<List<String>> expected = Arrays.asList(
            Arrays.asList("Q")
        );
        List<List<String>> result = solver.solveNQueens(1);
        assertEquals(expected, result, "Failed for n = 1");
    }

    @Test
    @DisplayName("Test solveNQueens with n = 4")
    void testSolveNQueens4() {
        Nqueens solver = new Nqueens();
        List<List<String>> expected = Arrays.asList(
            Arrays.asList(".Q..", "...Q", "Q...", "..Q."),
            Arrays.asList("..Q.", "Q...", "...Q", ".Q..")
        );
        List<List<String>> result = solver.solveNQueens(4);
        assertEquals(expected.size(), result.size(), "Number of solutions should be 2 for n = 4");
        assertTrue(result.containsAll(expected) && expected.containsAll(result), "Solutions do not match for n = 4");
    }

    @Test
    @DisplayName("Test solveNQueens with n = 2 (No solution)")
    void testSolveNQueens2() {
        Nqueens solver = new Nqueens();
        List<List<String>> expected = List.of();
        List<List<String>> result = solver.solveNQueens(2);
        assertEquals(expected, result, "There should be no solutions for n = 2");
    }

    @Test
    @DisplayName("Test solveNQueens with n = 3 (No solution)")
    void testSolveNQueens3() {
        Nqueens solver = new Nqueens();
        List<List<String>> expected = List.of();
        List<List<String>> result = solver.solveNQueens(3);
        assertEquals(expected, result, "There should be no solutions for n = 3");
    }

    @Test
    @DisplayName("Test solveNQueens with n = 5")
    void testSolveNQueens5() {
        Nqueens solver = new Nqueens();
        List<List<String>> result = solver.solveNQueens(5);
        assertEquals(10, result.size(), "There should be 10 solutions for n = 5");
    }

    @Test
    @DisplayName("Test solveNQueens with n = 9")
    void testSolveNQueens9() {
        Nqueens solver = new Nqueens();
        List<List<String>> result = solver.solveNQueens(9);
        assertEquals(352, result.size(), "There should be 352 solutions for n = 9");
    }

    @Test
    @DisplayName("Test solveNQueens with n = 0 (Edge case)")
    void testSolveNQueens0() {
        Nqueens solver = new Nqueens();
        List<List<String>> expected = List.of();
        List<List<String>> result = solver.solveNQueens(0);
        assertEquals(expected, result, "There should be no solutions for n = 0");
    }

    @Test
    @DisplayName("Test solveNQueens with negative n (Edge case)")
    void testSolveNQueensNegative() {
        Nqueens solver = new Nqueens();
        Exception exception = assertThrows(NegativeArraySizeException.class, () -> {
            solver.solveNQueens(-1);
        });
        // Depending on implementation, this could throw different exceptions
    }
}