package numIslands.gpto1Mini.white;

import numIslands.NumIslands;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NumIslandsTest {

    @Test
    void testEmptyGrid() {
        NumIslands numIslands = new NumIslands();
        char[][] grid = {};
        int result = numIslands.numIslands(grid);
        assertEquals(0, result, "Empty grid should have 0 islands.");
    }

    @Test
    void testAllWater() {
        NumIslands numIslands = new NumIslands();
        char[][] grid = {
            {'0', '0', '0'},
            {'0', '0', '0'},
            {'0', '0', '0'}
        };
        int result = numIslands.numIslands(grid);
        assertEquals(0, result, "Grid with all water should have 0 islands.");
    }

    @Test
    void testSingleCellLand() {
        NumIslands numIslands = new NumIslands();
        char[][] grid = {
            {'1'}
        };
        int result = numIslands.numIslands(grid);
        assertEquals(1, result, "Grid with a single land cell should have 1 island.");
    }

    @Test
    void testSingleIsland() {
        NumIslands numIslands = new NumIslands();
        char[][] grid = {
            {'1', '1', '1'},
            {'1', '1', '1'},
            {'1', '1', '1'}
        };
        int result = numIslands.numIslands(grid);
        assertEquals(1, result, "Grid with all connected land cells should have 1 island.");
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
        int result = numIslands.numIslands(grid);
        assertEquals(3, result, "Grid should have 3 islands.");
    }

    @Test
    void testDiagonalIslands() {
        NumIslands numIslands = new NumIslands();
        char[][] grid = {
            {'1', '0', '1'},
            {'0', '1', '0'},
            {'1', '0', '1'}
        };
        int result = numIslands.numIslands(grid);
        assertEquals(5, result, "Grid with diagonally adjacent lands should count them as separate islands.");
    }

    @Test
    void testLargeGrid() {
        NumIslands numIslands = new NumIslands();
        char[][] grid = new char[100][100];
        for(int i = 0; i < 100; i++) {
            for(int j = 0; j < 100; j++) {
                grid[i][j] = (i == j) ? '1' : '0';
            }
        }
        int result = numIslands.numIslands(grid);
        assertEquals(100, result, "Large grid with diagonal '1's should have 100 islands.");
    }

    @Test
    void testSingleRow() {
        NumIslands numIslands = new NumIslands();
        char[][] grid = {
            {'1', '0', '1', '1', '0', '1'}
        };
        int result = numIslands.numIslands(grid);
        assertEquals(3, result, "Single row grid should have 3 islands.");
    }

    @Test
    void testSingleColumn() {
        NumIslands numIslands = new NumIslands();
        char[][] grid = {
            {'1'},
            {'0'},
            {'1'},
            {'1'},
            {'0'},
            {'1'}
        };
        int result = numIslands.numIslands(grid);
        assertEquals(3, result, "Single column grid should have 3 islands.");
    }

    @Test
    void testMixedGrid() {
        NumIslands numIslands = new NumIslands();
        char[][] grid = {
            {'1', '1', '0', '1', '0'},
            {'1', '0', '0', '0', '0'},
            {'0', '0', '1', '0', '1'},
            {'1', '0', '0', '1', '1'},
            {'0', '1', '0', '0', '0'}
        };
        int result = numIslands.numIslands(grid);
        assertEquals(6, result, "Mixed grid should have 6 islands.");
    }
}