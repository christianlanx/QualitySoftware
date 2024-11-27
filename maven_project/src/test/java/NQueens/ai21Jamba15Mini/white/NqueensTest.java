package NQueens.ai21Jamba15Mini.white;
import NQueens.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class NqueensTest {

    @Test
    void testSolveNQueens() {
        Nqueens nqueens = new Nqueens();
        List<List<String>> solution = nqueens.solveNQueens(4);
        // Add assertions to verify the solution
    }

    @Test
    void testValidBoard() {
        Nqueens nqueens = new Nqueens();
        int[][] board = {{1, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}};
        boolean result = nqueens.validBoard(board, 0, 0);
        assertTrue(result);
    }

    @Test
    void testInvalidBoard() {
        Nqueens nqueens = new Nqueens();
        int[][] board = {{1, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}};
        boolean result = nqueens.validBoard(board, 0, 1);
        assertFalse(result);
    }
}