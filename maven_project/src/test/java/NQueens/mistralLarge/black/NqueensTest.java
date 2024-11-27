package NQueens.mistralLarge.black;
import NQueens.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class NqueensTest {

    @Test
    public void testSolveNQueensForNEquals4() {
        Nqueens nqueens = new Nqueens();
        List<List<String>> expected = Arrays.asList(
                Arrays.asList(".Q..", "...Q", "Q...", "..Q."),
                Arrays.asList("..Q.", "Q...", "...Q", ".Q..")
        );
        List<List<String>> result = nqueens.solveNQueens(4);
        assertTrue(result.containsAll(expected) && expected.containsAll(result));
    }

    @Test
    public void testSolveNQueensForNEquals1() {
        Nqueens nqueens = new Nqueens();
        List<List<String>> expected = Arrays.asList(
                Arrays.asList("Q")
        );
        List<List<String>> result = nqueens.solveNQueens(1);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource({
            "2, []",
            "3, []",
            "5, [[Q...., ..Q.., ....Q, .Q..., ...Q.], [Q...., ...Q., .Q..., ....Q, ..Q..], [.Q..., ....Q, ..Q.., Q...., ...Q.], [..Q.., Q...., ...Q., .Q..., ....Q]]",
            "6, [[Q....., .....Q., .Q...., ......, ....Q., ...Q..], [Q....., ....Q., ..Q..., ...Q.., .Q...., ......], [.Q...., ......, .....Q., ...Q.., Q....., ....Q.], [...Q.., Q....., ......, .Q...., .....Q., ....Q.]]"
    })
    public void testSolveNQueensForVariousN(int n, String expectedOutput) {
        Nqueens nqueens = new Nqueens();
        List<List<String>> result = nqueens.solveNQueens(n);

        if (expectedOutput.isEmpty()) {
            assertTrue(result.isEmpty());
        } else {
            List<List<String>> expected = parseExpectedOutput(expectedOutput);
            assertTrue(result.containsAll(expected) && expected.containsAll(result));
        }
    }

    private List<List<String>> parseExpectedOutput(String expectedOutput) {
        String[] solutions = expectedOutput.split("\\], \\[");
        List<List<String>> expected = Arrays.asList(solutions).stream()
                .map(solution -> Arrays.asList(solution.split(", ")))
                .toList();
        return expected;
    }
}