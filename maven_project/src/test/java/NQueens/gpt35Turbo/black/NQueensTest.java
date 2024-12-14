package NQueens.gpt35Turbo.black;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import NQueens.Nqueens;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

@DisplayName("NQueens Test")
public class NQueensTest {

    private Nqueens nqueens;

    @BeforeEach
    public void setUp() {
        nqueens = new Nqueens();
    }

    @Test
    @DisplayName("Test solveNQueens with n = 4")
    public void testSolveNQueensN4() {
        List<List<String>> expected = List.of(
                List.of(".Q..", "...Q", "Q...", "..Q."),
                List.of("..Q.", "Q...", "...Q", ".Q..")
        );
        assertEquals(expected, nqueens.solveNQueens(4));
    }

    @Test
    @DisplayName("Test solveNQueens with n = 1")
    public void testSolveNQueensN1() {
        List<List<String>> expected = List.of(List.of("Q"));
        assertEquals(expected, nqueens.solveNQueens(1));
    }
}