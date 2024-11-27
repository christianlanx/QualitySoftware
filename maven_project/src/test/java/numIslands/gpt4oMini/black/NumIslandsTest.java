package numIslands.gpt4oMini.black;
import numIslands.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class NumIslandsTest {

    private final NumIslands numIslands = new NumIslands();

    @Test
    public void testSingleIsland() {
        char[][] grid = {
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '0'}
        };
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
        assertEquals(3, numIslands.numIslands(grid));
    }

    @Test
    public void testAllWater() {
        char[][] grid = {
            {'0', '0', '0', '0'},
            {'0', '0', '0', '0'},
            {'0', '0', '0', '0'},
            {'0', '0', '0', '0'}
        };
        assertEquals(0, numIslands.numIslands(grid));
    }

    @Test
    public void testAllLand() {
        char[][] grid = {
            {'1', '1', '1', '1'},
            {'1', '1', '1', '1'},
            {'1', '1', '1', '1'},
            {'1', '1', '1', '1'}
        };
        assertEquals(1, numIslands.numIslands(grid));
    }

    @Test
    public void testOneCellIsland() {
        char[][] grid = {
            {'1'}
        };
        assertEquals(1, numIslands.numIslands(grid));
    }

    @Test
    public void testOneCellWater() {
        char[][] grid = {
            {'0'}
        };
        assertEquals(0, numIslands.numIslands(grid));
    }

    @Test
    public void testLargerGrid() {
        char[][] grid = {
            {'1', '0', '0', '1', '0'},
            {'1', '0', '0', '0', '0'},
            {'0', '0', '1', '1', '0'},
            {'0', '0', '0', '1', '0'},
            {'1', '0', '0', '0', '1'}
        };
        assertEquals(5, numIslands.numIslands(grid));
    }

    @Test
    public void testEdgeCases() {
        char[][] grid = { 
            {'1', '0', '1', '0', '1'},
            {'0', '1', '0', '1', '0'},
            {'1', '0', '1', '0', '1'},
            {'0', '1', '0', '1', '0'},
        };
        assertEquals(10, numIslands.numIslands(grid));
    }
}