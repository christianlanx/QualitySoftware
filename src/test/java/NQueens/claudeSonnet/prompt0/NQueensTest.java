package NQueens.claudeSonnet.prompt0;

import org.junit.Test;

import NQueens.Nqueens;

import org.junit.Before;
import static org.junit.Assert.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class NQueensTest {
    private Nqueens nQueens;

    @Before
    public void setUp() {
        nQueens = new Nqueens();
    }

    @Test
    public void testSolveNQueensWithN1() {
        List<List<String>> result = nQueens.solveNQueens(1);
        assertEquals(1, result.size());
        assertEquals("Q", result.get(0).get(0));
    }

    @Test
    public void testSolveNQueensWithN4() {
        List<List<String>> result = nQueens.solveNQueens(4);
        assertEquals(2, result.size());
        
        // Known solutions for 4x4 board
        List<List<String>> expected = new ArrayList<>();
        expected.add(Arrays.asList(".Q..", "...Q", "Q...", "..Q."));
        expected.add(Arrays.asList("..Q.", "Q...", "...Q", ".Q.."));
        
        assertTrue(result.containsAll(expected));
        assertTrue(expected.containsAll(result));
    }

    @Test
    public void testSolveNQueensWithN2() {
        List<List<String>> result = nQueens.solveNQueens(2);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testSolveNQueensWithN3() {
        List<List<String>> result = nQueens.solveNQueens(3);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testValidBoardInitialPosition() {
        int[][] board = new int[4][4];
        board[0][1] = 1; // Place queen at (0,1)
        assertTrue(nQueens.validBoard(board, 0, 1));
    }

    @Test
    public void testValidBoardInvalidVertical() {
        int[][] board = new int[4][4];
        board[0][1] = 1;
        board[1][1] = 1; // Place queen directly below another queen
        assertFalse(nQueens.validBoard(board, 1, 1));
    }

    @Test
    public void testValidBoardInvalidDiagonalRight() {
        int[][] board = new int[4][4];
        board[0][0] = 1;
        board[1][1] = 1; // Place queen on right diagonal
        assertFalse(nQueens.validBoard(board, 1, 1));
    }

    @Test
    public void testValidBoardInvalidDiagonalLeft() {
        int[][] board = new int[4][4];
        board[0][2] = 1;
        board[1][1] = 1; // Place queen on left diagonal
        assertFalse(nQueens.validBoard(board, 1, 1));
    }

    @Test
    public void testPutBoard() {
        int[][] board = new int[2][2];
        board[0][0] = 1;
        board[1][1] = 1;
        List<List<String>> result = new ArrayList<>();
        
        nQueens.putBoard(board, result);
        
        assertEquals(1, result.size());
        assertEquals("Q.", result.get(0).get(0));
        assertEquals(".Q", result.get(0).get(1));
    }

    @Test
    public void testBoundaryConditions() {
        // Test edge columns
        int[][] board = new int[4][4];
        board[0][0] = 1; // Left edge
        assertTrue(nQueens.validBoard(board, 0, 0));
        
        board = new int[4][4];
        board[0][3] = 1; // Right edge
        assertTrue(nQueens.validBoard(board, 0, 3));
    }

    @Test
    public void testPutQueensRecursion() {
        int[][] board = new int[4][4];
        List<List<String>> result = new ArrayList<>();
        nQueens.putQueens(board, 0, result);
        
        // Should produce same result as solveNQueens(4)
        assertEquals(2, result.size());
    }
}