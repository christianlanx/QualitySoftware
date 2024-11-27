package orangesRotting.metaAI.white;
import orangesRotting.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OrangesRotTest {

    private OrangesRot orangesRot = new OrangesRot();

    @Test
    public void testOrangesRotting_Example1() {
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        int expected = 4;
        int actual = orangesRot.orangesRotting(grid);
        assertEquals(expected, actual);
    }

    @Test
    public void testOrangesRotting_Example2() {
        int[][] grid = {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
        int expected = -1;
        int actual = orangesRot.orangesRotting(grid);
        assertEquals(expected, actual);
    }

    @Test
    public void testOrangesRotting_Example3() {
        int[][] grid = {{0, 2}};
        int expected = 0;
        int actual = orangesRot.orangesRotting(grid);
        assertEquals(expected, actual);
    }

    @Test
    public void testOrangesRotting_NoFreshOranges() {
        int[][] grid = {{2, 2}, {2, 2}};
        int expected = 0;
        int actual = orangesRot.orangesRotting(grid);
        assertEquals(expected, actual);
    }

    @Test
    public void testOrangesRotting_NoRottenOranges() {
        int[][] grid = {{1, 1}, {1, 1}};
        int expected = -1;
        int actual = orangesRot.orangesRotting(grid);
        assertEquals(expected, actual);
    }

    @Test
    public void testOrangesRotting_EmptyGrid() {
        int[][] grid = {};
        int expected = 0;
        int actual = orangesRot.orangesRotting(grid);
        assertEquals(expected, actual);
    }

    @Test
    public void testOrangesRotting_GridWithOnlyEmptyCells() {
        int[][] grid = {{0, 0}, {0, 0}};
        int expected = 0;
        int actual = orangesRot.orangesRotting(grid);
        assertEquals(expected, actual);
    }

    @Test
    public void testInBounds_InBounds() {
        int[][] grid = {{1, 2}, {3, 4}};
        boolean expected = true;
        boolean actual = orangesRot.inBounds(1, 1, grid);
        assertEquals(expected, actual);
    }

    @Test
    public void testInBounds_OutOfBounds() {
        int[][] grid = {{1, 2}, {3, 4}};
        boolean expected = false;
        boolean actual = orangesRot.inBounds(2, 2, grid);
        assertEquals(expected, actual);
    }

    @Test
    public void testInBounds_NegativeIndex() {
        int[][] grid = {{1, 2}, {3, 4}};
        boolean expected = false;
        boolean actual = orangesRot.inBounds(-1, 1, grid);
        assertEquals(expected, actual);
    }
}