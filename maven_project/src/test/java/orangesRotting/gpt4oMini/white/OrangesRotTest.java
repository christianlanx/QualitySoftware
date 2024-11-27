package orangesRotting.gpt4oMini.white;
import orangesRotting.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class OrangesRotTest {

    OrangesRot orangesRot = new OrangesRot();

    @Test
    public void testEmptyGrid() {
        int[][] grid = {};
        assertEquals(0, orangesRot.orangesRotting(grid));
    }

    @Test
    public void testAllFreshOranges() {
        int[][] grid = {{1, 1}, {1, 1}};
        assertEquals(-1, orangesRot.orangesRotting(grid));
    }

    @Test
    public void testAllRottenOranges() {
        int[][] grid = {{2, 2}, {2, 2}};
        assertEquals(0, orangesRot.orangesRotting(grid));
    }

    @Test
    public void testRottenAdjacentToFresh() {
        int[][] grid = {{2, 1, 1}, {1, 1, 1}, {0, 2, 0}};
        assertEquals(2, orangesRot.orangesRotting(grid));
    }

    @Test
    public void testIsolatedFreshOrange() {
        int[][] grid = {{2, 1, 0}, {0, 1, 1}, {0, 0, 1}};
        assertEquals(-1, orangesRot.orangesRotting(grid));
    }

    @Test
    public void testMixedGridRotting() {
        int[][] grid = {{2, 1, 0}, {0, 1, 2}, {1, 0, 1}};
        assertEquals(1, orangesRot.orangesRotting(grid));
    }

    @Test
    public void testAdjacentFreshAboveAndBelowRotten() {
        int[][] grid = {{0, 2, 0}, {1, 1, 1}, {0, 2, 0}};
        assertEquals(1, orangesRot.orangesRotting(grid));
    }

    @Test
    public void testAllZeroes() {
        int[][] grid = {{0, 0, 0}, {0, 0, 0}};
        assertEquals(0, orangesRot.orangesRotting(grid));
    }

    @Test
    public void testSingleOrangeRotting() {
        int[][] grid = {{0, 1, 0}, {2, 0, 0}, {0, 0, 0}};
        assertEquals(0, orangesRot.orangesRotting(grid));
    }

    @Test
    public void testSingleRowWithRotting() {
        int[][] grid = {{1, 2, 1, 1}, {0, 0, 0, 0}};
        assertEquals(1, orangesRot.orangesRotting(grid));
    }
}