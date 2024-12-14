package orangesRotting.ai21Jamba15Large.grey;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import orangesRotting.OrangesRot;

import java.util.Arrays;

public class OrangesRotTest {

    private OrangesRot orangesRot = new OrangesRot();

    @Test
    void testExample1() {
        int[][] grid = {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
        };
        int expected = 4;
        int actual = orangesRot.orangesRotting(grid);
        assertEquals(expected, actual);
    }

    @Test
    void testExample2() {
        int[][] grid = {
            {2, 1, 1},
            {0, 1, 1},
            {1, 0, 1}
        };
        int expected = -1;
        int actual = orangesRot.orangesRotting(grid);
        assertEquals(expected, actual);
    }

    @Test
    void testExample3() {
        int[][] grid = {
            {0, 2}
        };
        int expected = 0;
        int actual = orangesRot.orangesRotting(grid);
        assertEquals(expected, actual);
    }

    @Test
    void testEmptyGrid() {
        int[][] grid = {};
        int expected = -1;
        int actual = orangesRot.orangesRotting(grid);
        assertEquals(expected, actual);
    }

    @Test
    void testSingleCellGrid() {
        int[][] grid = {
            {1}
        };
        int expected = -1;
        int actual = orangesRot.orangesRotting(grid);
        assertEquals(expected, actual);
    }

    @Test
    void testFullGrid() {
        int[][] grid = {
            {2, 2, 2},
            {2, 2, 2},
            {2, 2, 2}
        };
        int expected = 0;
        int actual = orangesRot.orangesRotting(grid);
        assertEquals(expected, actual);
    }

    @Test
    void testNoFreshOranges() {
        int[][] grid = {
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
        };
        int expected = 0;
        int actual = orangesRot.orangesRotting(grid);
        assertEquals(expected, actual);
    }

    @Test
    void testNoRottenOranges() {
        int[][] grid = {
            {1, 1, 1},
            {1, 1, 1},
            {1, 1, 1}
        };
        int expected = -1;
        int actual = orangesRot.orangesRotting(grid);
        assertEquals(expected, actual);
    }

    @Test
    void testLargeGrid() {
        int[][] grid = new int[10][10];
        for (int i = 0; i < 10; i++) {
            Arrays.fill(grid[i], 1);
        }
        grid[0][0] = 2;
        int expected = 9;
        int actual = orangesRot.orangesRotting(grid);
        assertEquals(expected, actual);
    }

    @Test
    void testMixedGrid() {
        int[][] grid = {
            {2, 1, 1, 1, 1},
            {1, 2, 1, 1, 1},
            {1, 1, 2, 1, 1},
            {1, 1, 1, 2, 1},
            {1, 1, 1, 1, 2}
        };
        int expected = 5;
        int actual = orangesRot.orangesRotting(grid);
        assertEquals(expected, actual);
    }
}