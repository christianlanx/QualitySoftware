package numIslands.gpt4o.white;

import numIslands.NumIslands;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class NumIslandsTest {

    @Test
    public void testSingleIsland() {
        char[][] grid = {
            {'1', '1', '1'},
            {'1', '1', '1'},
            {'1', '1', '1'}
        };
        NumIslands numIslands = new NumIslands();
        assertEquals(1, numIslands.numIslands(grid));
    }
    
    @Test
    public void testMultipleIslands() {
        char[][] grid = {
            {'1', '0', '1'},
            {'0', '1', '0'},
            {'1', '0', '1'}
        };
        NumIslands numIslands = new NumIslands();
        assertEquals(5, numIslands.numIslands(grid));
    }

    @Test
    public void testNoIslands() {
        char[][] grid = {
            {'0', '0', '0'},
            {'0', '0', '0'},
            {'0', '0', '0'}
        };
        NumIslands numIslands = new NumIslands();
        assertEquals(0, numIslands.numIslands(grid));
    }
    
    @Test
    public void testLargeIslandWithWaterInside() {
        char[][] grid = {
            {'1', '1', '1', '1'},
            {'1', '0', '0', '1'},
            {'1', '0', '0', '1'},
            {'1', '1', '1', '1'}
        };
        NumIslands numIslands = new NumIslands();
        assertEquals(1, numIslands.numIslands(grid));
    }

    @Test
    public void testDiagonalIslands() {
        char[][] grid = {
            {'1', '0', '0', '1'},
            {'0', '1', '1', '0'},
            {'0', '0', '1', '0'},
            {'1', '0', '0', '1'}
        };
        NumIslands numIslands = new NumIslands();
        assertEquals(4, numIslands.numIslands(grid));
    }
}