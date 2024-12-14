package NQueens.gpt35Turbo.grey;

import org.junit.jupiter.api.Test;

import NQueens.Nqueens;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueensTest {

    @Test
    void testSolveNQueens_Example1() {
        Nqueens nqueens = new Nqueens();
        int n = 4;
        List<List<String>> expected = new ArrayList<>();
        expected.add(Arrays.asList(".Q..","...Q","Q...","..Q."));
        expected.add(Arrays.asList("..Q.","Q...","...Q",".Q.."));

        List<List<String>> actual = nqueens.solveNQueens(n);

        assertEquals(expected, actual);
    }

    @Test
    void testSolveNQueens_Example2() {
        Nqueens nqueens = new Nqueens();
        int n = 1;
        List<List<String>> expected = new ArrayList<>();
        expected.add(Arrays.asList("Q"));

        List<List<String>> actual = nqueens.solveNQueens(n);

        assertEquals(expected, actual);
    }

    @Test
    void testSolveNQueens_Constraint_1() {
        Nqueens nqueens = new Nqueens();
        int n = 9;

        List<List<String>> actual = nqueens.solveNQueens(n);

        // Assert some properties of the actual result for the constraint
        // Might not be an exact comparison due to constraint size
    }

    @Test
    void testSolveNQueens_CustomTest() {
        Nqueens nqueens = new Nqueens();
        int n = 2; // Add your custom input

        List<List<String>> actual = nqueens.solveNQueens(n);

        // Assert the expected output for your custom test
    }
}