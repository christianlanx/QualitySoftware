package orangesRotting.gpto1Mini.black;
import orangesRotting.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OrangesRotTest {

    @Test
    void testExample1() {
        OrangesRot or = new OrangesRot();
        int[][] grid = {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
        };
        assertEquals(4, or.orangesRotting(grid), "Example 1 should return 4");
    }

    @Test
    void testExample2() {
        OrangesRot or = new OrangesRot();
        int[][] grid = {
            {2, 1, 1},
            {0, 1, 1},
            {1, 0, 1}
        };
        assertEquals(-1, or.orangesRotting(grid), "Example 2 should return -1");
    }

    @Test
    void testExample3() {
        OrangesRot or = new OrangesRot();
        int[][] grid = {
            {0, 2}
        };
        assertEquals(0, or.orangesRotting(grid), "Example 3 should return 0");
    }

    @Test
    void testAllEmpty() {
        OrangesRot or = new OrangesRot();
        int[][] grid = {
            {0, 0},
            {0, 0}
        };
        assertEquals(0, or.orangesRotting(grid), "All cells empty should return 0");
    }

    @Test
    void testAllFresh() {
        OrangesRot or = new OrangesRot();
        int[][] grid = {
            {1, 1},
            {1, 1}
        };
        assertEquals(-1, or.orangesRotting(grid), "All cells fresh should return -1");
    }

    @Test
    void testAllRotten() {
        OrangesRot or = new OrangesRot();
        int[][] grid = {
            {2, 2},
            {2, 2}
        };
        assertEquals(0, or.orangesRotting(grid), "All cells rotten should return 0");
    }

    @Test
    void testSingleFresh() {
        OrangesRot or = new OrangesRot();
        int[][] grid = {
            {1}
        };
        assertEquals(-1, or.orangesRotting(grid), "Single fresh cell should return -1");
    }

    @Test
    void testSingleRotten() {
        OrangesRot or = new OrangesRot();
        int[][] grid = {
            {2}
        };
        assertEquals(0, or.orangesRotting(grid), "Single rotten cell should return 0");
    }

    @Test
    void testTwoByTwoWithOneRotten() {
        OrangesRot or = new OrangesRot();
        int[][] grid = {
            {2, 1},
            {1, 1}
        };
        assertEquals(2, or.orangesRotting(grid), "2x2 grid with one rotten should return 2");
    }

    @Test
    void testLargerGrid() {
        OrangesRot or = new OrangesRot();
        int[][] grid = {
            {2,1,1,0,1,1,2,1,0,1},
            {1,0,1,1,1,0,1,1,1,1},
            {1,1,0,1,1,1,0,1,1,1},
            {0,1,1,1,0,1,1,1,0,1},
            {1,1,1,0,1,1,1,0,1,1},
            {1,0,1,1,1,1,0,1,1,0},
            {2,1,1,1,1,0,1,1,1,1},
            {1,1,0,1,0,1,1,0,1,1},
            {0,1,1,1,1,1,1,1,1,0},
            {1,0,1,1,0,1,1,1,0,1}
        };
        int result = or.orangesRotting(grid);
        assertTrue(result >= 0, "Larger grid should return a non-negative number of minutes");
    }
}