package orangesRotting.ai21Jamba15Large.white;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.jupiter.api.Test;

import orangesRotting.OrangesRot;

public class OrangesRotTest {

    @Test
    void testOrangesRotting() {
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
    void testOrangesRottingEmptyGrid() {
        OrangesRot orangesRot = new OrangesRot();
        int[][] grid = {};
        int expected = 0;
        assertEquals(expected, orangesRot.orangesRotting(grid));
    }

    @Test
    void testOrangesRottingNoFreshOranges() {
        OrangesRot orangesRot = new OrangesRot();
        int[][] grid = {
            {2, 2, 2},
            {2, 2, 2},
            {2, 2, 2}
        };
        int expected = 0;
        assertEquals(expected, orangesRot.orangesRotting(grid));
    }

    @Test
    void testOrangesRottingNoRottenOranges() {
        OrangesRot orangesRot = new OrangesRot();
        int[][] grid = {
            {1, 1, 1},
            {1, 1, 1},
            {1, 1, 1}
        };
        int expected = -1;
        assertEquals(expected, orangesRot.orangesRotting(grid));
    }

    @Test
    void testOrangesRottingSingleRottenOrange() {
        OrangesRot orangesRot = new OrangesRot();
        int[][] grid = {
            {2, 1, 1},
            {1, 1, 1},
            {1, 1, 1}
        };
        int expected = 2;
        assertEquals(expected, orangesRot.orangesRotting(grid));
    }

    @Test
    void testOrangesRottingAllOrangesRottenInOneMinute() {
        OrangesRot orangesRot = new OrangesRot();
        int[][] grid = {
            {2, 1, 1},
            {1, 2, 1},
            {1, 1, 2}
        };
        int expected = 1;
        assertEquals(expected, orangesRot.orangesRotting(grid));
    }

    @Test
    void testOrangesRottingAllOrangesRottenInTwoMinutes() {
        OrangesRot orangesRot = new OrangesRot();
        int[][] grid = {
            {2, 1, 1},
            {1, 1, 1},
            {1, 1, 1}
        };
        int expected = 2;
        assertEquals(expected, orangesRot.orangesRotting(grid));
    }
}