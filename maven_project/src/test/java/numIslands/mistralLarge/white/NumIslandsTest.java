package numIslands.mistralLarge.white;
import numIslands.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class NumIslandsTest {

    @Test
    public void testNumIslands_singleIsland() {
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
    public void testNumIslands_multipleIslands() {
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
    public void testNumIslands_noIslands() {
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
    public void testNumIslands_allIslands() {
        NumIslands numIslands = new NumIslands();
        char[][] grid = {
            {'1', '1', '1', '1', '1'},
            {'1', '1', '1', '1', '1'},
            {'1', '1', '1', '1', '1'},
            {'1', '1', '1', '1', '1'}
        };
        assertEquals(1, numIslands.numIslands(grid));
    }

    @Test
    public void testNumIslands_singleCellIsland() {
        NumIslands numIslands = new NumIslands();
        char[][] grid = {
            {'1'}
        };
        assertEquals(1, numIslands.numIslands(grid));
    }

    @Test
    public void testNumIslands_singleCellNoIsland() {
        NumIslands numIslands = new NumIslands();
        char[][] grid = {
            {'0'}
        };
        assertEquals(0, numIslands.numIslands(grid));
    }

    @Test
    public void testNumIslands_complexGrid() {
        NumIslands numIslands = new NumIslands();
        char[][] grid = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '1', '1'},
            {'0', '0', '0', '1', '1'},
            {'0', '1', '1', '0', '0'},
            {'0', '0', '0', '0', '0'}
        };
        assertEquals(3, numIslands.numIslands(grid));
    }
}