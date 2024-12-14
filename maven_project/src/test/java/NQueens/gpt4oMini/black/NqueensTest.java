package NQueens.gpt4oMini.black;

import NQueens.Nqueens;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class NqueensTest {

    private final Nqueens nqueens = new Nqueens();

    @Test
    void testSolveNQueensWithN1() {
        List<List<String>> result = nqueens.solveNQueens(1);
        assertEquals(1, result.size());
        assertEquals(List.of("Q"), result.get(0));
    }

    @Test
    void testSolveNQueensWithN4() {
        List<List<String>> result = nqueens.solveNQueens(4);
        assertEquals(2, result.size());
        
        // Check for distinct solutions
        assertTrue(result.contains(List.of(".Q..", "...Q", "Q...", "..Q.")));
        assertTrue(result.contains(List.of("..Q.", "Q...", "...Q", ".Q..")));
    }

    @Test
    void testSolveNQueensWithN5() {
        List<List<String>> result = nqueens.solveNQueens(5);
        assertEquals(10, result.size()); // Assuming there are 10 solutions for n = 5
    }

    @Test
    void testSolveNQueensWithN9() {
        List<List<String>> result = nqueens.solveNQueens(9);
        assertTrue(result.size() > 0); // Just checking if there are solutions
    }

    @Test
    void testSolveNQueensWithN2() {
        List<List<String>> result = nqueens.solveNQueens(2);
        assertEquals(0, result.size()); // No solutions exist for n = 2
    }

    @Test
    void testSolveNQueensWithN3() {
        List<List<String>> result = nqueens.solveNQueens(3);
        assertEquals(0, result.size()); // No solutions exist for n = 3
    }

    // Additional test case for edge case n = 0
    @Test
    void testSolveNQueensWithN0() {
        List<List<String>> result = nqueens.solveNQueens(0);
        assertEquals(1, result.size()); // There is one way to solve n-queens for n = 0 (empty board)
        assertEquals(List.of(), result.get(0)); // The only configuration for n = 0 is an empty board
    }
}