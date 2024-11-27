package numIslands.chatGPTo1Preview.prompt0;


import org.junit.Test;
import static org.junit.Assert.*;
import numIslands.NumIslands;

public class numIslandsTest {

    @Test
    public void testEmptyGrid() {
        NumIslands numIslands = new NumIslands();
        char[][] grid = {};
        int expected = 0;
        int result = numIslands.numIslands(grid);
        assertEquals(expected, result);
    }

    @Test
    public void testGridWithNoIslands() {
        NumIslands numIslands = new NumIslands();
        char[][] grid = {
            {'0', '0', '0'},
            {'0', '0', '0'},
            {'0', '0', '0'}
        };
        int expected = 0;
        int result = numIslands.numIslands(grid);
        assertEquals(expected, result);
    }

    @Test
    public void testGridWithOneIsland() {
        NumIslands numIslands = new NumIslands();
        char[][] grid = {
            {'1', '1', '1'},
            {'0', '1', '0'},
            {'0', '1', '0'}
        };
        int expected = 1;
        int result = numIslands.numIslands(grid);
        assertEquals(expected, result);
    }

    @Test
    public void testGridWithMultipleIslands() {
        NumIslands numIslands = new NumIslands();
        char[][] grid = {
            {'1', '0', '1', '0', '1'},
            {'0', '1', '0', '1', '0'},
            {'1', '0', '1', '0', '1'}
        };
        int expected = 9;
        int result = numIslands.numIslands(grid);
        assertEquals(expected, result);
    }

    @Test
    public void testGridWithConnectedIslands() {
        NumIslands numIslands = new NumIslands();
        char[][] grid = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '1', '1'},
            {'0', '0', '0', '1', '1'},
            {'0', '1', '0', '0', '0'}
        };
        int expected = 2;
        int result = numIslands.numIslands(grid);
        assertEquals(expected, result);
    }

    @Test
    public void testGridSingleRow() {
        NumIslands numIslands = new NumIslands();
        char[][] grid = {
            {'1', '0', '1', '1', '0', '1'}
        };
        int expected = 3;
        int result = numIslands.numIslands(grid);
        assertEquals(expected, result);
    }

    @Test
    public void testGridSingleColumn() {
        NumIslands numIslands = new NumIslands();
        char[][] grid = {
            {'1'},
            {'0'},
            {'1'},
            {'1'},
            {'0'},
            {'1'}
        };
        int expected = 3;
        int result = numIslands.numIslands(grid);
        assertEquals(expected, result);
    }

    @Test
    public void testGridAllLand() {
        NumIslands numIslands = new NumIslands();
        char[][] grid = {
            {'1', '1'},
            {'1', '1'}
        };
        int expected = 1;
        int result = numIslands.numIslands(grid);
        assertEquals(expected, result);
    }

    @Test
    public void testGridAllWater() {
        NumIslands numIslands = new NumIslands();
        char[][] grid = {
            {'0', '0'},
            {'0', '0'}
        };
        int expected = 0;
        int result = numIslands.numIslands(grid);
        assertEquals(expected, result);
    }

    @Test
    public void testGridWithDiagonalsNotConnected() {
        NumIslands numIslands = new NumIslands();
        char[][] grid = {
            {'1', '0', '0'},
            {'0', '1', '0'},
            {'0', '0', '1'}
        };
        int expected = 3;
        int result = numIslands.numIslands(grid);
        assertEquals(expected, result);
    }

    @Test
    public void testLargeGrid() {
        NumIslands numIslands = new NumIslands();
        char[][] grid = new char[50][50];
        // Initialize grid with alternating '1's and '0's
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                grid[i][j] = ((i + j) % 2 == 0) ? '1' : '0';
            }
        }
        int expected = 1250; // Each '1' is isolated
        int result = numIslands.numIslands(grid);
        assertEquals(expected, result);
    }
}

