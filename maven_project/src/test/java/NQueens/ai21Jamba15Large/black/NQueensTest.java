package NQueens.ai21Jamba15Large.black;
import NQueens.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class NQueensTest {

    private Nqueens nqueens = new Nqueens();

    @Test
    void testSolveNQueens_n1() {
        List<List<String>> expected = List.of(List.of(".Q..", "...Q", "Q...", "..Q."));
        assertEquals(expected, nqueens.solveNQueens(4));
    }

    @Test
    void testSolveNQueens_n2() {
        List<List<String>> expected = List.of(List.of("..Q.", "Q...", "...Q", ".Q.."));
        assertEquals(expected, nqueens.solveNQueens(4));
    }

    @Test
    void testSolveNQueens_n3() {
        List<List<String>> expected = List.of(List.of("Q"));
        assertEquals(expected, nqueens.solveNQueens(1));
    }

    @ParameterizedTest
    @CsvSource({
        "2, 0",
        "3, 0",
        "4, 2",
        "5, 10",
        "6, 4",
        "7, 40",
        "8, 92",
        "9, 352"
    })
    void testSolveNQueens_counts(int n, int expectedCount) {
        List<List<String>> solutions = nqueens.solveNQueens(n);
        assertEquals(expectedCount, solutions.size());
    }

    @Test
    void testSolveNQueens_invalidInput() {
        List<List<String>> solutions = nqueens.solveNQueens(0);
        assertTrue(solutions.isEmpty());
    }

    @Test
    void testSolveNQueens_largeInput() {
        List<List<String>> solutions = nqueens.solveNQueens(9);
        assertEquals(352, solutions.size());
    }
}