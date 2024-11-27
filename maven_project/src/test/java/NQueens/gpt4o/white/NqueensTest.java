package NQueens.gpt4o.white;
import NQueens.*;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class NqueensTest {

    private final Nqueens nQueensSolver = new Nqueens();

    @Test
    void testNQueens1() {
        List<List<String>> solutions = nQueensSolver.solveNQueens(1);
        assertEquals(1, solutions.size());
        assertEquals(List.of(List.of("Q")), solutions);
    }

    @Test
    void testNQueens2() {
        List<List<String>> solutions = nQueensSolver.solveNQueens(2);
        assertEquals(0, solutions.size());
    }

    @Test
    void testNQueens3() {
        List<List<String>> solutions = nQueensSolver.solveNQueens(3);
        assertEquals(0, solutions.size());
    }

    @Test
    void testNQueens4() {
        List<List<String>> solutions = nQueensSolver.solveNQueens(4);
        assertEquals(2, solutions.size());

        List<List<String>> expectedSolutions = List.of(
                List.of(
                        ".Q..",
                        "...Q",
                        "Q...",
                        "..Q."
                ),
                List.of(
                        "..Q.",
                        "Q...",
                        "...Q",
                        ".Q.."
                )
        );

        assertTrue(solutions.containsAll(expectedSolutions));
    }

    @Test
    void testNQueens5() {
        List<List<String>> solutions = nQueensSolver.solveNQueens(5);
        assertEquals(10, solutions.size());
    }

    @Test
    void testNQueens6() {
        List<List<String>> solutions = nQueensSolver.solveNQueens(6);
        assertEquals(4, solutions.size());
    }

    @Test
    void testNQueens7() {
        List<List<String>> solutions = nQueensSolver.solveNQueens(7);
        assertEquals(40, solutions.size());
    }

    @Test
    void testNQueens8() {
        List<List<String>> solutions = nQueensSolver.solveNQueens(8);
        assertEquals(92, solutions.size());
    }
}