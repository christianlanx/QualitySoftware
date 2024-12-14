package orangesRotting.gpto1Mini.grey;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import orangesRotting.OrangesRot;

public class OrangesRotTest {

    @Test
    void testExample1() {
        OrangesRot orangesRot = new OrangesRot();
        int[][] grid = {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
        };
        int expected = 4;
        assertEquals(expected, orangesRot.orangesRotting(grid));
    }

    @Test
    void testExample2() {
        OrangesRot orangesRot = new OrangesRot();
        int[][] grid = {
            {2, 1, 1},
            {0, 1, 1},
            {1, 0, 1}
        };
        int expected = -1;
        assertEquals(expected, orangesRot.orangesRotting(grid));
    }

    @Test
    void testExample3() {
        OrangesRot orangesRot = new OrangesRot();
        int[][] grid = {
            {0, 2}
        };
        int expected = 0;
        assertEquals(expected, orangesRot.orangesRotting(grid));
    }

    @Test
    void testAllEmpty() {
        OrangesRot orangesRot = new OrangesRot();
        int[][] grid = {
            {0, 0},
            {0, 0}
        };
        int expected = 0;
        assertEquals(expected, orangesRot.orangesRotting(grid));
    }

    @Test
    void testAllFresh() {
        OrangesRot orangesRot = new OrangesRot();
        int[][] grid = {
            {1, 1},
            {1, 1}
        };
        int expected = -1;
        assertEquals(expected, orangesRot.orangesRotting(grid));
    }

    @Test
    void testAllRotten() {
        OrangesRot orangesRot = new OrangesRot();
        int[][] grid = {
            {2, 2},
            {2, 2}
        };
        int expected = 0;
        assertEquals(expected, orangesRot.orangesRotting(grid));
    }

    @Test
    void testSingleFresh() {
        OrangesRot orangesRot = new OrangesRot();
        int[][] grid = {
            {1}
        };
        int expected = -1;
        assertEquals(expected, orangesRot.orangesRotting(grid));
    }

    @Test
    void testSingleRotten() {
        OrangesRot orangesRot = new OrangesRot();
        int[][] grid = {
            {2}
        };
        int expected = 0;
        assertEquals(expected, orangesRot.orangesRotting(grid));
    }

    @Test
    void testMixedCase() {
        OrangesRot orangesRot = new OrangesRot();
        int[][] grid = {
            {2, 1, 0, 2, 1},
            {1, 0, 1, 2, 1},
            {1, 0, 0, 2, 1}
        };
        int expected = 2;
        assertEquals(expected, orangesRot.orangesRotting(grid));
    }
}