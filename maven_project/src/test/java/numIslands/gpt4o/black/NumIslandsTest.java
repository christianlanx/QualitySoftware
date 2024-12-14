package numIslands.gpt4o.black;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import numIslands.NumIslands;

public class NumIslandsTest {
    
    @Test
    public void testSingleIsland() {
        char[][] grid = {
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '0'}
        };
        NumIslands numIslands = new NumIslands();
        assertEquals(1, numIslands.numIslands(grid));
    }
    
    @Test
    public void testMultipleIslands() {
        char[][] grid = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };
        NumIslands numIslands = new NumIslands();
        assertEquals(3, numIslands.numIslands(grid));
    }
    
    @Test
    public void testNoIsland() {
        char[][] grid = {
            {'0', '0', '0'},
            {'0', '0', '0'},
            {'0', '0', '0'}
        };
        NumIslands numIslands = new NumIslands();
        assertEquals(0, numIslands.numIslands(grid));
    }

    @Test
    public void testAllLand() {
        char[][] grid = {
            {'1', '1', '1'},
            {'1', '1', '1'},
            {'1', '1', '1'}
        };
        NumIslands numIslands = new NumIslands();
        assertEquals(1, numIslands.numIslands(grid));
    }    

    @Test
    public void testDiagonalLandNotConnected() {
        char[][] grid = {
            {'1', '0', '1'},
            {'0', '1', '0'},
            {'1', '0', '1'}
        };
        NumIslands numIslands = new NumIslands();
        assertEquals(5, numIslands.numIslands(grid));
    }

    @Test
    public void testThinStripIsland() {
        char[][] grid = {
            {'1', '0', '0', '0'},
            {'1', '1', '0', '0'},
            {'0', '1', '0', '0'},
            {'0', '1', '1', '1'}
        };
        NumIslands numIslands = new NumIslands();
        assertEquals(1, numIslands.numIslands(grid));
    }

    @Test
    public void testMixedIslands() {
        char[][] grid = {
            {'1', '1', '0', '0', '1'},
            {'1', '0', '0', '1', '1'},
            {'0', '0', '1', '0', '0'},
            {'1', '1', '0', '1', '0'}
        };
        NumIslands numIslands = new NumIslands();
        assertEquals(4, numIslands.numIslands(grid));
    }

    @Test
    public void testSingleCellLand() {
        char[][] grid = {
            {'0', '0'},
            {'0', '1'}
        };
        NumIslands numIslands = new NumIslands();
        assertEquals(1, numIslands.numIslands(grid));
    }

    @Test
    public void testSingleCellWater() {
        char[][] grid = {
            {'0'}
        };
        NumIslands numIslands = new NumIslands();
        assertEquals(0, numIslands.numIslands(grid));
    }

    @Test
    public void testLargeGridWithOneIsland() {
        char[][] grid = new char[300][300];
        for (int i = 0; i < 300; i++) {
            for (int j = 0; j < 300; j++) {
                grid[i][j] = '1';
            }
        }
        NumIslands numIslands = new NumIslands();
        assertEquals(1, numIslands.numIslands(grid));
    }
}