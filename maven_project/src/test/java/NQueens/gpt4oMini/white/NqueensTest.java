package NQueens.gpt4oMini.white;
import NQueens.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class NqueensTest {

    private final Nqueens nqueens = new Nqueens();

    @Test
    void testSolveNQueens_1() {
        List<List<String>> result = nqueens.solveNQueens(1);
        assertEquals(1, result.size());
        assertEquals(List.of("Q"), result.get(0));
    }

    @Test
    void testSolveNQueens_2() {
        List<List<String>> result = nqueens.solveNQueens(2);
        assertTrue(result.isEmpty());
    }

    @Test
    void testSolveNQueens_3() {
        List<List<String>> result = nqueens.solveNQueens(3);
        assertTrue(result.isEmpty());
    }

    @Test
    void testSolveNQueens_4() {
        List<List<String>> result = nqueens.solveNQueens(4);
        assertEquals(2, result.size());

        List<String> solution1 = List.of(
            ".Q..",
            "...Q",
            "Q...",
            "..Q."
        );
        List<String> solution2 = List.of(
            "..Q.",
            "Q...",
            "...Q",
            ".Q.."
        );

        assertTrue(result.contains(solution1));
        assertTrue(result.contains(solution2));
    }

    @Test
    void testSolveNQueens_5() {
        List<List<String>> result = nqueens.solveNQueens(5);
        assertEquals(10, result.size()); // 10 solutions for 5 queens
    }

    @Test
    void testSolveNQueens_6() {
        List<List<String>> result = nqueens.solveNQueens(6);
        assertEquals(4, result.size()); // 4 solutions for 6 queens
    }

    @Test
    void testSolveNQueens_7() {
        List<List<String>> result = nqueens.solveNQueens(7);
        assertEquals(40, result.size()); // 40 solutions for 7 queens
    }

    @Test
    void testSolveNQueens_8() {
        List<List<String>> result = nqueens.solveNQueens(8);
        assertEquals(92, result.size()); // 92 solutions for 8 queens
    }
}