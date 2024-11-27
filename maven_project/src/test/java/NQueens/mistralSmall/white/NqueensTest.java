package NQueens.mistralSmall.white;
import NQueens.*;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NqueensTest {

    @Test
    public void testSolveNQueens_1() {
        Nqueens nqueens = new Nqueens();
        List<List<String>> result = nqueens.solveNQueens(1);
        assertEquals(1, result.size());
        assertEquals("[Q]", result.get(0).toString());
    }

    @Test
    public void testSolveNQueens_2() {
        Nqueens nqueens = new Nqueens();
        List<List<String>> result = nqueens.solveNQueens(2);
        assertEquals(0, result.size());
    }

    @Test
    public void testSolveNQueens_3() {
        Nqueens nqueens = new Nqueens();
        List<List<String>> result = nqueens.solveNQueens(3);
        assertEquals(0, result.size());
    }

    @Test
    public void testSolveNQueens_4() {
        Nqueens nqueens = new Nqueens();
        List<List<String>> result = nqueens.solveNQueens(4);
        assertEquals(2, result.size());
        assertEquals("[Q...\n.Q..\n..Q.\n...Q]", result.get(0).toString());
        assertEquals("[Q...\n..Q.\n.Q..\n...Q]", result.get(1).toString());
    }

    @Test
    public void testSolveNQueens_5() {
        Nqueens nqueens = new Nqueens();
        List<List<String>> result = nqueens.solveNQueens(5);
        assertEquals(10, result.size());
    }

    @Test
    public void testSolveNQueens_8() {
        Nqueens nqueens = new Nqueens();
        List<List<String>> result = nqueens.solveNQueens(8);
        assertEquals(92, result.size());
    }
}