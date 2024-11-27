package numIslands.gpt4o.black;
import numIslands.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NumIslandsTest {

    @Test
    void testSingleIsland() {
        NumIslands numIslands = new NumIslands();
        char[][] grid = {
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '0'}
        };
        assertEquals(1, numIslands.numIslands(grid));
    }

    @Test
    void testMultipleIslands() {
        NumIslands numIslands = new NumIslands();
        char[][] grid = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };
        assertEquals(3, numIslands.numIslands(grid));
    }

    @Test
    void testNoIslands() {
        NumIslands numIslands = new NumIslands();
        char[][] grid = {
            {'0', '0', '0', '0', '0'},
            {'0', '0', '0', '0', '0'},
            {'0', '0', '0', '0', '0'},
            {'0', '0', '0', '0', '0'}
        };
        assertEquals(0, numIslands.numIslands(grid));
    }

    @Test
    void testAllLandSingleIsland() {
        NumIslands numIslands = new NumIslands();
        char[][] grid = {
            {'1', '1', '1'},
            {'1', '1', '1'},
            {'1', '1', '1'}
        };
        assertEquals(1, numIslands.numIslands(grid));
    }

    @Test
    void testSingleCellIsland() {
        NumIslands numIslands = new NumIslands();
        
        // Island
        char[][] grid1 = {
            {'1'}
        };
        assertEquals(1, numIslands.numIslands(grid1));
        
        // Water
        char[][] grid2 = {
            {'0'}
        };
        assertEquals(0, numIslands.numIslands(grid2));
    }

    @Test
    void testSingleRowMultipleIslands() {
        NumIslands numIslands = new NumIslands();
        char[][] grid = {
            {'1', '0', '1', '0', '1'}
        };
        assertEquals(3, numIslands.numIslands(grid));
    }

    @Test
    void testSingleColumnMultipleIslands() {
        NumIslands numIslands = new NumIslands();
        char[][] grid = {
            {'1'},
            {'0'},
            {'1'},
            {'0'},
            {'1'}
        };
        assertEquals(3, numIslands.numIslands(grid));
    }

    @Test
    void testConnectedDiagonally() {
        NumIslands numIslands = new NumIslands();
        char[][] grid = {
            {'1', '0', '0'},
            {'0', '1', '0'},
            {'0', '0', '1'}
        };
        assertEquals(3, numIslands.numIslands(grid));  // Diagonal connections don't count
    }
}