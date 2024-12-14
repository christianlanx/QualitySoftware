package orangesRotting.gpto1Mini.black;

import orangesRotting.OrangesRot;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OrangesRotTest {

    @Test
    void testExample1() {
        OrangesRot orangesRot = new OrangesRot();
        int[][] grid = {
            {2,1,1},
            {1,1,0},
            {0,1,1}
        };
        int expected = 4;
        assertEquals(expected, orangesRot.orangesRotting(grid), "Example 1 Failed");
    }

    @Test
    void testExample2() {
        OrangesRot orangesRot = new OrangesRot();
        int[][] grid = {
            {2,1,1},
            {0,1,1},
            {1,0,1}
        };
        int expected = -1;
        assertEquals(expected, orangesRot.orangesRotting(grid), "Example 2 Failed");
    }

    @Test
    void testExample3() {
        OrangesRot orangesRot = new OrangesRot();
        int[][] grid = {
            {0,2}
        };
        int expected = 0;
        assertEquals(expected, orangesRot.orangesRotting(grid), "Example 3 Failed");
    }

    @Test
    void testAllRotten() {
        OrangesRot orangesRot = new OrangesRot();
        int[][] grid = {
            {2,2,2},
            {2,2,2},
            {2,2,2}
        };
        int expected = 0;
        assertEquals(expected, orangesRot.orangesRotting(grid), "All Rotten Failed");
    }

    @Test
    void testAllEmpty() {
        OrangesRot orangesRot = new OrangesRot();
        int[][] grid = {
            {0,0,0},
            {0,0,0},
            {0,0,0}
        };
        int expected = 0;
        assertEquals(expected, orangesRot.orangesRotting(grid), "All Empty Failed");
    }

    @Test
    void testSingleCellFresh() {
        OrangesRot orangesRot = new OrangesRot();
        int[][] grid = {
            {1}
        };
        int expected = -1;
        assertEquals(expected, orangesRot.orangesRotting(grid), "Single Fresh Cell Failed");
    }

    @Test
    void testSingleCellRotten() {
        OrangesRot orangesRot = new OrangesRot();
        int[][] grid = {
            {2}
        };
        int expected = 0;
        assertEquals(expected, orangesRot.orangesRotting(grid), "Single Rotten Cell Failed");
    }

    @Test
    void testMixedGridPossible() {
        OrangesRot orangesRot = new OrangesRot();
        int[][] grid = {
            {2,1,0,2,1},
            {1,0,1,2,1},
            {1,0,0,2,1}
        };
        int expected = 2;
        assertEquals(expected, orangesRot.orangesRotting(grid), "Mixed Grid Possible Failed");
    }

    @Test
    void testMixedGridImpossible() {
        OrangesRot orangesRot = new OrangesRot();
        int[][] grid = {
            {2,1,0,2,1},
            {0,0,1,2,1},
            {1,0,0,2,1}
        };
        int expected = -1;
        assertEquals(expected, orangesRot.orangesRotting(grid), "Mixed Grid Impossible Failed");
    }

    @Test
    void testNoFreshNoRotten() {
        OrangesRot orangesRot = new OrangesRot();
        int[][] grid = {
            {0,0},
            {0,0}
        };
        int expected = 0;
        assertEquals(expected, orangesRot.orangesRotting(grid), "No Fresh No Rotten Failed");
    }
}