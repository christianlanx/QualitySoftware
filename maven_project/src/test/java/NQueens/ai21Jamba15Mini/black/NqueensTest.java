package NQueens.ai21Jamba15Mini.black;
import NQueens.*;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class NqueensTest {

    @Test
    void testEmptyBoard() {
        Nqueens nqueens = new Nqueens();
        List<List<String>> result = nqueens.solveNQueens(0);
        // Assert that an empty board results in an empty list
        assertTrue(result.isEmpty());
    }

    @Test
    void testSingleQueen() {
        Nqueens nqueens = new Nqueens();
        List<List<String>> result = nqueens.solveNQueens(1);
        // Assert that the expected solution is returned
        assertEquals(1, result.size());
        assertEquals(List.of("Q"), result.get(0));
    }

    @Test
    void testFourQueens() {
        Nqueens nqueens = new Nqueens();
        List<List<String>> result = nqueens.solveNQueens(4);
        // Assert that the expected number of solutions is returned
        // (You'll need to verify the expected number of solutions for n=4)
        assertTrue(result.size() >= 2); // At least 2 solutions exist for n=4
    }

    // Add more test cases for different values of n
    // Consider edge cases like n=1, n=2, and larger values of n

}