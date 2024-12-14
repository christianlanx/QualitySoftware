package NQueens.ai21Jamba15Large.grey;

import NQueens.Nqueens;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NqueensTest {

    private final Nqueens nqueens = new Nqueens();

    @Test
    void testSolveNQueens_1() {
        // Input: n = 1
        // Output: [["Q"]]
        int n = 1;
        List<List<String>> expected = Arrays.asList(Arrays.asList("Q"));
        assertEquals(expected, nqueens.solveNQueens(n));
    }

    @Test
    void testSolveNQueens_4() {
        // Input: n = 4
        // Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
        int n = 4;
        List<List<String>> expected = Arrays.asList(
            Arrays.asList(".Q..", "...Q", "Q...", "..Q."),
            Arrays.asList("..Q.", "Q...", "...Q", ".Q..")
        );
        assertEquals(expected, nqueens.solveNQueens(n));
    }

    @Test
    void testSolveNQueens_9() {
        // Input: n = 9
        // Output: A valid list of solutions for the 9-queens puzzle
        int n = 9;
        List<List<String>> solutions = nqueens.solveNQueens(n);
        assertEquals(true, solutions.size() > 0);
        for (List<String> solution : solutions) {
            assertEquals(n, solution.size());
            for (String row : solution) {
                assertEquals(n, row.length());
                assertEquals(1, row.chars().filter(c -> c == 'Q').count());
            }
        }
    }

    @Test
    void testSolveNQueens_invalidInput() {
        // Input: n = 0
        // Output: Expected to handle invalid input gracefully
        int n = 0;
        assertThrows(IllegalArgumentException.class, () -> nqueens.solveNQueens(n));
    }
}