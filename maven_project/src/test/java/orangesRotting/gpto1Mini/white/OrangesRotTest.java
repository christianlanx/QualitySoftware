package orangesRotting.gpto1Mini.white;
import orangesRotting.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OrangesRotTest {

    private final OrangesRot orangesRot = new OrangesRot();

    @Test
    void testAllOrangesRotten() {
        int[][] grid = {
            {2, 2, 2},
            {2, 2, 2},
            {2, 2, 2}
        };
        assertEquals(0, orangesRot.orangesRotting(grid));
    }

    @Test
    void testNoOranges() {
        int[][] grid = {
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
        };
        assertEquals(0, orangesRot.orangesRotting(grid));
    }

    @Test
    void testAllOrangesFresh() {
        int[][] grid = {
            {1, 1, 1},
            {1, 1, 1},
            {1, 1, 1}
        };
        assertEquals(-1, orangesRot.orangesRotting(grid));
    }

    @Test
    void testMixedOrangesFullyRotten() {
        int[][] grid = {
            {2, 1, 0},
            {1, 1, 0},
            {0, 1, 2}
        };
        assertEquals(2, orangesRot.orangesRotting(grid));
    }

    @Test
    void testMixedOrangesNotFullyRotten() {
        int[][] grid = {
            {2, 1, 1},
            {0, 1, 1},
            {1, 0, 1}
        };
        assertEquals(-1, orangesRot.orangesRotting(grid));
    }

    @Test
    void testSingleRowAllRotten() {
        int[][] grid = {
            {2, 2, 2, 2}
        };
        assertEquals(0, orangesRot.orangesRotting(grid));
    }

    @Test
    void testSingleRowWithFreshOranges() {
        int[][] grid = {
            {2, 1, 1, 0, 1}
        };
        assertEquals(2, orangesRot.orangesRotting(grid));
    }

    @Test
    void testSingleColumnAllRotten() {
        int[][] grid = {
            {2},
            {2},
            {2},
            {2}
        };
        assertEquals(0, orangesRot.orangesRotting(grid));
    }

    @Test
    void testSingleColumnWithFreshOranges() {
        int[][] grid = {
            {2},
            {1},
            {1},
            {0},
            {1}
        };
        assertEquals(2, orangesRot.orangesRotting(grid));
    }

    @Test
    void testEmptyGrid() {
        int[][] grid = {};
        assertEquals(0, orangesRot.orangesRotting(grid));
    }

    @Test
    void testGridWithNoRottenOrangesButHasFresh() {
        int[][] grid = {
            {1, 1, 1},
            {1, 1, 1},
            {1, 1, 1}
        };
        assertEquals(-1, orangesRot.orangesRotting(grid));
    }

    @Test
    void testGridWithMultipleRottingSources() {
        int[][] grid = {
            {2, 1, 1, 0, 2},
            {1, 1, 0, 1, 1},
            {0, 1, 1, 1, 0},
            {2, 0, 1, 1, 2}
        };
        assertEquals(3, orangesRot.orangesRotting(grid));
    }

    @Test
    void testGridWithIsolatedFreshOrange() {
        int[][] grid = {
            {2, 1, 0},
            {0, 1, 0},
            {0, 0, 1}
        };
        assertEquals(-1, orangesRot.orangesRotting(grid));
    }

    @Test
    void testGridWithImmediateAllRotten() {
        int[][] grid = {
            {2, 0, 2},
            {0, 2, 0},
            {2, 0, 2}
        };
        assertEquals(0, orangesRot.orangesRotting(grid));
    }

    @Test
    void testLargeGrid() {
        int[][] grid = new int[10][10];
        for(int[] row : grid) {
            for(int j = 0; j < grid[0].length; j++) {
                row[j] = 1;
            }
        }
        grid[0][0] = 2;
        grid[9][9] = 2;
        int expectedMinutes = 9;
        assertEquals(expectedMinutes, orangesRot.orangesRotting(grid));
    }
}