package NQueens.ai21Jamba.prompt0;
import NQueens.Nqueens;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class NqueensTest {

    @Test
    public void testSolveNQueens() {
        Nqueens nqueens = new Nqueens();

        // Test case 1: n = 1
        List<List<String>> result1 = nqueens.solveNQueens(1);
        assertEquals(1, result1.size());
        assertEquals(1, result1.get(0).size());
        assertEquals("Q", result1.get(0).get(0));

        // Test case 2: n = 2 (no solution)
        List<List<String>> result2 = nqueens.solveNQueens(2);
        assertEquals(0, result2.size());

        // Test case 3: n = 3 (no solution)
        List<List<String>> result3 = nqueens.solveNQueens(3);
        assertEquals(0, result3.size());

        // Test case 4: n = 4
        List<List<String>> result4 = nqueens.solveNQueens(4);
        assertEquals(2, result4.size());
        assertEquals(4, result4.get(0).size());
        assertEquals(4, result4.get(1).size());
        assertEquals(".Q..", result4.get(0).get(0));
        assertEquals("..Q.", result4.get(0).get(1));
        assertEquals("Q...", result4.get(0).get(2));
        assertEquals("..Q.", result4.get(0).get(3));
        assertEquals("..Q.", result4.get(1).get(0));
        assertEquals("Q...", result4.get(1).get(1));
        assertEquals(".Q..", result4.get(1).get(2));
        assertEquals("...", result4.get(1).get(3));

        // Test case 5: n = 5
        List<List<String>> result5 = nqueens.solveNQueens(5);
        assertEquals(10, result5.size());
        assertEquals(5, result5.get(0).size());
        assertEquals("Q....", result5.get(0).get(0));
        assertEquals(".Q...", result5.get(0).get(1));
        assertEquals("..Q..", result5.get(0).get(2));
        assertEquals("...Q.", result5.get(0).get(3));
        assertEquals("....Q", result5.get(0).get(4));

        // Test case 6: n = 6
        List<List<String>> result6 = nqueens.solveNQueens(6);
        assertEquals(4, result6.size());
        assertEquals(6, result6.get(0).size());

        // Test case 7: n = 8
        List<List<String>> result7 = nqueens.solveNQueens(8);
        assertEquals(92, result7.size());
        assertEquals(8, result7.get(0).size());
    }
}