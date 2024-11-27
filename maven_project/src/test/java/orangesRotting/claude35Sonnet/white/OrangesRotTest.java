package orangesRotting.claude35Sonnet.white;
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
    void testEmptyGrid() {
        int[][] grid = new int[][]{};
        assertEquals(0, orangesRot.orangesRotting(grid));
    }

    @Test
    void testGridWithNoOranges() {
        int[][] grid = new int[][]{{0, 0}, {0, 0}};
        assertEquals(0, orangesRot.orangesRotting(grid));
    }

    @Test
    void testGridWithOnlyRottenOranges() {
        int[][] grid = new int[][]{{2, 2}, {2, 2}};
        assertEquals(0, orangesRot.orangesRotting(grid));
    }

    @Test
    void testImpossibleToRotAll() {
        int[][] grid = new int[][]{{2, 1, 0}, {0, 1, 0}, {1, 0, 1}};
        assertEquals(-1, orangesRot.orangesRotting(grid));
    }

    @Test
    void testNormalCase() {
        int[][] grid = new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        assertEquals(4, orangesRot.orangesRotting(grid));
    }

    @Test
    void testSingleOrange() {
        int[][] grid = new int[][]{{1}};
        assertEquals(-1, orangesRot.orangesRotting(grid));
    }

    @Test
    void testSingleRottenOrange() {
        int[][] grid = new int[][]{{2}};
        assertEquals(0, orangesRot.orangesRotting(grid));
    }

    @Test
    void testInstantRotting() {
        int[][] grid = new int[][]{{2, 1}, {1, 2}};
        assertEquals(1, orangesRot.orangesRotting(grid));
    }

    @Test
    void testInBounds() {
        int[][] grid = new int[][]{{1, 1}, {1, 1}};
        assertTrue(orangesRot.inBounds(0, 0, grid));
        assertTrue(orangesRot.inBounds(1, 1, grid));
        assertFalse(orangesRot.inBounds(-1, 0, grid));
        assertFalse(orangesRot.inBounds(0, -1, grid));
        assertFalse(orangesRot.inBounds(2, 0, grid));
        assertFalse(orangesRot.inBounds(0, 2, grid));
    }

    @Test
    void testGridWithOnlyFreshOranges() {
        int[][] grid = new int[][]{{1, 1}, {1, 1}};
        assertEquals(-1, orangesRot.orangesRotting(grid));
    }
}