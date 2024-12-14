package NQueens.claude35Haiku.black;

import NQueens.Nqueens;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class NqueensTest {

    private Nqueens solution = new Nqueens();

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void testSolveNQueens(int n, int expectedSolutions) {
        List<List<String>> result = solution.solveNQueens(n);
        
        // Validate basic constraints
        assertNotNull(result);
        assertEquals(expectedSolutions, result.size());
        
        // Validate each solution
        for (List<String> board : result) {
            validateBoard(board, n);
        }
    }

    @Test
    void testMinimumBoardSize() {
        List<List<String>> result = solution.solveNQueens(1);
        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(1, result.get(0).size());
        assertTrue(result.get(0).get(0).equals("Q"));
    }

    @Test
    void testMaximumBoardSize() {
        List<List<String>> result = solution.solveNQueens(9);
        assertNotNull(result);
        assertFalse(result.isEmpty());
    }

    @Test
    void testInvalidBoardSize() {
        assertThrows(IllegalArgumentException.class, () -> {
            solution.solveNQueens(0);
        });
        
        assertThrows(IllegalArgumentException.class, () -> {
            solution.solveNQueens(10);
        });
    }

    // Helper method to validate each board configuration
    private void validateBoard(List<String> board, int n) {
        // Check board size
        assertEquals(n, board.size());
        
        // Verify each row has correct length and contains only Q or .
        for (String row : board) {
            assertEquals(n, row.length());
            assertTrue(row.matches("^[Q.]+$"));
        }
        
        // Validate queen placement - each row and column has exactly one queen
        validateQueenPlacement(board, n);
    }

    // Helper method to validate queen placement rules
    private void validateQueenPlacement(List<String> board, int n) {
        int queensCount = 0;
        
        // Check row-wise queen count
        for (String row : board) {
            int rowQueens = row.chars().filter(ch -> ch == 'Q').count();
            assertEquals(1, rowQueens, "Each row must have exactly one queen");
            queensCount += rowQueens;
        }
        assertEquals(n, queensCount, "Total queens must equal board size");
        
        // Check diagonal and column conflicts
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                assertFalse(isConflicting(board, i, j), 
                    "Queens cannot attack each other diagonally or in same column");
            }
        }
    }

    // Check if queens at given rows are conflicting
    private boolean isConflicting(List<String> board, int row1, int row2) {
        int col1 = board.get(row1).indexOf('Q');
        int col2 = board.get(row2).indexOf('Q');
        
        return col1 == col2 ||                    // Same column
               Math.abs(row1 - row2) == Math.abs(col1 - col2);  // Diagonal
    }

    // Parameterized test cases with expected solution count
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
            Arguments.of(1, 1),   // Minimum board size
            Arguments.of(4, 2),   // Classic problem with 2 solutions
            Arguments.of(5, 10),  // More complex case
            Arguments.of(8, 92)   // Standard chessboard size
        );
    }
}