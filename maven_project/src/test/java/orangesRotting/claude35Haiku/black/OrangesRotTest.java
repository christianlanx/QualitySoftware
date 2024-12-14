package orangesRotting.claude35Haiku.black;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import orangesRotting.OrangesRot;

import static org.junit.jupiter.api.Assertions.*;

class OrangesRotTest {
    private OrangesRot orangesRot;

    @BeforeEach
    void setUp() {
        orangesRot = new OrangesRot();
    }

    @Test
    void testBasicRotting() {
        int[][] grid = {
            {2,1,1},
            {1,1,0},
            {0,1,1}
        };
        assertEquals(4, orangesRot.orangesRotting(grid));
    }

    @Test
    void testImpossibleRotting() {
        int[][] grid = {
            {2,1,1},
            {0,1,1},
            {1,0,1}
        };
        assertEquals(-1, orangesRot.orangesRotting(grid));
    }

    @Test
    void testNoFreshOranges() {
        int[][] grid = {{0,2}};
        assertEquals(0, orangesRot.orangesRotting(grid));
    }

    @Test
    void testSingleFreshOrange() {
        int[][] grid = {
            {2,0,1}
        };
        assertEquals(-1, orangesRot.orangesRotting(grid));
    }

    @Test
    void testAllRottingOranges() {
        int[][] grid = {
            {2,2,2},
            {2,2,2},
            {2,2,2}
        };
        assertEquals(0, orangesRot.orangesRotting(grid));
    }

    @Test
    void testAllEmptyCells() {
        int[][] grid = {
            {0,0,0},
            {0,0,0},
            {0,0,0}
        };
        assertEquals(0, orangesRot.orangesRotting(grid));
    }

    @Test
    void testLargeGrid() {
        int[][] grid = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                grid[i][j] = 1;
            }
        }
        grid[0][0] = 2;
        // Exact time might vary based on implementation, but should be finite
        assertTrue(orangesRot.orangesRotting(grid) > 0);
    }

    @Test
    void testNullGrid() {
        assertThrows(IllegalArgumentException.class, () -> {
            orangesRot.orangesRotting(null);
        });
    }

    @Test
    void testEmptyGrid() {
        int[][] grid = {};
        assertThrows(IllegalArgumentException.class, () -> {
            orangesRot.orangesRotting(grid);
        });
    }
}