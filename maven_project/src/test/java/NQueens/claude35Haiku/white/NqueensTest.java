package NQueens.claude35Haiku.white;

import NQueens.Nqueens;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NqueensTest {
    private Nqueens nqueens;

    @BeforeEach
    void setUp() {
        nqueens = new Nqueens();
    }

    @Test
    void testSolveNQueens_4x4Board() {
        List<List<String>> solutions = nqueens.solveNQueens(4);
        
        assertNotNull(solutions);
        assertEquals(2, solutions.size(), "4x4 board should have 2 solutions");
        
        // Validate solution format
        for (List<String> solution : solutions) {
            assertEquals(4, solution.size(), "Solution should have 4 rows");
            for (String row : solution) {
                assertEquals(4, row.length(), "Each row should have 4 characters");
                assertTrue(row.matches("[.Q]+"), "Row should only contain '.' and 'Q'");
            }
        }
    }

    @Test
    void testSolveNQueens_1x1Board() {
        List<List<String>> solutions = nqueens.solveNQueens(1);
        
        assertNotNull(solutions);
        assertEquals(1, solutions.size(), "1x1 board should have 1 solution");
        
        // Validate solution
        List<String> solution = solutions.get(0);
        assertEquals(1, solution.size());
        assertEquals("Q", solution.get(0));
    }

    @Test
    void testSolveNQueens_NoSolutionBoard() {
        List<List<String>> solutions = nqueens.solveNQueens(2);
        
        assertNotNull(solutions);
        assertTrue(solutions.isEmpty(), "2x2 board should have no solutions");
    }

    @Test
    void testSolveNQueens_LargerBoard() {
        List<List<String>> solutions = nqueens.solveNQueens(8);
        
        assertNotNull(solutions);
        assertEquals(92, solutions.size(), "8x8 board should have 92 solutions");
    }

    @Test
    void testValidBoard_ValidConfiguration() {
        int[][] board = new int[4][4];
        board[0][1] = 1;  // Place queen
        board[1][3] = 1;  // Place queen
        
        assertTrue(nqueens.validBoard(board, 1, 3));
    }

    @Test
    void testValidBoard_InvalidConfiguration() {
        int[][] board = new int[4][4];
        board[0][1] = 1;  // Place queen
        board[1][1] = 1;  // Place another queen in same column (invalid)
        
        assertFalse(nqueens.validBoard(board, 1, 1));
    }

    @Test
    void testPutBoard_CorrectBoardGeneration() {
        // This test requires full method coverage, which might be challenging
        // You could create a mock board and verify board generation
        int[][] board = new int[3][3];
        board[0][1] = 1;
        board[1][0] = 1;
        board[2][2] = 1;
        
        List<List<String>> results = new ArrayList<>();
        nqueens.putBoard(board, results);
        
        assertFalse(results.isEmpty());
        assertEquals(1, results.size());
    }
}