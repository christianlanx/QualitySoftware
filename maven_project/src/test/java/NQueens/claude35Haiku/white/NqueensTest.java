package NQueens.claude35Haiku.white;
import NQueens.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.ArrayList;

class NqueensTest {

    private Nqueens nqueens = new Nqueens();

    @Test
    void testSolveNQueens_4x4Board() {
        List<List<String>> solutions = nqueens.solveNQueens(4);
        
        // Verify number of solutions
        assertEquals(2, solutions.size(), "4-Queens should have 2 solutions");
        
        // Verify solution structure
        solutions.forEach(solution -> {
            assertEquals(4, solution.size(), "Each solution should have 4 rows");
            solution.forEach(row -> assertEquals(4, row.length(), "Each row should have 4 columns"));
        });
    }

    @Test
    void testSolveNQueens_1x1Board() {
        List<List<String>> solutions = nqueens.solveNQueens(1);
        
        assertEquals(1, solutions.size(), "1-Queens should have 1 solution");
        assertEquals(1, solutions.get(0).size(), "Solution should have 1 row");
        assertEquals("Q", solutions.get(0).get(0), "Solution should be a single 'Q'");
    }

    @Test
    void testSolveNQueens_3x3Board() {
        List<List<String>> solutions = nqueens.solveNQueens(3);
        
        // 3-Queens has no valid solutions
        assertEquals(0, solutions.size(), "3-Queens should have 0 solutions");
    }

    @Test
    void testSolveNQueens_5x5Board() {
        List<List<String>> solutions = nqueens.solveNQueens(5);
        
        // Verify number of solutions for 5-Queens
        assertEquals(10, solutions.size(), "5-Queens should have 10 solutions");
        
        solutions.forEach(solution -> {
            assertEquals(5, solution.size(), "Each solution should have 5 rows");
            solution.forEach(row -> assertEquals(5, row.length(), "Each row should have 5 columns"));
        });
    }

    @Test
    void testValidBoard_ValidConfiguration() {
        int[][] board = {
            {0, 1, 0, 0},
            {0, 0, 0, 1},
            {1, 0, 0, 0},
            {0, 0, 1, 0}
        };
        
        assertTrue(nqueens.validBoard(board, 2, 0), "Board configuration should be valid");
    }

    @Test
    void testValidBoard_InvalidConfiguration() {
        int[][] board = {
            {0, 1, 0, 0},
            {1, 0, 0, 0},
            {0, 0, 1, 0},
            {0, 0, 0, 1}
        };
        
        assertFalse(nqueens.validBoard(board, 3, 3), "Board configuration should be invalid");
    }

    @Test
    void testPutBoard_CorrectBoardRepresentation() {
        int[][] board = {
            {0, 1, 0, 0},
            {0, 0, 0, 1},
            {1, 0, 0, 0},
            {0, 0, 1, 0}
        };
        
        List<List<String>> ret = new ArrayList<>();
        nqueens.putBoard(board, ret);
        
        assertEquals(1, ret.size(), "Should add one board configuration");
        List<String> solution = ret.get(0);
        assertEquals(".Q..", solution.get(0), "First row should be '.Q..'");
        assertEquals("...Q", solution.get(1), "Second row should be '...Q'");
        assertEquals("Q...", solution.get(2), "Third row should be 'Q...'");
        assertEquals("..Q.", solution.get(3), "Fourth row should be '..Q.'");
    }
}