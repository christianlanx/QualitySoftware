package orangesRotting.claudeSonnet.prompt0;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import orangesRotting.OrangesRot;

public class orangesRottingTestClaude35Sonnet {
    private OrangesRot solution;

    @Before
    public void setUp() {
        solution = new OrangesRot();
    }

    @Test
    public void testEmptyGrid() {
        int[][] grid = new int[][]{};
        assertEquals(0, solution.orangesRotting(grid));
    }

    @Test
    public void testSingleElementNoOrange() {
        int[][] grid = new int[][]{{0}};
        assertEquals(0, solution.orangesRotting(grid));
    }

    @Test
    public void testSingleElementFreshOrange() {
        int[][] grid = new int[][]{{1}};
        assertEquals(-1, solution.orangesRotting(grid));
    }

    @Test
    public void testSingleElementRottenOrange() {
        int[][] grid = new int[][]{{2}};
        assertEquals(0, solution.orangesRotting(grid));
    }

    @Test
    public void testAllRottenOranges() {
        int[][] grid = new int[][]{
            {2, 2, 2},
            {2, 2, 2},
            {2, 2, 2}
        };
        assertEquals(0, solution.orangesRotting(grid));
    }

    @Test
    public void testNoOranges() {
        int[][] grid = new int[][]{
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
        };
        assertEquals(0, solution.orangesRotting(grid));
    }

    @Test
    public void testImpossibleToRotAll() {
        int[][] grid = new int[][]{
            {2, 0, 1},
            {0, 0, 1},
            {1, 0, 1}
        };
        assertEquals(-1, solution.orangesRotting(grid));
    }

    @Test
    public void testNormalCase() {
        int[][] grid = new int[][]{
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
        };
        assertEquals(4, solution.orangesRotting(grid));
    }

    @Test
    public void testMultipleRottenSources() {
        int[][] grid = new int[][]{
            {2, 1, 1},
            {1, 1, 1},
            {1, 1, 2}
        };
        assertEquals(2, solution.orangesRotting(grid));
    }

    @Test
    public void testOneMinuteToRot() {
        int[][] grid = new int[][]{
            {2, 1},
            {1, 1}
        };
        assertEquals(1, solution.orangesRotting(grid));
    }

    // Testing inBounds method
    @Test
    public void testInBoundsValid() {
        int[][] grid = new int[][]{{1, 1}, {1, 1}};
        assertTrue(solution.inBounds(0, 0, grid));
        assertTrue(solution.inBounds(1, 1, grid));
    }

    @Test
    public void testInBoundsInvalid() {
        int[][] grid = new int[][]{{1, 1}, {1, 1}};
        assertFalse(solution.inBounds(-1, 0, grid));
        assertFalse(solution.inBounds(0, -1, grid));
        assertFalse(solution.inBounds(2, 0, grid));
        assertFalse(solution.inBounds(0, 2, grid));
    }
}