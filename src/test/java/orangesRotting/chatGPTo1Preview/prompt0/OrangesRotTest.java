package orangesRotting.chatGPTo1Preview.prompt0;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;
import orangesRotting.OrangesRot;

public class OrangesRotTest {

    @Test
    public void testEmptyGrid() {
        OrangesRot orangesRot = new OrangesRot();
        int[][] grid = {};
        int expected = 0;
        int result = orangesRot.orangesRotting(grid);
        assertEquals(expected, result);
    }

    @Test
    public void testGridWithNoOranges() {
        OrangesRot orangesRot = new OrangesRot();
        int[][] grid = {
            {0, 0},
            {0, 0}
        };
        int expected = 0;
        int result = orangesRot.orangesRotting(grid);
        assertEquals(expected, result);
    }

    @Test
    public void testAllOrangesAlreadyRotten() {
        OrangesRot orangesRot = new OrangesRot();
        int[][] grid = {
            {2, 2},
            {2, 2}
        };
        int expected = 0;
        int result = orangesRot.orangesRotting(grid);
        assertEquals(expected, result);
    }

    @Test
    public void testAllOrangesWillRot() {
        OrangesRot orangesRot = new OrangesRot();
        int[][] grid = {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
        };
        int expected = 4;
        int result = orangesRot.orangesRotting(grid);
        assertEquals(expected, result);
    }

    @Test
    public void testImpossibleToRotAllOranges() {
        OrangesRot orangesRot = new OrangesRot();
        int[][] grid = {
            {2, 1, 1},
            {0, 1, 1},
            {1, 0, 1}
        };
        int expected = -1;
        int result = orangesRot.orangesRotting(grid);
        assertEquals(expected, result);
    }

    @Test
    public void testSingleFreshOrange() {
        OrangesRot orangesRot = new OrangesRot();
        int[][] grid = {
            {1}
        };
        int expected = -1;
        int result = orangesRot.orangesRotting(grid);
        assertEquals(expected, result);
    }

    @Test
    public void testSingleRottenOrange() {
        OrangesRot orangesRot = new OrangesRot();
        int[][] grid = {
            {2}
        };
        int expected = 0;
        int result = orangesRot.orangesRotting(grid);
        assertEquals(expected, result);
    }

    @Test
    public void testRottenOrangeWithAdjacentFreshOrange() {
        OrangesRot orangesRot = new OrangesRot();
        int[][] grid = {
            {2, 1}
        };
        int expected = 1;
        int result = orangesRot.orangesRotting(grid);
        assertEquals(expected, result);
    }

    @Test
    public void testRottenOrangeWithNonAdjacentFreshOrange() {
        OrangesRot orangesRot = new OrangesRot();
        int[][] grid = {
            {2, 0, 1}
        };
        int expected = -1;
        int result = orangesRot.orangesRotting(grid);
        assertEquals(expected, result);
    }

    @Test
    public void testMultipleRottenOranges() {
        OrangesRot orangesRot = new OrangesRot();
        int[][] grid = {
            {2, 1, 1},
            {1, 2, 0},
            {0, 1, 2}
        };
        int expected = 2;
        int result = orangesRot.orangesRotting(grid);
        assertEquals(expected, result);
    }

    @Test
    public void testLargeGridAllFresh() {
        OrangesRot orangesRot = new OrangesRot();
        int[][] grid = new int[10][10];
        for (int[] row : grid) {
            Arrays.fill(row, 1);
        }
        int expected = -1;
        int result = orangesRot.orangesRotting(grid);
        assertEquals(expected, result);
    }

    @Test
    public void testLargeGridAllRotten() {
        OrangesRot orangesRot = new OrangesRot();
        int[][] grid = new int[10][10];
        for (int[] row : grid) {
            Arrays.fill(row, 2);
        }
        int expected = 0;
        int result = orangesRot.orangesRotting(grid);
        assertEquals(expected, result);
    }

    @Test
    public void testLargeGridMixedOranges() {
        OrangesRot orangesRot = new OrangesRot();
        int[][] grid = new int[10][10];
        for (int i = 0; i < 10; i++) {
            Arrays.fill(grid[i], 1);
        }
        grid[0][0] = 2;
        int expected = 18;
        int result = orangesRot.orangesRotting(grid);
        assertEquals(expected, result);
    }

    @Test
    public void testGridWithObstacles() {
        OrangesRot orangesRot = new OrangesRot();
        int[][] grid = {
            {2, 1, 1},
            {1, 0, 1},
            {1, 1, 1}
        };
        int expected = 4;
        int result = orangesRot.orangesRotting(grid);
        assertEquals(expected, result);
    }
}

