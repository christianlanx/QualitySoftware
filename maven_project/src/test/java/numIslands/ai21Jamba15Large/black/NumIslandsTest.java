package numIslands.ai21Jamba15Large.black;
import numIslands.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumIslandsTest {

    @Test
    void testNumIslandsExample1() {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        int expected = 1;
        NumIslands numIslands = new NumIslands();
        assertEquals(expected, numIslands.numIslands(grid));
    }

    @Test
    void testNumIslandsExample2() {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        int expected = 3;
        NumIslands numIslands = new NumIslands();
        assertEquals(expected, numIslands.numIslands(grid));
    }

    @Test
    void testNumIslandsAllWater() {
        char[][] grid = {
                {'0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        int expected = 0;
        NumIslands numIslands = new NumIslands();
        assertEquals(expected, numIslands.numIslands(grid));
    }

    @Test
    void testNumIslandsAllLand() {
        char[][] grid = {
                {'1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1'}
        };
        int expected = 1;
        NumIslands numIslands = new NumIslands();
        assertEquals(expected, numIslands.numIslands(grid));
    }

    @Test
    void testNumIslandsMixed() {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '1', '0'},
                {'0', '0', '1', '1', '0'}
        };
        int expected = 3;
        NumIslands numIslands = new NumIslands();
        assertEquals(expected, numIslands.numIslands(grid));
    }

    @Test
    void testNumIslandsLargeGrid() {
        char[][] grid = new char[300][300];
        for (int i = 0; i < 300; i++) {
            for (int j = 0; j < 300; j++) {
                grid[i][j] = '1';
            }
        }
        int expected = 1;
        NumIslands numIslands = new NumIslands();
        assertEquals(expected, numIslands.numIslands(grid));
    }

    @Test
    void testNumIslandsSingleIsland() {
        char[][] grid = {
                {'1'}
        };
        int expected = 1;
        NumIslands numIslands = new NumIslands();
        assertEquals(expected, numIslands.numIslands(grid));
    }

    @Test
    void testNumIslandsEmptyGrid() {
        char[][] grid = {};
        int expected = 0;
        NumIslands numIslands = new NumIslands();
        assertEquals(expected, numIslands.numIslands(grid));
    }
}