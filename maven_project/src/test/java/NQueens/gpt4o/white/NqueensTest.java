package NQueens.gpt4o.white;

import NQueens.Nqueens;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class NqueensTest {

    private Nqueens nQueensSolver;

    @BeforeEach
    public void setUp() {
        nQueensSolver = new Nqueens();
    }

    @Test
    public void testSolveNQueens_withNEquals1() {
        List<List<String>> solutions = nQueensSolver.solveNQueens(1);
        assertEquals(1, solutions.size());
        assertEquals("Q", solutions.get(0).get(0));
    }

    @Test
    public void testSolveNQueens_withNEquals4() {
        List<List<String>> solutions = nQueensSolver.solveNQueens(4);
        assertEquals(2, solutions.size());
        // First solution
        assertEquals(List.of(
                ".Q..",
                "...Q",
                "Q...",
                "..Q."
        ), solutions.get(0));

        // Second solution
        assertEquals(List.of(
                "..Q.",
                "Q...",
                "...Q",
                ".Q.."
        ), solutions.get(1));
    }

    @Test
    public void testSolveNQueens_withNEquals2() {
        List<List<String>> solutions = nQueensSolver.solveNQueens(2);
        assertEquals(0, solutions.size());
    }

    @Test
    public void testSolveNQueens_withNEquals3() {
        List<List<String>> solutions = nQueensSolver.solveNQueens(3);
        assertEquals(0, solutions.size());
    }

    @Test
    public void testSolveNQueens_edgeCaseWithNEquals0() {
        List<List<String>> solutions = nQueensSolver.solveNQueens(0);
        assertEquals(0, solutions.size());
    }
}