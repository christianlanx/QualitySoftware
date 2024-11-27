package numIslands.ai21Jamba15Mini.black;
import numIslands.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NumIslandsTest {

    @Test
    void testEmptyGrid() {
        char[][] grid = {};
        NumIslands numIslands = new NumIslands();
        int result = numIslands.numIslands(grid);
        assertEquals(0, result);
    }

    @Test
    void testSingleIsland() {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        NumIslands numIslands = new NumIslands();
        int result = numIslands.numIslands(grid);
        assertEquals(1, result);
    }

    @Test
    void testMultipleIslands() {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        NumIslands numIslands = new NumIslands();
        int result = numIslands.numIslands(grid);
        assertEquals(3, result);
    }

    // Add more test cases to cover different scenarios:
    // - Islands of different sizes
    // - Islands connected diagonally
    // - Edge cases (grids with only water or land)
}