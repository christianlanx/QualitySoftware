package orangesRotting.claudeSonnet.prompt1;

import static org.junit.Assert.*;
import org.junit.Test;

import orangesRotting.OrangesRot;

import org.junit.Before;

public class orangesRottingclaudeSonnetTest {
    private OrangesRot solution;

    @Before
    public void setUp() {
        solution = new OrangesRot();
    }

    @Test
    public void testExample1() {
        int[][] grid = {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
        };
        assertEquals(4, solution.orangesRotting(grid));
    }

    @Test
    public void testExample2() {
        int[][] grid = {
            {2, 1, 1},
            {0, 1, 1},
            {1, 0, 1}
        };
        assertEquals(-1, solution.orangesRotting(grid));
    }

    @Test
    public void testExample3() {
        int[][] grid = {{0, 2}};
        assertEquals(0, solution.orangesRotting(grid));
    }

    @Test
    public void testEmptyGrid() {
        int[][] grid = {{0}};
        assertEquals(0, solution.orangesRotting(grid));
    }

    @Test
    public void testAllFreshOranges() {
        int[][] grid = {
            {1, 1},
            {1, 1}
        };
        assertEquals(-1, solution.orangesRotting(grid));
    }

    @Test
    public void testAllRottenOranges() {
        int[][] grid = {
            {2, 2},
            {2, 2}
        };
        assertEquals(0, solution.orangesRotting(grid));
    }

    @Test
    public void testMultipleRottenSources() {
        int[][] grid = {
            {2, 1, 2},
            {1, 1, 1},
            {2, 1, 2}
        };
        assertEquals(1, solution.orangesRotting(grid));
    }

    @Test
    public void testLongChainRotting() {
        int[][] grid = {
            {2, 1, 1, 1, 1},
            {0, 0, 0, 0, 1},
            {0, 0, 0, 0, 1}
        };
        assertEquals(7, solution.orangesRotting(grid));
    }

    @Test
    public void testIsolatedByEmptyCells() {
        int[][] grid = {
            {2, 0, 1},
            {0, 0, 1},
            {1, 0, 1}
        };
        assertEquals(-1, solution.orangesRotting(grid));
    }

    @Test
    public void testSingleRow() {
        int[][] grid = {
            {1, 2, 1, 1, 2, 1, 1}
        };
        assertEquals(2, solution.orangesRotting(grid));
    }

    @Test
    public void testSingleColumn() {
        int[][] grid = {
            {1},
            {2},
            {1},
            {1}
        };
        assertEquals(2, solution.orangesRotting(grid));
    }

    @Test
    public void testMaximumGridSize() {
        // Testing with 10x10 grid (maximum size according to constraints)
        int[][] grid = new int[10][10];
        // Fill with fresh oranges
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                grid[i][j] = 1;
            }
        }
        // Place a rotten orange in the corner
        grid[0][0] = 2;
        assertEquals(18, solution.orangesRotting(grid)); // Maximum time needed for corner-to-corner spread
    }

    @Test
    public void testNoFreshOranges() {
        int[][] grid = {
            {0, 2, 0},
            {0, 0, 2},
            {0, 0, 0}
        };
        assertEquals(0, solution.orangesRotting(grid));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidInput() {
        int[][] grid = {
            {2, 1, 3}, // 3 is an invalid value
            {1, 1, 0},
            {0, 1, 1}
        };
        solution.orangesRotting(grid);
    }
}