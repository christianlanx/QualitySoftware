package orangesRotting.copilot.prompt1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import orangesRotting.OrangesRot;

public class orangesRottingcopilotTest {

    @Test
    public void testOrangesRotting_Example1() {
        OrangesRot solution = new OrangesRot();
        int[][] grid = {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
        };
        int expected = 4;
        int result = solution.orangesRotting(grid);
        assertEquals(expected, result);
    }

    @Test
    public void testOrangesRotting_Example2() {
        OrangesRot solution = new OrangesRot();
        int[][] grid = {
            {2, 1, 1},
            {0, 1, 1},
            {1, 0, 1}
        };
        int expected = -1;
        int result = solution.orangesRotting(grid);
        assertEquals(expected, result);
    }

    @Test
    public void testOrangesRotting_Example3() {
        OrangesRot solution = new OrangesRot();
        int[][] grid = {
            {0, 2}
        };
        int expected = 0;
        int result = solution.orangesRotting(grid);
        assertEquals(expected, result);
    }

    @Test
    public void testOrangesRotting_AllRotten() {
        OrangesRot solution = new OrangesRot();
        int[][] grid = {
            {2, 2, 2},
            {2, 2, 2},
            {2, 2, 2}
        };
        int expected = 0;
        int result = solution.orangesRotting(grid);
        assertEquals(expected, result);
    }

    @Test
    public void testOrangesRotting_AllFresh() {
        OrangesRot solution = new OrangesRot();
        int[][] grid = {
            {1, 1, 1},
            {1, 1, 1},
            {1, 1, 1}
        };
        int expected = -1;
        int result = solution.orangesRotting(grid);
        assertEquals(expected, result);
    }

    @Test
    public void testOrangesRotting_Mixed() {
        OrangesRot solution = new OrangesRot();
        int[][] grid = {
            {0, 1, 2},
            {2, 1, 1},
            {0, 1, 0}
        };
        int expected = 2;
        int result = solution.orangesRotting(grid);
        assertEquals(expected, result);
    }
}
