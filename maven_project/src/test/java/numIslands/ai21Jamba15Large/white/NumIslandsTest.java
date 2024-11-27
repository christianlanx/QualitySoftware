package numIslands.ai21Jamba15Large.white;
import numIslands.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NumIslandsTest {
    @Test
    void testNumIslandsEmptyGrid() {
        char[][] grid = {};
        NumIslands numIslands = new NumIslands();
        int result = numIslands.numIslands(grid);
        assertEquals(0, result);
    }

    @Test
    void testNumIslandsSingleIsland() {
        char[][] grid = {
            {'1', '0', '0', '0', '0'},
            {'0', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '0'},
            {'0', '0', '0', '0', '1'}
        };
        NumIslands numIslands = new NumIslands();
        int result = numIslands.numIslands(grid);
        assertEquals(1, result);
    }

    @Test
    void testNumIslandsMultipleIslands() {
        char[][] grid = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'},
            {'0', '0', '0', '1', '1'}
        };
        NumIslands numIslands = new NumIslands();
        int result = numIslands.numIslands(grid);
        assertEquals(3, result);
    }

    @Test
    void testNumIslandsNoIslands() {
        char[][] grid = {
            {'0', '0', '0'},
            {'0', '0', '0'},
            {'0', '0', '0'}
        };
        NumIslands numIslands = new NumIslands();
        int result = numIslands.numIslands(grid);
        assertEquals(0, result);
    }

    @Test
    void testNumIslandsAllOnes() {
        char[][] grid = {
            {'1', '1', '1'},
            {'1', '1', '1'},
            {'1', '1', '1'}
        };
        NumIslands numIslands = new NumIslands();
        int result = numIslands.numIslands(grid);
        assertEquals(1, result);
    }
}