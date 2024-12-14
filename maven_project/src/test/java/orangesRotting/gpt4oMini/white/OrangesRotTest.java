package orangesRotting.gpt4oMini.white;

import org.junit.jupiter.api.Test;

import orangesRotting.OrangesRot;

import static org.junit.jupiter.api.Assertions.*;

class OrangesRotTest {

    private final OrangesRot orangesRot = new OrangesRot();

    @Test
    void testEmptyGrid() {
        int[][] grid = {};
        assertEquals(0, orangesRot.orangesRotting(grid));
    }

    @Test
    void testAllRottenOranges() {
        int[][] grid = {{2, 2}, {2, 2}};
        assertEquals(0, orangesRot.orangesRotting(grid));
    }

    @Test
    void testNoFreshOranges() {
        int[][] grid = {{0, 0}, {0, 0}};
        assertEquals(0, orangesRot.orangesRotting(grid));
    }

    @Test
    void testFreshOrangesBecomeRotten() {
        int[][] grid = {{1, 2, 1}, {0, 1, 0}, {1, 1, 1}};
        assertEquals(2, orangesRot.orangesRotting(grid));
    }

    @Test
    void testIsolatedFreshOranges() {
        int[][] grid = {{1, 0, 1}, {0, 2, 0}, {1, 0, 1}};
        assertEquals(-1, orangesRot.orangesRotting(grid));
    }

    @Test
    void testAllFreshOrangesNoRotten() {
        int[][] grid = {{1, 1}, {1, 1}};
        assertEquals(-1, orangesRot.orangesRotting(grid));
    }

    @Test
    void testMixedGrid() {
        int[][] grid = {{2, 1, 0}, {1, 1, 1}, {0, 1, 2}};
        assertEquals(1, orangesRot.orangesRotting(grid));
    }

    @Test
    void testComplexGrid() {
        int[][] grid = {{0, 2, 1}, {1, 1, 0}, {2, 0, 1}};
        assertEquals(2, orangesRot.orangesRotting(grid));
    }

    @Test
    void testBoundaryConditions() {
        int[][] grid = {{1, 0}, {0, 1}};
        assertEquals(-1, orangesRot.orangesRotting(grid));
    }

    @Test
    void testSingleCellRotten() {
        int[][] grid = {{2}};
        assertEquals(0, orangesRot.orangesRotting(grid));
    }

    @Test
    void testSingleCellFresh() {
        int[][] grid = {{1}};
        assertEquals(-1, orangesRot.orangesRotting(grid));
    }
}