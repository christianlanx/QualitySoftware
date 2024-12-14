package numIslands.gpt4oMini.white;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import numIslands.NumIslands;

public class NumIslandsTest {

    @Test
    public void testNumIslands_EmptyGrid() {
        NumIslands numIslands = new NumIslands();
        char[][] grid = {};
        assertEquals(0, numIslands.numIslands(grid));
    }

    @Test
    public void testNumIslands_NoLand() {
        NumIslands numIslands = new NumIslands();
        char[][] grid = { {'0', '0'}, {'0', '0'} };
        assertEquals(0, numIslands.numIslands(grid));
    }

    @Test
    public void testNumIslands_OneIsland() {
        NumIslands numIslands = new NumIslands();
        char[][] grid = { {'1', '1'}, {'0', '0'} };
        assertEquals(1, numIslands.numIslands(grid));
    }

    @Test
    public void testNumIslands_TwoIslands() {
        NumIslands numIslands = new NumIslands();
        char[][] grid = { {'1', '0', '1'}, {'0', '0', '0'}, {'1', '0', '1'} };
        assertEquals(4, numIslands.numIslands(grid));
    }

    @Test
    public void testNumIslands_ComplexGrid() {
        NumIslands numIslands = new NumIslands();
        char[][] grid = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '1', '1'},
            {'0', '0', '0', '1', '1'},
            {'0', '0', '0', '0', '0'},
            {'1', '0', '1', '1', '0'}
        };
        assertEquals(3, numIslands.numIslands(grid));
    }
    
    @Test
    public void testNumIslands_EntireGridIsLand() {
        NumIslands numIslands = new NumIslands();
        char[][] grid = { {'1', '1'}, {'1', '1'} };
        assertEquals(1, numIslands.numIslands(grid));
    }

    @Test
    public void testNumIslands_IsolatedLands() {
        NumIslands numIslands = new NumIslands();
        char[][] grid = { 
            {'1', '0', '1'},
            {'0', '0', '0'},
            {'1', '0', '1'}
        };
        assertEquals(4, numIslands.numIslands(grid));
    }
}