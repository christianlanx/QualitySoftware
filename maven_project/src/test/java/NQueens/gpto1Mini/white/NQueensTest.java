package NQueens.gpto1Mini.white;
import NQueens.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NQueensTest {

    private Nqueens nqueens;

    @BeforeEach
    public void setUp() {
        nqueens = new Nqueens();
    }

    @Test
    public void testSolveNQueens_n1() {
        int n = 1;
        List<List<String>> expected = new ArrayList<>();
        expected.add(Arrays.asList("Q"));

        List<List<String>> result = nqueens.solveNQueens(n);
        assertEquals(expected, result, "n=1 should return one solution with a single queen.");
    }

    @Test
    public void testSolveNQueens_n2() {
        int n = 2;
        List<List<String>> expected = new ArrayList<>();

        List<List<String>> result = nqueens.solveNQueens(n);
        assertEquals(expected, result, "n=2 should return no solutions.");
    }

    @Test
    public void testSolveNQueens_n3() {
        int n = 3;
        List<List<String>> expected = new ArrayList<>();

        List<List<String>> result = nqueens.solveNQueens(n);
        assertEquals(expected, result, "n=3 should return no solutions.");
    }

    @Test
    public void testSolveNQueens_n4() {
        int n = 4;
        List<List<String>> expected = new ArrayList<>();
        expected.add(Arrays.asList(
                ".Q..",
                "...Q",
                "Q...",
                "..Q."
        ));
        expected.add(Arrays.asList(
                "..Q.",
                "Q...",
                "...Q",
                ".Q.."
        ));

        List<List<String>> result = nqueens.solveNQueens(n);
        assertEquals(expected.size(), result.size(), "n=4 should return two solutions.");

        for (List<String> solution : expected) {
            assertTrue(result.contains(solution), "Expected solution not found: " + solution);
        }
    }

    @Test
    public void testSolveNQueens_n5() {
        int n = 5;
        List<List<String>> result = nqueens.solveNQueens(n);
        assertEquals(10, result.size(), "n=5 should return ten solutions.");
    }

    @Test
    public void testSolveNQueens_n8() {
        int n = 8;
        List<List<String>> result = nqueens.solveNQueens(n);
        assertEquals(92, result.size(), "n=8 should return ninety-two solutions.");
    }

    @Test
    public void testValidBoard_ValidPlacement() {
        int[][] board = {
            {1, 0, 0},
            {0, 0, 1},
            {0, 1, 0}
        };
        assertTrue(nqueens.validBoard(board, 2, 1), "Board should be valid for row=2, col=1.");
    }

    @Test
    public void testValidBoard_InvalidPlacement_ColumnConflict() {
        int[][] board = {
            {1, 0, 0},
            {0, 0, 0},
            {1, 0, 0}
        };
        assertFalse(nqueens.validBoard(board, 2, 0), "Board should be invalid due to column conflict.");
    }

    @Test
    public void testValidBoard_InvalidPlacement_DiagonalConflict() {
        int[][] board = {
            {0, 1, 0},
            {0, 0, 0},
            {0, 0, 0}
        };
        assertFalse(nqueens.validBoard(board, 2, 0), "Board should be invalid due to diagonal conflict.");
    }

    @Test
    public void testPutBoard_AddsCorrectly() {
        int[][] board = {
            {0, 1, 0},
            {0, 0, 0},
            {1, 0, 0}
        };
        List<List<String>> ret = new ArrayList<>();
        nqueens.putBoard(board, ret);

        List<String> expected = Arrays.asList(
            ".Q.",
            "...",
            "Q.."
        );

        assertEquals(1, ret.size(), "There should be one board in the result.");
        assertEquals(expected, ret.get(0), "The board representation is incorrect.");
    }

    @Test
    public void testPutQueens_FindsAllSolutions_n4() {
        int n = 4;
        List<List<String>> result = new ArrayList<>();
        int[][] board = new int[n][n];
        nqueens.putQueens(board, 0, result);

        List<List<String>> expected = new ArrayList<>();
        expected.add(Arrays.asList(
                ".Q..",
                "...Q",
                "Q...",
                "..Q."
        ));
        expected.add(Arrays.asList(
                "..Q.",
                "Q...",
                "...Q",
                ".Q.."
        ));

        assertEquals(expected.size(), result.size(), "There should be two solutions for n=4.");

        for (List<String> solution : expected) {
            assertTrue(result.contains(solution), "Expected solution not found: " + solution);
        }
    }
}