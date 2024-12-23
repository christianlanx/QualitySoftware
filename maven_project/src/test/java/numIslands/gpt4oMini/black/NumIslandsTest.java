package numIslands.gpt4oMini.black;

import numIslands.NumIslands;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
    public void testNoLand() {
        char[][] grid = {
            {'0', '0', '0', '0'},
            {'0', '0', '0', '0'},
            {'0', '0', '0', '0'}
        };
        assertEquals(0, numIslands.numIslands(grid));
    }

    @Test
    public void testSingleCellIsland() {
        char[][] grid = {
            {'1'}
        };
        assertEquals(1, numIslands.numIslands(grid));
    }

    @Test
    public void testLargeGrid() {
        char[][] grid = {
            {'1', '0', '0', '0', '1'},
            {'0', '0', '0', '0', '0'},
            {'0', '0', '1', '0', '1'},
            {'1', '0', '0', '0', '0'}
        };
        assertEquals(5, numIslands.numIslands(grid));
    }

    @Test
    public void testDiagonalLand() {
        char[][] grid = {
            {'1', '0', '0', '1'},
            {'0', '1', '1', '0'},
            {'0', '0', '0', '0'},
            {'1', '0', '0', '1'}
        };
        assertEquals(5, numIslands.numIslands(grid));
    }

    @Test
    public void testFullyConnectedLand() {
        char[][] grid = {
            {'1', '1', '1'},
            {'1', '1', '1'},
            {'1', '1', '1'}
        };
        assertEquals(1, numIslands.numIslands(grid));
    }
}