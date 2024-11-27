package numIslands.metaAI.prompt1;
import numIslands.NumIslands;

import org.junit.Test;
import static org.junit.Assert.*;

public class NumIslandsTest {

    NumIslands numIslands = new NumIslands();

    @Test
    public void testExample1() {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        int expected = 1;
        assertEquals(expected, numIslands.numIslands(grid));
    }

    @Test
    public void testExample2() {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        int expected = 3;
        assertEquals(expected, numIslands.numIslands(grid));
    }

    @Test
    public void testSingleIsland() {
        char[][] grid = {
                {'1', '1'},
                {'1', '1'}
        };
        int expected = 1;
        assertEquals(expected, numIslands.numIslands(grid));
    }

    @Test
    public void testNoIslands() {
        char[][] grid = {
                {'0', '0'},
                {'0', '0'}
        };
        int expected = 0;
        assertEquals(expected, numIslands.numIslands(grid));
    }

    @Test
    public void testLargeGrid() {
        char[][] grid = new char[300][300];
        for (int i = 0; i < 300; i++) {
            for (int j = 0; j < 300; j++) {
                grid[i][j] = '0';
            }
        }
        grid[100][100] = '1';
        int expected = 1;
        assertEquals(expected, numIslands.numIslands(grid));
    }
}