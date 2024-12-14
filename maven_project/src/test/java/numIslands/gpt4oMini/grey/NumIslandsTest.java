package numIslands.gpt4oMini.grey;

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
    public void testNoLand() {
        char[][] grid = {
            {'0', '0', '0', '0', '0'},
            {'0', '0', '0', '0', '0'},
            {'0', '0', '0', '0', '0'},
            {'0', '0', '0', '0', '0'}
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
    public void testDiagonalConnection() {
        char[][] grid = {
            {'1', '0', '0', '1'},
            {'0', '1', '0', '0'},
            {'0', '0', '1', '0'},
            {'1', '0', '0', '1'}
        };
        assertEquals(4, numIslands.numIslands(grid));
    }

    @Test
    public void testComplexLandWaterConfiguration() {
        char[][] grid = {
            {'1', '0', '1', '0', '0'},
            {'0', '0', '1', '1', '0'},
            {'1', '0', '0', '1', '1'},
            {'0', '0', '0', '0', '0'}
        };
        assertEquals(5, numIslands.numIslands(grid));
    }
}