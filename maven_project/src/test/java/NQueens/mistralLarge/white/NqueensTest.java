package NQueens.mistralLarge.white;
import NQueens.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.Arrays;

public class NqueensTest {

    private Nqueens nqueens;

    @BeforeEach
    public void setUp() {
        nqueens = new Nqueens();
    }

    @Test
    public void testSolveNQueens_1() {
        List<List<String>> result = nqueens.solveNQueens(1);
        assertEquals(1, result.size());
        assertEquals(Arrays.asList("Q"), result.get(0));
    }

    @Test
    public void testSolveNQueens_2() {
        List<List<String>> result = nqueens.solveNQueens(2);
        assertEquals(0, result.size());
    }

    @Test
    public void testSolveNQueens_3() {
        List<List<String>> result = nqueens.solveNQueens(3);
        assertEquals(0, result.size());
    }

    @Test
    public void testSolveNQueens_4() {
        List<List<String>> result = nqueens.solveNQueens(4);
        assertEquals(2, result.size());
        assertTrue(result.contains(Arrays.asList(".Q..", "...Q", "Q...", "..Q.")));
        assertTrue(result.contains(Arrays.asList("..Q.", "Q...", "...Q", ".Q..")));
    }

    @Test
    public void testSolveNQueens_5() {
        List<List<String>> result = nqueens.solveNQueens(5);
        assertEquals(10, result.size());
        assertTrue(result.contains(Arrays.asList("Q....", "..Q..", "....Q", ".Q...", "...Q.")));
        assertTrue(result.contains(Arrays.asList("Q....", "...Q.", ".Q...", "....Q", "..Q..")));
        assertTrue(result.contains(Arrays.asList(".Q...", "...Q.", "Q....", "..Q..", "....Q")));
        assertTrue(result.contains(Arrays.asList(".Q...", "....Q", "..Q..", "Q....", "...Q.")));
        assertTrue(result.contains(Arrays.asList("..Q..", "Q....", "...Q.", ".Q...", "....Q")));
        assertTrue(result.contains(Arrays.asList("..Q..", "....Q", ".Q...", "...Q.", "Q....")));
        assertTrue(result.contains(Arrays.asList("...Q.", "Q....", "..Q..", "....Q", ".Q...")));
        assertTrue(result.contains(Arrays.asList("...Q.", ".Q...", "....Q", "..Q..", "Q....")));
        assertTrue(result.contains(Arrays.asList("....Q", ".Q...", "...Q.", "Q....", "..Q..")));
        assertTrue(result.contains(Arrays.asList("....Q", "..Q..", "Q....", "...Q.", ".Q...")));
    }

    @Test
    public void testValidBoard() {
        int[][] board = new int[4][4];
        board[0][0] = 1;
        board[1][2] = 1;
        board[2][0] = 1;
        board[3][3] = 1;

        assertTrue(nqueens.validBoard(board, 4, 0));
        assertFalse(nqueens.validBoard(board, 4, 1));
    }

    @Test
    public void testPutBoard() {
        int[][] board = new int[4][4];
        board[0][0] = 1;
        board[1][2] = 1;
        board[2][0] = 1;
        board[3][3] = 1;

        List<List<String>> result = new ArrayList<>();
        nqueens.putBoard(board, result);

        assertEquals(1, result.size());
        assertEquals(Arrays.asList("Q...", "..Q.", "Q...", "...Q"), result.get(0));
    }
}