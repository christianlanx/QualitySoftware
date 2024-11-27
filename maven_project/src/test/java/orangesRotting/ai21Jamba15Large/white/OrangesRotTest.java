package orangesRotting.ai21Jamba15Large.white;
import orangesRotting.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.jupiter.api.Test;

public class OrangesRotTest {

    private OrangesRot orangesRot = new OrangesRot();

    @Test
    void testOrangesRottingWithEmptyGrid() {
        int[][] grid = {};
        int expected = 0;
        assertEquals(expected, orangesRot.orangesRotting(grid));
    }

    @Test
    void testOrangesRottingWithNoOranges() {
        int[][] grid = {
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
        };
        int expected = 0;
        assertEquals(expected, orangesRot.orangesRotting(grid));
    }

    @Test
    void testOrangesRottingWithAllFreshOranges() {
        int[][] grid = {
            {1, 1, 1},
            {1, 1, 1},
            {1, 1, 1}
        };
        int expected = -1;
        assertEquals(expected, orangesRot.orangesRotting(grid));
    }

    @Test
    void testOrangesRottingWithAllRottenOranges() {
        int[][] grid = {
            {2, 2, 2},
            {2, 2, 2},
            {2, 2, 2}
        };
        int expected = 0;
        assertEquals(expected, orangesRot.orangesRotting(grid));
    }

    @Test
    void testOrangesRottingWithMixedOranges() {
        int[][] grid = {
            {2, 1, 1},
            {2, 1, 1},
            {2, 1, 1}
        };
        int expected = 2;
        assertEquals(expected, orangesRot.orangesRotting(grid));
    }

    @Test
    void testOrangesRottingWithOneFreshOrange() {
        int[][] grid = {
            {2, 2, 1},
            {2, 2, 2},
            {2, 2, 2}
        };
        int expected = 1;
        assertEquals(expected, orangesRot.orangesRotting(grid));
    }

    @Test
    void testOrangesRottingWithUnreachableFreshOrange() {
        int[][] grid = {
            {2, 1, 2},
            {2, 2, 2},
            {2, 2, 2}
        };
        int expected = -1;
        assertEquals(expected, orangesRot.orangesRotting(grid));
    }

    @Test
    void testOrangesRottingWithComplexGrid() {
        int[][] grid = {
            {2, 1, 0, 2, 1},
            {1, 0, 1, 2, 1},
            {0, 2, 0, 1, 2},
            {2, 1, 2, 2, 1},
            {1, 2, 1, 1, 2}
        };
        int expected = 3;
        assertEquals(expected, orangesRot.orangesRotting(grid));
    }
}