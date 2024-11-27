package orangesRotting.claude35Haiku.white;
import orangesRotting.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OrangesRotTest {
    private OrangesRot orangesRot;

    @BeforeEach
    void setUp() {
        orangesRot = new OrangesRot();
    }

    @Test
    void testAllOrangesRotImmediately() {
        int[][] grid = {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
        };
        assertEquals(4, orangesRot.orangesRotting(grid));
    }

    @Test
    void testNoFreshOranges() {
        int[][] grid = {
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
        };
        assertEquals(0, orangesRot.orangesRotting(grid));
    }

    @Test
    void testNoRottenOranges() {
        int[][] grid = {
            {1, 1, 1},
            {1, 1, 1},
            {1, 1, 1}
        };
        assertEquals(-1, orangesRot.orangesRotting(grid));
    }

    @Test
    void testSomeOrangesCannotRot() {
        int[][] grid = {
            {2, 1, 1},
            {0, 1, 1},
            {1, 0, 1}
        };
        assertEquals(-1, orangesRot.orangesRotting(grid));
    }

    @Test
    void testSingleCellWithFreshOrange() {
        int[][] grid = {{1}};
        assertEquals(-1, orangesRot.orangesRotting(grid));
    }

    @Test
    void testSingleCellWithRottenOrange() {
        int[][] grid = {{2}};
        assertEquals(0, orangesRot.orangesRotting(grid));
    }

    @Test
    void testLargeGrid() {
        int[][] grid = {
            {2, 1, 1, 0, 0},
            {1, 1, 1, 2, 1},
            {1, 0, 1, 2, 1},
            {0, 1, 1, 1, 1},
            {1, 1, 1, 1, 2}
        };
        assertEquals(4, orangesRot.orangesRotting(grid));
    }

    @Test
    void testInBoundsMethod() {
        int[][] grid = {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
        };

        // Test valid bounds
        assertTrue(orangesRot.inBounds(1, 1, grid));

        // Test out of bounds
        assertFalse(orangesRot.inBounds(-1, 0, grid));
        assertFalse(orangesRot.inBounds(0, 3, grid));
        assertFalse(orangesRot.inBounds(3, 0, grid));
    }
}