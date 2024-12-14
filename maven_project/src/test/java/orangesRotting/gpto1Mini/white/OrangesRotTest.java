package orangesRotting.gpto1Mini.white;

import orangesRotting.OrangesRot;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OrangesRotTest {

    @Test
    void testAllOrangesAlreadyRotten() {
        int[][] grid = {
            {2, 2},
            {2, 2}
        };
        OrangesRot solution = new OrangesRot();
        int result = solution.orangesRotting(grid);
        assertEquals(0, result, "All oranges are already rotten, expected 0 minutes.");
    }

    @Test
    void testNoFreshOranges() {
        int[][] grid = {
            {0, 0},
            {0, 0}
        };
        OrangesRot solution = new OrangesRot();
        int result = solution.orangesRotting(grid);
        assertEquals(0, result, "No fresh oranges present, expected 0 minutes.");
    }

    @Test
    void testAllFreshCanBeRotten() {
        int[][] grid = {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
        };
        OrangesRot solution = new OrangesRot();
        int result = solution.orangesRotting(grid);
        assertEquals(4, result, "All fresh oranges can be rotten in 4 minutes.");
    }

    @Test
    void testNotAllFreshCanBeRotten() {
        int[][] grid = {
            {2, 1, 1},
            {0, 1, 1},
            {1, 0, 1}
        };
        OrangesRot solution = new OrangesRot();
        int result = solution.orangesRotting(grid);
        assertEquals(-1, result, "Not all fresh oranges can be rotten, expected -1.");
    }

    @Test
    void testEmptyGrid() {
        int[][] grid = {};
        OrangesRot solution = new OrangesRot();
        int result = solution.orangesRotting(grid);
        assertEquals(0, result, "Empty grid, expected 0 minutes.");
    }

    @Test
    void testSingleFreshOrange() {
        int[][] grid = {
            {1}
        };
        OrangesRot solution = new OrangesRot();
        int result = solution.orangesRotting(grid);
        assertEquals(-1, result, "Single fresh orange cannot be rotten, expected -1.");
    }

    @Test
    void testSingleRottenOrange() {
        int[][] grid = {
            {2}
        };
        OrangesRot solution = new OrangesRot();
        int result = solution.orangesRotting(grid);
        assertEquals(0, result, "Single rotten orange, expected 0 minutes.");
    }

    @Test
    void testSingleEmptyCell() {
        int[][] grid = {
            {0}
        };
        OrangesRot solution = new OrangesRot();
        int result = solution.orangesRotting(grid);
        assertEquals(0, result, "Single empty cell, expected 0 minutes.");
    }

    @Test
    void testMixedGrid() {
        int[][] grid = {
            {2, 1, 0, 2},
            {1, 0, 1, 1},
            {1, 1, 1, 2}
        };
        OrangesRot solution = new OrangesRot();
        int result = solution.orangesRotting(grid);
        assertEquals(2, result, "Mixed grid should be rotten in 2 minutes.");
    }
}