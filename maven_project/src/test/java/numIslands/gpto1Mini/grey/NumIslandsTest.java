package numIslands.gpto1Mini.grey;

import numIslands.NumIslands;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NumIslandsTest {

    @Test
    public void testExample1() {
        char[][] grid = {
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'}
        };
        NumIslands numIslands = new NumIslands();
        int result = numIslands.numIslands(grid);
        assertEquals(1, result, "Example 1 should return 1 island.");
    }

    @Test
    public void testExample2() {
        char[][] grid = {
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','1'}
        };
        NumIslands numIslands = new NumIslands();
        int result = numIslands.numIslands(grid);
        assertEquals(3, result, "Example 2 should return 3 islands.");
    }

    @Test
    public void testAllWater() {
        char[][] grid = {
            {'0','0','0'},
            {'0','0','0'},
            {'0','0','0'}
        };
        NumIslands numIslands = new NumIslands();
        int result = numIslands.numIslands(grid);
        assertEquals(0, result, "All water grid should return 0 islands.");
    }

    @Test
    public void testAllLand() {
        char[][] grid = {
            {'1','1','1'},
            {'1','1','1'},
            {'1','1','1'}
        };
        NumIslands numIslands = new NumIslands();
        int result = numIslands.numIslands(grid);
        assertEquals(1, result, "All land grid should return 1 island.");
    }

    @Test
    public void testSingleCellLand() {
        char[][] grid = { {'1'} };
        NumIslands numIslands = new NumIslands();
        int result = numIslands.numIslands(grid);
        assertEquals(1, result, "Single land cell should return 1 island.");
    }

    @Test
    public void testSingleCellWater() {
        char[][] grid = { {'0'} };
        NumIslands numIslands = new NumIslands();
        int result = numIslands.numIslands(grid);
        assertEquals(0, result, "Single water cell should return 0 islands.");
    }

    @Test
    public void testMultipleIslands() {
        char[][] grid = {
            {'1','0','1','0','1'},
            {'0','1','0','1','0'},
            {'1','0','1','0','1'},
            {'0','1','0','1','0'}
        };
        NumIslands numIslands = new NumIslands();
        int result = numIslands.numIslands(grid);
        assertEquals(10, result, "Grid with multiple separated lands should return correct number of islands.");
    }

    @Test
    public void testLargeGrid() {
        char[][] grid = new char[300][300];
        for(int i = 0; i < 300; i++) {
            for(int j = 0; j < 300; j++) {
                grid[i][j] = '1';
            }
        }
        NumIslands numIslands = new NumIslands();
        int result = numIslands.numIslands(grid);
        assertEquals(1, result, "Large all land grid should return 1 island.");
    }
}