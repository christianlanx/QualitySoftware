package numIslands;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class NumIslandsTestGPT4 {
    private NumIslands solution;

    @Before
    public void setUp() {
        solution = new NumIslands();
    }

    @Test
    public void testNumIslands_singleIsland() {
        char[][] grid = {
            {'1', '1', '0', '0'},
            {'1', '1', '0', '0'},
            {'0', '0', '0', '0'},
            {'0', '0', '0', '1'}
        };
        int result = solution.numIslands(grid);
        assertEquals(2, result); // Expect 2 islands: one in the top left and one in the bottom right
    }

    @Test
    public void testNumIslands_multipleIslands() {
        char[][] grid = {
            {'1', '0', '0', '1'},
            {'0', '0', '0', '0'},
            {'0', '1', '1', '0'},
            {'0', '0', '1', '1'}
        };
        int result = solution.numIslands(grid);
        assertEquals(3, result); // Expect 3 islands
    }

    @Test
    public void testNumIslands_noIslands() {
        char[][] grid = {
            {'0', '0', '0', '0'},
            {'0', '0', '0', '0'}
        };
        int result = solution.numIslands(grid);
        assertEquals(0, result); // Expect 0 islands
    }

    @Test
    public void testNumIslands_singleCellIsland() {
        char[][] grid = {
            {'1'}
        };
        int result = solution.numIslands(grid);
        assertEquals(1, result); // Expect 1 island
    }

    @Test
    public void testNumIslands_singleCellWater() {
        char[][] grid = {
            {'0'}
        };
        int result = solution.numIslands(grid);
        assertEquals(0, result); // Expect 0 islands
    }

    @Test
    public void testNumIslands_rectangularGrid() {
        char[][] grid = {
            {'1', '1', '0'},
            {'1', '0', '0'},
            {'0', '0', '1'}
        };
        int result = solution.numIslands(grid);
        assertEquals(2, result); // Expect 2 islands: one in the top left and one in the bottom right
    }

    @Test
    public void testNumIslands_largeConnectedIsland() {
        char[][] grid = {
            {'1', '1', '1', '1'},
            {'1', '1', '1', '1'},
            {'1', '1', '1', '1'}
        };
        int result = solution.numIslands(grid);
        assertEquals(1, result); // Expect 1 large connected island
    }
}
