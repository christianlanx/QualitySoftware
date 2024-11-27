package NQueens.gpt4oMini.black;
import NQueens.*;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NqueensTest {

    private final Nqueens nqueens = new Nqueens();

    @Test
    public void testSolveNQueensWith4() {
        int n = 4;
        List<List<String>> expected = List.of(
            List.of(".Q..", "...Q", "Q...", "..Q."),
            List.of("..Q.", "Q...", "...Q", ".Q..")
        );

        List<List<String>> actual = nqueens.solveNQueens(n);
        
        assertEquals(expected.size(), actual.size(), "The number of solutions should match.");
        for (List<String> solution : expected) {
            assertEquals(true, actual.contains(solution), "Expected solution not found: " + solution);
        }
    }

    @Test
    public void testSolveNQueensWith1() {
        int n = 1;
        List<List<String>> expected = List.of(
            List.of("Q")
        );

        List<List<String>> actual = nqueens.solveNQueens(n);

        assertEquals(expected, actual, "The solutions for n=1 should match.");
    }

    @Test
    public void testSolveNQueensWith2() {
        int n = 2;
        List<List<String>> expected = List.of(); // No solutions for n=2

        List<List<String>> actual = nqueens.solveNQueens(n);

        assertEquals(expected, actual, "There should be no solutions for n=2.");
    }

    @Test
    public void testSolveNQueensWith3() {
        int n = 3;
        List<List<String>> expected = List.of(); // No solutions for n=3

        List<List<String>> actual = nqueens.solveNQueens(n);

        assertEquals(expected, actual, "There should be no solutions for n=3.");
    }

    @Test
    public void testSolveNQueensWith5() {
        int n = 5;
        List<List<String>> expected = List.of(
            List.of("Q....", "...Q.", ".Q...", "....Q", "..Q.."),
            List.of("Q...", "..Q.", "....Q", ".Q..", "...Q"),
            // Add additional expected solutions as necessary
            List.of(".Q...", "Q...", "....Q", "...Q", "..Q."),
            List.of("..Q..", "Q...", "...Q", "....Q", ".Q..")
        );

        List<List<String>> actual = nqueens.solveNQueens(n);
        
        assertEquals(expected.size(), actual.size(), "The number of solutions should match.");
        for (List<String> solution : expected) {
            assertEquals(true, actual.contains(solution), "Expected solution not found: " + solution);
        }
    }

    // Additional tests for other values of n can be added as needed.
}