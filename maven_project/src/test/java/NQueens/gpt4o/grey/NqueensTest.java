package NQueens.gpt4o.grey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import NQueens.Nqueens;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class NqueensTest {

    private final Nqueens nqueens = new Nqueens();

    @Test
    void testSolveNQueens_4() {
        List<List<String>> expectedSolutions = Arrays.asList(
            Arrays.asList(".Q..", "...Q", "Q...", "..Q."),
            Arrays.asList("..Q.", "Q...", "...Q", ".Q..")
        );

        List<List<String>> actualSolutions = nqueens.solveNQueens(4);
        
        assertEquals(expectedSolutions.size(), actualSolutions.size(), "Number of solutions should match.");
        
        // Check if each actual solution is within expected solutions
        for (List<String> solution : actualSolutions) {
            assertTrue(expectedSolutions.contains(solution), "Solution " + solution + " is not expected.");
        }
    }

    @Test
    void testSolveNQueens_1() {
        List<List<String>> expectedSolutions = Arrays.asList(
            Arrays.asList("Q")
        );

        List<List<String>> actualSolutions = nqueens.solveNQueens(1);

        assertEquals(expectedSolutions.size(), actualSolutions.size(), "Number of solutions should match.");
        assertEquals(expectedSolutions, actualSolutions, "Solutions for n=1 should match.");
    }

    @Test
    void testSolveNQueens_2() {
        // No solution exists for n=2
        List<List<String>> expectedSolutions = new ArrayList<>();

        List<List<String>> actualSolutions = nqueens.solveNQueens(2);

        assertEquals(expectedSolutions.size(), actualSolutions.size(), "Number of solutions should match.");
    }

    @Test
    void testSolveNQueens_3() {
        // No solution exists for n=3
        List<List<String>> expectedSolutions = new ArrayList<>();

        List<List<String>> actualSolutions = nqueens.solveNQueens(3);

        assertEquals(expectedSolutions.size(), actualSolutions.size(), "Number of solutions should match.");
    }
}