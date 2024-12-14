package NQueens.gpto1Mini.white;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import NQueens.Nqueens;

import java.util.List;
import java.util.Arrays;

public class NqueensTest {

    @Test
    void testSolveNQueensWithN1() {
        Nqueens solver = new Nqueens();
        List<List<String>> expected = Arrays.asList(
            Arrays.asList("Q")
        );
        List<List<String>> result = solver.solveNQueens(1);
        assertEquals(expected, result, "Failed for n=1");
    }

    @Test
    void testSolveNQueensWithN2() {
        Nqueens solver = new Nqueens();
        List<List<String>> expected = Arrays.asList();
        List<List<String>> result = solver.solveNQueens(2);
        assertEquals(expected, result, "Failed for n=2");
    }

    @Test
    void testSolveNQueensWithN3() {
        Nqueens solver = new Nqueens();
        List<List<String>> expected = Arrays.asList();
        List<List<String>> result = solver.solveNQueens(3);
        assertEquals(expected, result, "Failed for n=3");
    }

    @Test
    void testSolveNQueensWithN4() {
        Nqueens solver = new Nqueens();
        List<List<String>> expected = Arrays.asList(
            Arrays.asList(
                ".Q..",
                "...Q",
                "Q...",
                "..Q."
            ),
            Arrays.asList(
                "..Q.",
                "Q...",
                "...Q",
                ".Q.."
            )
        );
        List<List<String>> result = solver.solveNQueens(4);
        assertEquals(expected.size(), result.size(), "Incorrect number of solutions for n=4");
        assertTrue(result.containsAll(expected), "Solutions for n=4 do not match expected");
    }

    @Test
    void testSolveNQueensWithN5() {
        Nqueens solver = new Nqueens();
        List<List<String>> result = solver.solveNQueens(5);
        assertEquals(10, result.size(), "Incorrect number of solutions for n=5");
    }

    @Test
    void testSolveNQueensWithN8() {
        Nqueens solver = new Nqueens();
        List<List<String>> result = solver.solveNQueens(8);
        assertEquals(92, result.size(), "Incorrect number of solutions for n=8");
    }

    @Test
    void testSolveNQueensPerformance() {
        Nqueens solver = new Nqueens();
        long startTime = System.currentTimeMillis();
        List<List<String>> result = solver.solveNQueens(10);
        long duration = System.currentTimeMillis() - startTime;
        assertEquals(724, result.size(), "Incorrect number of solutions for n=10");
        assertTrue(duration < 2000, "Performance issue: solveNQueens for n=10 took too long");
    }
}