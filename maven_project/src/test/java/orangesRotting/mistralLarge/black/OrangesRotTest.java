package orangesRotting.mistralLarge.black;
import orangesRotting.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OrangesRotTest {

    @Test
    public void testExample1() {
        OrangesRot orangesRot = new OrangesRot();
        int[][] grid = {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
        };
        int result = orangesRot.orangesRotting(grid);
        assertEquals(4, result);
    }

    @Test
    public void testExample2() {
        OrangesRot orangesRot = new OrangesRot();
        int[][] grid = {
            {2, 1, 1},
            {0, 1, 1},
            {1, 0, 1}
        };
        int result = orangesRot.orangesRotting(grid);
        assertEquals(-1, result);
    }

    @Test
    public void testExample3() {
        OrangesRot orangesRot = new OrangesRot();
        int[][] grid = {
            {0, 2}
        };
        int result = orangesRot.orangesRotting(grid);
        assertEquals(0, result);
    }

    @Test
    public void testNoFreshOranges() {
        OrangesRot orangesRot = new OrangesRot();
        int[][] grid = {
            {2, 2, 2},
            {2, 2, 2},
            {2, 2, 2}
        };
        int result = orangesRot.orangesRotting(grid);
        assertEquals(0, result);
    }

    @Test
    public void testAllEmpty() {
        OrangesRot orangesRot = new OrangesRot();
        int[][] grid = {
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
        };
        int result = orangesRot.orangesRotting(grid);
        assertEquals(0, result);
    }

    @Test
    public void testSingleCellFresh() {
        OrangesRot orangesRot = new OrangesRot();
        int[][] grid = {
            {1}
        };
        int result = orangesRot.orangesRotting(grid);
        assertEquals(-1, result);
    }

    @Test
    public void testSingleCellRotten() {
        OrangesRot orangesRot = new OrangesRot();
        int[][] grid = {
            {2}
        };
        int result = orangesRot.orangesRotting(grid);
        assertEquals(0, result);
    }

    @Test
    public void testSingleCellEmpty() {
        OrangesRot orangesRot = new OrangesRot();
        int[][] grid = {
            {0}
        };
        int result = orangesRot.orangesRotting(grid);
        assertEquals(0, result);
    }

    @Test
    public void testMixedGrid() {
        OrangesRot orangesRot = new OrangesRot();
        int[][] grid = {
            {2, 1, 0},
            {1, 0, 1},
            {0, 1, 2}
        };
        int result = orangesRot.orangesRotting(grid);
        assertEquals(2, result);
    }
}