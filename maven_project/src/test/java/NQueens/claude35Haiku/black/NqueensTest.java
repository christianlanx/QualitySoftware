package NQueens.claude35Haiku.black;

import NQueens.Nqueens;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NqueensTest {

    private Nqueens nQueens;

    @BeforeEach
    void setUp() {
        nQueens = new Nqueens();
    }

    @Test
    void testSolveNQueensForOneQueen() {
        List<List<String>> solutions = nQueens.solveNQueens(1);
        
        assertNotNull(solutions);
        assertEquals(1, solutions.size());
        assertEquals(1, solutions.get(0).size());
        assertEquals("Q", solutions.get(0).get(0));
    }

    @Test
    void testSolveNQueensForFourQueens() {
        List<List<String>> solutions = nQueens.solveNQueens(4);
        
        assertNotNull(solutions);
        assertEquals(2, solutions.size());
        
        // Check board size and solution format
        for (List<String> solution : solutions) {
            assertEquals(4, solution.size());
            for (String row : solution) {
                assertEquals(4, row.length());
                assertTrue(row.matches("[Q.]{4}"));
            }
        }
    }

    @Test
    void testSolveNQueensForMinimumConstraint() {
        List<List<String>> solutions = nQueens.solveNQueens(1);
        
        assertNotNull(solutions);
        assertFalse(solutions.isEmpty());
    }

    @Test
    void testSolveNQueensForMaximumConstraint() {
        List<List<String>> solutions = nQueens.solveNQueens(9);
        
        assertNotNull(solutions);
        assertFalse(solutions.isEmpty());
    }

    @Test
    void testSolveNQueensSolutionValidity() {
        List<List<String>> solutions = nQueens.solveNQueens(4);
        
        for (List<String> solution : solutions) {
            assertTrue(isSolutionValid(solution));
        }
    }

    @Test
    void testSolveNQueensWithInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> {
            nQueens.solveNQueens(0);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            nQueens.solveNQueens(10);
        });
    }

    // Helper method to validate N-Queens solution
    private boolean isSolutionValid(List<String> solution) {
        int n = solution.size();
        
        // Convert board to 2D char array
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            board[i] = solution.get(i).toCharArray();
        }
        
        // Check queen placement
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (board[row][col] == 'Q') {
                    // Check row and column
                    if (!isQueenPlacementValid(board, row, col)) {
                        return false;
                    }
                }
            }
        }
        
        return true;
    }

    // Check if queen placement is valid
    private boolean isQueenPlacementValid(char[][] board, int row, int col) {
        int n = board.length;
        
        // Check same row
        for (int j = 0; j < n; j++) {
            if (j != col && board[row][j] == 'Q') {
                return false;
            }
        }
        
        // Check same column
        for (int i = 0; i < n; i++) {
            if (i != row && board[i][col] == 'Q') {
                return false;
            }
        }
        
        // Check diagonals
        int[][] directions = {{-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        
        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            
            while (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n) {
                if (board[newRow][newCol] == 'Q') {
                    return false;
                }
                newRow += dir[0];
                newCol += dir[1];
            }
        }
        
        return true;
    }
}