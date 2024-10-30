package numIslands.ai21Jamba.prompt0;
import numIslands.NumIslands;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NumIslandsTest {

    @Test
    public void testNumIslands() {
        NumIslands numIslands = new NumIslands();

        // Test case 1: No islands
        char[][] grid1 = {
            {'0', '0', '0', '0', '0'},
            {'0', '0', '0', '0', '0'},
            {'0', '0', '0', '0', '0'},
            {'0', '0', '0', '0', '0'},
            {'0', '0', '0', '0', '0'}
        };
        assertEquals(0, numIslands.numIslands(grid1));

        // Test case 2: One island
        char[][] grid2 = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '0'},
            {'0', '0', '0', '0', '0'},
            {'0', '0', '0', '0', '0'}
        };
        assertEquals(1, numIslands.numIslands(grid2));

        // Test case 3: Multiple islands
        char[][] grid3 = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'},
            {'0', '0', '0', '1', '1'}
        };
        assertEquals(3, numIslands.numIslands(grid3));

        // Test case 4: Islands with single cells
        char[][] grid4 = {
            {'1', '0', '0', '0', '0'},
            {'0', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '0'},
            {'0', '0', '0', '0', '1'}
        };
        assertEquals(5, numIslands.numIslands(grid4));

        // Test case 5: Complex grid with multiple islands
        char[][] grid5 = {
            {'1', '1', '0', '0', '0', '0', '0'},
            {'1', '1', '0', '0', '0', '0', '0'},
            {'0', '0', '0', '0', '0', '0', '0'},
            {'0', '0', '0', '1', '1', '0', '0'},
            {'0', '0', '0', '1', '1', '0', '0'},
            {'0', '0', '0', '0', '0', '1', '1'},
            {'0', '0', '0', '0', '0', '1', '1'}
        };
        assertEquals(4, numIslands.numIslands(grid5));
    }
}