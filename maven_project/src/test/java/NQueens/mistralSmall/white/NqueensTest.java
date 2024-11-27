package NQueens.mistralSmall.white;
import NQueens.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class NqueensTest {

    private final Nqueens nqueens = new Nqueens();

    @Test
    void testSolveNQueens_1() {
        List<List<String>> result = nqueens.solveNQueens(1);
        List<String> expected = List.of(List.of("Q"));
        assertEquals(1, result.size());
        assertEquals(expected, result.get(0));
    }

    @Test
    void testSolveNQueens_2() {
        List<List<String>> result = nqueens.solveNQueens(2);
        List<String> expected1 = List.of(List.of(".", "Q"), List.of("Q", "."));
        List<String> expected2 = List.of(List.of("Q", "."), List.of(".", "Q"));
        assertEquals(2, result.size());
        assertTrue(result.contains(expected1) || result.contains(expected2));
    }

    @Test
    void testSolveNQueens_3() {
        List<List<String>> result = nqueens.solveNQueens(3);
        List<String> expected1 = List.of(List.of(".", ".", "Q"), List.of("Q", ".", "."), List.of(".", "Q", "."));
        List<String> expected2 = List.of(List.of("Q", ".", "."), List.of(".", "Q", "."), List.of(".", ".", "Q"));
        List<String> expected3 = List.of(List.of(".", "Q", "."), List.of(".", ".", "Q"), List.of("Q", ".", "."));
        assertEquals(3, result.size());
        assertTrue(result.contains(expected1) || result.contains(expected2) || result.contains(expected3));
    }

    @Test
    void testSolveNQueens_4() {
        List<List<String>> result = nqueens.solveNQueens(4);
        List<String> expected1 = List.of(List.of(".", ".", ".", "Q"), List.of(".", ".", "Q", "."), List.of(".", "Q", ".", "."), List.of("Q", ".", ".", "."));
        List<String> expected2 = List.of(List.of(".", ".", "Q", "."), List.of(".", "Q", ".", "."), List.of("Q", ".", ".", "."), List.of(".", ".", ".", "Q"));
        List<String> expected3 = List.of(List.of(".", "Q", ".", "."), List.of("Q", ".", ".", "."), List.of(".", ".", ".", "Q"), List.of(".", ".", "Q", "."));
        List<String> expected4 = List.of(List.of("Q", ".", ".", "."), List.of(".", ".", ".", "Q"), List.of(".", ".", "Q", "."), List.of(".", "Q", ".", "."));
        assertEquals(4, result.size());
        assertTrue(result.contains(expected1) || result.contains(expected2) || result.contains(expected3) || result.contains(expected4));
    }

    @Test
    void testSolveNQueens_0() {
        List<List<String>> result = nqueens.solveNQueens(0);
        assertEquals(0, result.size());
    }

    @Test
    void testSolveNQueens_5() {
        List<List<String>> result = nqueens.solveNQueens(5);
        assertEquals(10, result.size()); // There should be 10 valid solutions for 5 queens
    }
}