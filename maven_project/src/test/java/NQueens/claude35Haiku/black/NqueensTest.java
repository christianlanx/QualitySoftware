package NQueens.claude35Haiku.black;
import NQueens.*;

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
        
        // Check number of solutions
        assertEquals(expectedSolutions, result.size(), 
            "Number of solutions for " + n + "-queens problem");

        // Validate each solution
        for (List<String> board : result) {
            validateBoard(board, n);
        }
    }

    @Test
    void testSingleQueenBoard() {
        List<List<String>> result = solution.solveNQueens(1);
        
        assertEquals(1, result.size(), "Single queen board should have one solution");
        assertEquals(List.of("Q"), result.get(0), "Single queen board configuration");
    }

    @Test
    void testInvalidBoardSize() {
        assertThrows(IllegalArgumentException.class, () -> {
            solution.solveNQueens(0);
        }, "Should throw exception for board size < 1");

        assertThrows(IllegalArgumentException.class, () -> {
            solution.solveNQueens(10);
        }, "Should throw exception for board size > 9");
    }

    // Helper method to validate board configuration
    private void validateBoard(List<String> board, int n) {
        // Check board size
        assertEquals(n, board.size(), "Board should have correct number of rows");
        
        // Check each row has correct length
        board.forEach(row -> assertEquals(n, row.length(), "Row should have correct length"));
        
        // Check queen placement
        for (int row = 0; row < n; row++) {
            int queenCol = board.get(row).indexOf('Q');
            assertTrue(queenCol != -1, "Each row must have a queen");
            
            // Check no other queens in the same row
            long queensInRow = board.get(row).chars().filter(ch -> ch == 'Q').count();
            assertEquals(1, queensInRow, "Only one queen per row");
            
            // Check diagonal and column conflicts
            for (int otherRow = 0; otherRow < n; otherRow++) {
                if (row != otherRow) {
                    int otherQueenCol = board.get(otherRow).indexOf('Q');
                    
                    // Check column conflict
                    assertNotEquals(queenCol, otherQueenCol, 
                        "No queens in the same column");
                    
                    // Check diagonal conflict
                    assertFalse(Math.abs(row - otherRow) == Math.abs(queenCol - otherQueenCol), 
                        "No queens on same diagonal");
                }
            }
        }
    }

    // Provide test cases with n and expected number of solutions
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
            Arguments.of(4, 2),   // Standard 4-queens problem
            Arguments.of(1, 1),   // Single queen
            Arguments.of(3, 0),   // No solutions
            Arguments.of(5, 10),  // 5-queens problem
            Arguments.of(8, 92)   // Classic 8-queens problem
        );
    }
}