package numIslands.gpto1Mini.black;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import numIslands.NumIslands;

public class NumIslandsTest {

    @Test
    void testExample1() {
        char[][] grid = {
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'}
        };
        NumIslands solution = new NumIslands();
        int result = solution.numIslands(grid);
        assertEquals(1, result, "Example 1 should return 1 island.");
    }

    @Test
    void testExample2() {
        char[][] grid = {
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','1'}
        };
        NumIslands solution = new NumIslands();
        int result = solution.numIslands(grid);
        assertEquals(3, result, "Example 2 should return 3 islands.");
    }

    @Test
    void testAllWater() {
        char[][] grid = {
            {'0','0','0'},
            {'0','0','0'},
            {'0','0','0'}
        };
        NumIslands solution = new NumIslands();
        int result = solution.numIslands(grid);
        assertEquals(0, result, "All water grid should return 0 islands.");
    }

    @Test
    void testAllLand() {
        char[][] grid = {
            {'1','1','1'},
            {'1','1','1'},
            {'1','1','1'}
        };
        NumIslands solution = new NumIslands();
        int result = solution.numIslands(grid);
        assertEquals(1, result, "All land grid should return 1 island.");
    }

    @Test
    void testSingleCellLand() {
        char[][] grid = {
            {'1'}
        };
        NumIslands solution = new NumIslands();
        int result = solution.numIslands(grid);
        assertEquals(1, result, "Single land cell should return 1 island.");
    }

    @Test
    void testSingleCellWater() {
        char[][] grid = {
            {'0'}
        };
        NumIslands solution = new NumIslands();
        int result = solution.numIslands(grid);
        assertEquals(0, result, "Single water cell should return 0 islands.");
    }

    @Test
    void testDisconnectedIslands() {
        char[][] grid = {
            {'1','0','1','0','1'},
            {'0','1','0','1','0'},
            {'1','0','1','0','1'},
            {'0','1','0','1','0'}
        };
        NumIslands solution = new NumIslands();
        int result = solution.numIslands(grid);
        assertEquals(8, result, "Disconnected islands should return the correct count.");
    }

    @Test
    void testEmptyGrid() {
        char[][] grid = {};
        NumIslands solution = new NumIslands();
        int result = solution.numIslands(grid);
        assertEquals(0, result, "Empty grid should return 0 islands.");
    }

    @Test
    void testLargeGrid() {
        char[][] grid = new char[300][300];
        for(int i = 0; i < 300; i++) {
            for(int j = 0; j < 300; j++) {
                grid[i][j] = '1';
            }
        }
        NumIslands solution = new NumIslands();
        int result = solution.numIslands(grid);
        assertEquals(1, result, "Large all land grid should return 1 island.");
    }
}