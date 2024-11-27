package orangesRotting.claude35Sonnet.black;
import orangesRotting.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OrangesRotTest {

    private final OrangesRot solution = new OrangesRot();

    @Test
    void testNormalCase() {
        int[][] grid = {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
        };
        assertEquals(4, solution.orangesRotting(grid));
    }

    @Test
    void testImpossibleCase() {
        int[][] grid = {
            {2, 1, 1},
            {0, 1, 1},
            {1, 0, 1}
        };
        assertEquals(-1, solution.orangesRotting(grid));
    }

    @Test
    void testNoFreshOranges() {
        int[][] grid = {{0, 2}};
        assertEquals(0, solution.orangesRotting(grid));
    }

    @Test
    void testAllEmpty() {
        int[][] grid = {{0}};
        assertEquals(0, solution.orangesRotting(grid));
    }

    @Test
    void testSingleFreshOrange() {
        int[][] grid = {{1}};
        assertEquals(-1, solution.orangesRotting(grid));
    }

    @Test
    void testSingleRottenOrange() {
        int[][] grid = {{2}};
        assertEquals(0, solution.orangesRotting(grid));
    }

    @Test
    void testMultipleRottenSources() {
        int[][] grid = {
            {2, 1, 1},
            {1, 1, 1},
            {1, 1, 2}
        };
        assertEquals(2, solution.orangesRotting(grid));
    }

    @Test
    void testMaximumGridSize() {
        int[][] grid = new int[10][10];
        // Fill with fresh oranges
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                grid[i][j] = 1;
            }
        }
        // Place rotten orange in corner
        grid[0][0] = 2;
        assertEquals(18, solution.orangesRotting(grid));
    }

    @Test
    void testNullGrid() {
        assertThrows(NullPointerException.class, () -> solution.orangesRotting(null));
    }

    @Test
    void testEmptyGrid() {
        int[][] grid = {};
        assertThrows(IllegalArgumentException.class, () -> solution.orangesRotting(grid));
    }

    @Test
    void testInvalidValue() {
        int[][] grid = {{3}};
        assertThrows(IllegalArgumentException.class, () -> solution.orangesRotting(grid));
    }
}