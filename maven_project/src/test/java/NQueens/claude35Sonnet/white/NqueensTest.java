package NQueens.claude35Sonnet.white;
import NQueens.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class NqueensTest {
    private Nqueens nqueens;

    @BeforeEach
    void setUp() {
        nqueens = new Nqueens();
    }

    @Test
    void testSolveNQueensForN1() {
        List<List<String>> result = nqueens.solveNQueens(1);
        assertEquals(1, result.size());
        assertEquals("Q", result.get(0).get(0));
    }

    @Test
    void testSolveNQueensForN4() {
        List<List<String>> result = nqueens.solveNQueens(4);
        assertEquals(2, result.size());
        
        // Check first solution
        List<String> expectedSolution1 = List.of(
            ".Q..",
            "...Q",
            "Q...",
            "..Q."
        );
        assertTrue(result.contains(expectedSolution1));

        // Check second solution
        List<String> expectedSolution2 = List.of(
            "..Q.",
            "Q...",
            "...Q",
            ".Q.."
        );
        assertTrue(result.contains(expectedSolution2));
    }

    @Test
    void testValidBoard() {
        int[][] board = new int[4][4];
        
        // Test valid placement
        board[0][1] = 1;
        assertTrue(nqueens.validBoard(board, 1, 3));

        // Test invalid placement (same column)
        board[0][3] = 1;
        assertFalse(nqueens.validBoard(board, 1, 3));

        // Test invalid placement (diagonal)
        board[0][3] = 0;
        board[0][2] = 1;
        assertFalse(nqueens.validBoard(board, 1, 3));
    }

    @Test
    void testPutBoard() {
        int[][] board = {
            {0, 1, 0, 0},
            {0, 0, 0, 1},
            {1, 0, 0, 0},
            {0, 0, 1, 0}
        };
        List<List<String>> result = new ArrayList<>();
        nqueens.putBoard(board, result);

        assertEquals(1, result.size());
        List<String> expected = List.of(
            ".Q..",
            "...Q",
            "Q...",
            "..Q."
        );
        assertEquals(expected, result.get(0));
    }

    @Test
    void testSolveNQueensForN2() {
        List<List<String>> result = nqueens.solveNQueens(2);
        assertEquals(0, result.size());
    }

    @Test
    void testSolveNQueensForN3() {
        List<List<String>> result = nqueens.solveNQueens(3);
        assertEquals(0, result.size());
    }

    @Test
    void testSolveNQueensForN8() {
        List<List<String>> result = nqueens.solveNQueens(8);
        assertEquals(92, result.size());  // There are exactly 92 solutions for 8 queens
    }
}