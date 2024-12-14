package NQueens.gpt4o.black;

import NQueens.Nqueens;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.Arrays;

public class NqueensTest {

    @Test
    public void testSolveNQueens_forNEquals1() {
        Nqueens nqueens = new Nqueens();
        List<List<String>> result = nqueens.solveNQueens(1);

        List<List<String>> expected = Arrays.asList(
            Arrays.asList("Q")
        );

        assertEquals(expected, result, "Failed test case for n=1");
    }

    @Test
    public void testSolveNQueens_forNEquals4() {
        Nqueens nqueens = new Nqueens();
        List<List<String>> result = nqueens.solveNQueens(4);

        List<List<String>> expected = Arrays.asList(
            Arrays.asList(".Q..", "...Q", "Q...", "..Q."),
            Arrays.asList("..Q.", "Q...", "...Q", ".Q..")
        );

        assertTrue(result.containsAll(expected) && expected.containsAll(result), 
            "Failed test case for n=4. Missing expected solutions or contains extra solutions.");
    }

    @Test
    public void testSolveNQueens_forNEquals5() {
        Nqueens nqueens = new Nqueens();
        List<List<String>> result = nqueens.solveNQueens(5);

        // Asserting on specific solutions for n=5 can be complex due to the number of solutions.
        // Hence, here we just check the count. There are 10 solutions for n=5.
        assertEquals(10, result.size(), "Failed test case for n=5. Incorrect number of solutions.");
    }

    @Test
    public void testSolveNQueens_forNEquals8() {
        Nqueens nqueens = new Nqueens();
        List<List<String>> result = nqueens.solveNQueens(8);

        // There are 92 solutions for n=8.
        assertEquals(92, result.size(), "Failed test case for n=8. Incorrect number of solutions.");
    }

    @Test
    public void testSolveNQueens_forNEquals9() {
        Nqueens nqueens = new Nqueens();
        List<List<String>> result = nqueens.solveNQueens(9);

        // There are 352 solutions for n=9.
        assertEquals(352, result.size(), "Failed test case for n=9. Incorrect number of solutions.");
    }
}