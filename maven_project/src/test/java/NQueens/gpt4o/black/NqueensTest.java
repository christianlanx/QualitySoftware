package NQueens.gpt4o.black;
import NQueens.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;
import java.util.ArrayList;

public class NqueensTest {

    private Nqueens nqueens;

    @BeforeEach
    public void setUp() {
        nqueens = new Nqueens();
    }

    @Test
    public void testSolveNQueensForNEquals1() {
        int n = 1;
        List<List<String>> expected = new ArrayList<>();
        List<String> solution = new ArrayList<>();
        solution.add("Q");
        expected.add(solution);

        List<List<String>> result = nqueens.solveNQueens(n);
        assertEquals(expected, result, "The solution for n=1 should be [[" + "\"Q\"" + "]]");
    }

    @Test
    public void testSolveNQueensForNEquals2() {
        int n = 2;
        List<List<String>> result = nqueens.solveNQueens(n);
        assertEquals(0, result.size(), "There should be no solutions for n=2");
    }

    @Test
    public void testSolveNQueensForNEquals3() {
        int n = 3;
        List<List<String>> result = nqueens.solveNQueens(n);
        assertEquals(0, result.size(), "There should be no solutions for n=3");
    }

    @Test
    public void testSolveNQueensForNEquals4() {
        int n = 4;
        List<List<String>> expected = new ArrayList<>();

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

        expected.add(solution1);
        expected.add(solution2);

        List<List<String>> result = nqueens.solveNQueens(n);

        // Since the order of solutions doesn't matter, we can simply compare their sizes
        assertEquals(expected.size(), result.size(), "There should be 2 solutions for n=4");
    }

    @Test
    public void testSolveNQueensForNEquals5() {
        int n = 5;
        List<List<String>> result = nqueens.solveNQueens(n);
        assertEquals(10, result.size(), "There should be 10 solutions for n=5");
    }

    @Test
    public void testSolveNQueensForNEquals8() {
        int n = 8;
        List<List<String>> result = nqueens.solveNQueens(n);
        assertEquals(92, result.size(), "There should be 92 solutions for n=8");
    }

    // Add more tests if needed for larger sizes like n = 6, 7, 9, etc.
}