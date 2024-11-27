package NQueens.mistralSmall.black;
import NQueens.*;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NqueensTest {

    @Test
    public void testSolveNQueens_n4() {
        Nqueens nqueens = new Nqueens();
        List<List<String>> result = nqueens.solveNQueens(4);

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

        assertEquals(List.of(solution1, solution2), result);
    }

    @Test
    public void testSolveNQueens_n1() {
        Nqueens nqueens = new Nqueens();
        List<List<String>> result = nqueens.solveNQueens(1);

        List<String> solution = List.of("Q");

        assertEquals(List.of(solution), result);
    }

    @Test
    public void testSolveNQueens_n2() {
        Nqueens nqueens = new Nqueens();
        List<List<String>> result = nqueens.solveNQueens(2);

        List<String> solution1 = List.of(
                "Q.",
                ".."
        );
        List<String> solution2 = List.of(
                ".Q",
                "Q."
        );

        assertEquals(List.of(solution1, solution2), result);
    }

    @Test
    public void testSolveNQueens_n3() {
        Nqueens nqueens = new Nqueens();
        List<List<String>> result = nqueens.solveNQueens(3);

        List<String> solution1 = List.of(
                ".Q.",
                "...",
                "..Q"
        );
        List<String> solution2 = List.of(
                "..Q",
                "Q..",
                ".Q."
        );
        List<String> solution3 = List.of(
                "Q..",
                "...",
                ".Q."
        );

        assertEquals(List.of(solution1, solution2, solution3), result);
    }

    @Test
    public void testSolveNQueens_n9() {
        Nqueens nqueens = new Nqueens();
        List<List<String>> result = nqueens.solveNQueens(9);

        // For n=9, there are 36 distinct solutions.
        assertEquals(36, result.size());
    }
}