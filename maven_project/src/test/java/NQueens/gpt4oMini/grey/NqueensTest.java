package NQueens.gpt4oMini.grey;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class NqueensTest {

    private final Nqueens nqueens = new Nqueens();

    @Test
    void testSolveNQueens_nEquals1() {
        List<List<String>> solutions = nqueens.solveNQueens(1);
        assertEquals(1, solutions.size());
        assertEquals(List.of("Q"), solutions.get(0));
    }

    @Test
    void testSolveNQueens_nEquals4() {
        List<List<String>> solutions = nqueens.solveNQueens(4);
        assertEquals(2, solutions.size());
        
        // Check the first solution
        List<String> solution1 = List.of(".Q..", "...Q", "Q...", "..Q.");
        assertTrue(solutions.contains(solution1));
        
        // Check the second solution
        List<String> solution2 = List.of("..Q.", "Q...", "...Q", ".Q..");
        assertTrue(solutions.contains(solution2));
    }

    @Test
    void testSolveNQueens_nEquals5() {
        List<List<String>> solutions = nqueens.solveNQueens(5);
        assertEquals(10, solutions.size());
    }

    @Test
    void testSolveNQueens_nEquals6() {
        List<List<String>> solutions = nqueens.solveNQueens(6);
        assertEquals(4, solutions.size());
    }

    @Test
    void testSolveNQueens_nEquals7() {
        List<List<String>> solutions = nqueens.solveNQueens(7);
        assertEquals(40, solutions.size());
    }

    @Test
    void testSolveNQueens_nEquals8() {
        List<List<String>> solutions = nqueens.solveNQueens(8);
        assertEquals(92, solutions.size());
    }

    @Test
    void testSolveNQueens_nEquals9() {
        List<List<String>> solutions = nqueens.solveNQueens(9);
        assertEquals(352, solutions.size());
    }

    @Test
    void testSolveNQueens_invalidInput() {
        assertThrows(IllegalArgumentException.class, () -> {
            nqueens.solveNQueens(0);
        });
        
        assertThrows(IllegalArgumentException.class, () -> {
            nqueens.solveNQueens(-1);
        });
    }
}