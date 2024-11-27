package numIslands.mistralLarge.black;
import numIslands.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumIslandsTest {

    @Test
    public void testExample1() {
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
    public void testExample2() {
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

    @Test
    public void testNoIslands() {
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
    public void testSingleIsland() {
        char[][] grid = {
            {'1'}
        };
        NumIslands numIslands = new NumIslands();
        int result = numIslands.numIslands(grid);
        assertEquals(1, result);
    }

    @Test
    public void testMultipleIslands() {
        char[][] grid = {
            {'1', '0', '1'},
            {'0', '1', '0'},
            {'1', '0', '1'}
        };
        NumIslands numIslands = new NumIslands();
        int result = numIslands.numIslands(grid);
        assertEquals(5, result);
    }

    @Test
    public void testLargeGrid() {
        char[][] grid = new char[300][300];
        for (int i = 0; i < 300; i++) {
            for (int j = 0; j < 300; j++) {
                grid[i][j] = '0';
            }
        }
        grid[0][0] = '1';
        grid[299][299] = '1';
        NumIslands numIslands = new NumIslands();
        int result = numIslands.numIslands(grid);
        assertEquals(2, result);
    }
}