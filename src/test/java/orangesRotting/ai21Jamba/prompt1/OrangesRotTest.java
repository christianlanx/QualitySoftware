package orangesRotting.ai21Jamba.prompt1;
import orangesRotting.OrangesRot;

import org.junit.Test;
import org.junit.Assert;

public class OrangesRotTest {

    @Test
    public void testExample1() {
        int[][] grid = {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
        };
        int expectedMinutes = 4;
        OrangesRot orangesRot = new OrangesRot();
        int actualMinutes = orangesRot.orangesRotting(grid);
        Assert.assertEquals(expectedMinutes, actualMinutes);
    }

    @Test
    public void testExample2() {
        int[][] grid = {
            {2, 1, 1},
            {0, 1, 1},
            {1, 0, 1}
        };
        int expectedMinutes = -1;
        OrangesRot orangesRot = new OrangesRot();
        int actualMinutes = orangesRot.orangesRotting(grid);
        Assert.assertEquals(expectedMinutes, actualMinutes);
    }

    @Test
    public void testExample3() {
        int[][] grid = {
            {0, 2}
        };
        int expectedMinutes = 0;
        OrangesRot orangesRot = new OrangesRot();
        int actualMinutes = orangesRot.orangesRotting(grid);
        Assert.assertEquals(expectedMinutes, actualMinutes);
    }

    @Test
    public void testAllOrangesRottenInitially() {
        int[][] grid = {
            {2, 2, 2},
            {2, 2, 2}
        };
        int expectedMinutes = 0;
        OrangesRot orangesRot = new OrangesRot();
        int actualMinutes = orangesRot.orangesRotting(grid);
        Assert.assertEquals(expectedMinutes, actualMinutes);
    }

    @Test
    public void testNoOranges() {
        int[][] grid = {
            {0, 0, 0},
            {0, 0, 0}
        };
        int expectedMinutes = 0;
        OrangesRot orangesRot = new OrangesRot();
        int actualMinutes = orangesRot.orangesRotting(grid);
        Assert.assertEquals(expectedMinutes, actualMinutes);
    }

    @Test
    public void testSingleFreshOrange() {
        int[][] grid = {
            {1}
        };
        int expectedMinutes = -1;
        OrangesRot orangesRot = new OrangesRot();
        int actualMinutes = orangesRot.orangesRotting(grid);
        Assert.assertEquals(expectedMinutes, actualMinutes);
    }

    @Test
    public void testSingleRottenOrange() {
        int[][] grid = {
            {2}
        };
        int expectedMinutes = 0;
        OrangesRot orangesRot = new OrangesRot();
        int actualMinutes = orangesRot.orangesRotting(grid);
        Assert.assertEquals(expectedMinutes, actualMinutes);
    }

    @Test
    public void testLargeGrid() {
        int[][] grid = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                grid[i][j] = 1;
            }
        }
        grid[5][5] = 2; // Single rotten orange in the middle
        int expectedMinutes = 20; // Maximum distance is 4, 5 steps to cover all
        OrangesRot orangesRot = new OrangesRot();
        int actualMinutes = orangesRot.orangesRotting(grid);
        Assert.assertEquals(expectedMinutes, actualMinutes);
    }
}