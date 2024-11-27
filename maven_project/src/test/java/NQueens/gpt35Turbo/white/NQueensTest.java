package NQueens.gpt35Turbo.white;
import NQueens.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NQueensTest {
    
    private Nqueens nQueens;

    @BeforeEach
    public void setUp() {
        nQueens = new Nqueens();
    }

    @Test
    public void testSolveNQueens() {
        // Test input n = 4
        List<List<String>> expectedOutput = new ArrayList<>();
        List<String> solution1 = new ArrayList<>();
        solution1.add(".Q..");
        solution1.add("...Q");
        solution1.add("Q...");
        solution1.add("..Q.");
        List<String> solution2 = new ArrayList<>();
        solution2.add("..Q.");
        solution2.add("Q...");
        solution2.add("...Q");
        solution2.add(".Q..");
        expectedOutput.add(solution1);
        expectedOutput.add(solution2);

        assertEquals(expectedOutput, nQueens.solveNQueens(4));
        
        // Add more test cases for different values of n
    }

    @Test
    public void testValidBoard() {
        int[][] board = {{0, 1, 0}, {0, 0, 0}, {0, 0, 0}};
        assertEquals(false, nQueens.validBoard(board, 1, 1));

        int[][] board2 = {{1, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        assertEquals(true, nQueens.validBoard(board2, 1, 0));
    }

    @Test
    public void testPutBoard() {
        List<List<String>> ret = new ArrayList<>();
        int[][] board = {{0, 1, 0}, {0, 0, 0}, {0, 0, 0}};
        nQueens.putBoard(board, ret);

        List<String> expectedBoard = new ArrayList<>();
        expectedBoard.add(".Q.");
        expectedBoard.add("...");
        expectedBoard.add("...");
        List<List<String>> expectedOutput = new ArrayList<>();
        expectedOutput.add(expectedBoard);

        assertEquals(expectedOutput, ret);
    }
}