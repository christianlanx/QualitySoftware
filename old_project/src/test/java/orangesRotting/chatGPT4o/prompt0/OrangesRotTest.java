package orangesRotting.chatGPT4o.prompt0;

import orangesRotting.OrangesRot;

import org.junit.Test;
import static org.junit.Assert.*;

public class OrangesRotTest {

    @Test
    public void testAllOrangesAlreadyRotted() {
        OrangesRot solution = new OrangesRot();
        int[][] grid = {
            {2, 2, 2},
            {2, 2, 2},
            {2, 2, 2}
        };
        int result = solution.orangesRotting(grid);
        assertEquals(0, result);
    }

    @Test
    public void testAllOrangesAreFresh() {
        OrangesRot solution = new OrangesRot();
        int[][] grid = {
            {1, 1, 1},
            {1, 1, 1},
            {1, 1, 1}
        };
        int result = solution.orangesRotting(grid);
        assertEquals(-1, result);
    }

    @Test
    public void testMixedOranges() {
        OrangesRot solution = new OrangesRot();
        int[][] grid = {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
        };
        int result = solution.orangesRotting(grid);
        assertEquals(4, result);
    }

    @Test
    public void testSingleFreshOrange() {
        OrangesRot solution = new OrangesRot();
        int[][] grid = {
            {1}
        };
        int result = solution.orangesRotting(grid);
        assertEquals(-1, result);
    }

    @Test
    public void testSingleRottedOrange() {
        OrangesRot solution = new OrangesRot();
        int[][] grid = {
            {2}
        };
        int result = solution.orangesRotting(grid);
        assertEquals(0, result);
    }

    @Test
    public void testEmptyGrid() {
        OrangesRot solution = new OrangesRot();
        int[][] grid = {};
        int result = solution.orangesRotting(grid);
        assertEquals(0, result);
    }

    @Test
    public void testFreshOrangesBlockedByEmptyCells() {
        OrangesRot solution = new OrangesRot();
        int[][] grid = {
            {2, 0, 1},
            {0, 0, 0},
            {1, 0, 1}
        };
        int result = solution.orangesRotting(grid);
        assertEquals(-1, result);
    }
    
    @Test
    public void testSomeOrangesCannotBeReached() {
        OrangesRot solution = new OrangesRot();
        int[][] grid = {
            {2, 1, 0},
            {0, 1, 0},
            {1, 0, 1}
        };
        int result = solution.orangesRotting(grid);
        assertEquals(-1, result);
    }
}

