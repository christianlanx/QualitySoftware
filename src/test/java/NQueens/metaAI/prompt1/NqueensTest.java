package NQueens.metaAI.prompt1;
import NQueens.Nqueens;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class NqueensTest {

    Nqueens nqueens = new Nqueens();

    @Test
    public void testExample1() {
        int n = 4;
        List<List<String>> expected = Arrays.asList(
                Arrays.asList(".Q..", "...Q", "Q...", "..Q."),
                Arrays.asList("..Q.", "Q...", "...Q", ".Q..")
        );
        assertEquals(expected, nqueens.solveNQueens(n));
    }

    @Test
    public void testExample2() {
        int n = 1;
        List<List<String>> expected = Arrays.asList(Arrays.asList("Q"));
        assertEquals(expected, nqueens.solveNQueens(n));
    }

    @Test
    public void testSmallBoard() {
        int n = 2;
        List<List<String>> expected = new ArrayList<>();
        assertEquals(expected, nqueens.solveNQueens(n));
    }

    @Test
    public void testLargeBoard() {
        int n = 8;
        List<List<String>> expected = nqueens.solveNQueens(n);
        assertTrue(expected.size() > 0);
    }

    private void assertEquals(List<List<String>> expected, List<List<String>> actual) {
        assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), actual.get(i));
        }
    }
}