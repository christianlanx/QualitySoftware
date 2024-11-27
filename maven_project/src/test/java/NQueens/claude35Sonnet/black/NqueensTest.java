package NQueens.claude35Sonnet.black;
import NQueens.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class NqueensTest {
    private Nqueens nqueens;

    @BeforeEach
    void setUp() {
        nqueens = new Nqueens();
    }

    @Test
    void testNQueensWithN4() {
        List<List<String>> expected = Arrays.asList(
            Arrays.asList(".Q..","...Q","Q...","..Q."),
            Arrays.asList("..Q.","Q...","...Q",".Q..")
        );
        
        List<List<String>> result = nqueens.solveNQueens(4);
        
        assertEquals(2, result.size());
        assertTrue(result.containsAll(expected));
        assertTrue(expected.containsAll(result));
    }

    @Test
    void testNQueensWithN1() {
        List<List<String>> expected = Arrays.asList(
            Arrays.asList("Q")
        );
        
        List<List<String>> result = nqueens.solveNQueens(1);
        
        assertEquals(1, result.size());
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    void testValidInputRange(int n) {
        List<List<String>> result = nqueens.solveNQueens(n);
        
        assertNotNull(result);
        if (!result.isEmpty()) {
            assertEquals(n, result.get(0).size()); // Check board size
            for (List<String> solution : result) {
                assertEquals(n, solution.size()); // Each solution should have n rows
                for (String row : solution) {
                    assertEquals(n, row.length()); // Each row should have n characters
                    assertTrue(row.matches("[Q.]+"));  // Only contains Q or .
                    assertEquals(1, row.chars().filter(ch -> ch == 'Q').count()); // One queen per row
                }
            }
        }
    }

    @Test
    void testQueensDoNotAttackEachOther() {
        List<List<String>> result = nqueens.solveNQueens(4);
        
        for (List<String> solution : result) {
            assertTrue(isValidSolution(solution));
        }
    }

    private boolean isValidSolution(List<String> board) {
        int n = board.size();
        int[] queens = new int[n];
        
        // Convert board to queen positions
        for (int i = 0; i < n; i++) {
            queens[i] = board.get(i).indexOf('Q');
        }
        
        // Check if queens attack each other
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (queens[i] == queens[j]) return false; // Same column
                if (Math.abs(queens[i] - queens[j]) == Math.abs(i - j)) return false; // Diagonal
            }
        }
        return true;
    }

    @Test
    void testEmptyResult() {
        List<List<String>> result = nqueens.solveNQueens(2);
        assertTrue(result.isEmpty());
        
        result = nqueens.solveNQueens(3);
        assertTrue(result.isEmpty());
    }

    @Test
    void testNumberOfSolutionsForN8() {
        List<List<String>> result = nqueens.solveNQueens(8);
        assertEquals(92, result.size()); // Known number of solutions for 8-queens
    }
}