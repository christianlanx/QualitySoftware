package orangesRotting.ai21Jamba15Large.black;
import orangesRotting.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrangesRotTest {

    @Test
    void testExample1() {
        int[][] grid = {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
        };
        int expectedMinutes = 4;
        OrangesRot orangesRot = new OrangesRot();
        assertEquals(expectedMinutes, orangesRot.orangesRotting(grid));
    }

    @Test
    void testExample2() {
        int[][] grid = {
            {2, 1, 1},
            {0, 1, 1},
            {1, 0, 1}
        };
        int expectedMinutes = -1;
        OrangesRot orangesRot = new OrangesRot();
        assertEquals(expectedMinutes, orangesRot.orangesRotting(grid));
    }

    @Test
    void testExample3() {
        int[][] grid = {
            {0, 2}
        };
        int expectedMinutes = 0;
        OrangesRot orangesRot = new OrangesRot();
        assertEquals(expectedMinutes, orangesRot.orangesRotting(grid));
    }

    @Test
    void testAllFreshOranges() {
        int[][] grid = {
            {1, 1, 1},
            {1, 1, 1},
            {1, 1, 1}
        };
        int expectedMinutes = -1;
        OrangesRot orangesRot = new OrangesRot();
        assertEquals(expectedMinutes, orangesRot.orangesRotting(grid));
    }

    @Test
    void testAllRottenOranges() {
        int[][] grid = {
            {2, 2, 2},
            {2, 2, 2},
            {2, 2, 2}
        };
        int expectedMinutes = 0;
        OrangesRot orangesRot = new OrangesRot();
        assertEquals(expectedMinutes, orangesRot.orangesRotting(grid));
    }

    @Test
    void testMixedOranges() {
        int[][] grid = {
            {2, 1, 0, 2, 1},
            {1, 0, 1, 2, 1},
            {1, 1, 1, 2, 2},
            {2, 1, 0, 0, 2},
            {1, 2, 1, 2, 2}
        };
        int expectedMinutes = 8;
        OrangesRot orangesRot = new OrangesRot();
        assertEquals(expectedMinutes, orangesRot.orangesRotting(grid));
    }

    @Test
    void testSingleFreshOrange() {
        int[][] grid = {
            {1}
        };
        int expectedMinutes = -1;
        OrangesRot orangesRot = new OrangesRot();
        assertEquals(expectedMinutes, orangesRot.orangesRotting(grid));
    }

    @Test
    void testSingleRottenOrange() {
        int[][] grid = {
            {2}
        };
        int expectedMinutes = 0;
        OrangesRot orangesRot = new OrangesRot();
        assertEquals(expectedMinutes, orangesRot.orangesRotting(grid));
    }

    @Test
    void testEmptyGrid() {
        int[][] grid = {};
        int expectedMinutes = -1;
        OrangesRot orangesRot = new OrangesRot();
        assertEquals(expectedMinutes, orangesRot.orangesRotting(grid));
    }
}