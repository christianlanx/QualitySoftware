package NQueens.gpt35Turbo.black;
import NQueens.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NQueensTest {

    private Nqueens nQueens;

    @BeforeEach
    public void setup() {
        nQueens = new Nqueens();
    }

    @Test
    public void testNQueens_Example1() {
        int n = 4;
        List<List<String>> expected = Arrays.asList(
                Arrays.asList(".Q..", "...Q", "Q...", "..Q."),
                Arrays.asList("..Q.", "Q...", "...Q", ".Q..")
        );
        List<List<String>> result = nQueens.solveNQueens(n);
        assertTrue(result.containsAll(expected));
        assertTrue(expected.containsAll(result));
    }

    @Test
    public void testNQueens_Example2() {
        int n = 1;
        List<List<String>> expected = Arrays.asList(Arrays.asList("Q"));
        List<List<String>> result = nQueens.solveNQueens(n);
        assertEquals(expected, result);
    }

    @Test
    public void testNQueens_Constraint1() {
        int n = 9;
        List<List<String>> result = nQueens.solveNQueens(n);
        // Additional assertions for constraint testing
    }
}