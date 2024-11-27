package numIslands.mistralSmall.black;
import numIslands.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NumIslandsTest {

    @Test
    public void testExample1() {
        char[][] grid = {
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '0'}
        };
        NumIslands numIslands = new NumIslands();
        int result = numIslands.numIslands(grid);
        assertEquals(1, result);
    }

    @Test
    public void testExample2() {
        char[][] grid = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };
        NumIslands numIslands = new NumIslands();
        int result = numIslands.numIslands(grid);
        assertEquals(3, result);
    }

    @Test
    public void testSingleIsland() {
        char[][] grid = {
            {'1'}
        };
        NumIslands numIslands = new NumIslands();
        int result = numIslands.numIslands(grid);
        assertEquals(1, result);
    }

    @Test
    public void testNoIslands() {
        char[][] grid = {
            {'0'}
        };
        NumIslands numIslands = new NumIslands();
        int result = numIslands.numIslands(grid);
        assertEquals(0, result);
    }

    @Test
    public void testLargeGrid() {
        char[][] grid = {
            {'1', '1', '1', '1', '1', '1', '1'},
            {'1', '1', '0', '0', '0', '0', '1'},
            {'1', '1', '0', '1', '0', '0', '1'},
            {'1', '1', '0', '1', '0', '0', '1'},
            {'1', '1', '0', '0', '0', '0', '1'},
            {'1', '1', '1', '1', '1', '1', '1'}
        };
        NumIslands numIslands = new NumIslands();
        int result = numIslands.numIslands(grid);
        assertEquals(1, result);
    }

    @Test
    public void testMultipleIslands() {
        char[][] grid = {
            {'1', '1', '0', '0', '0', '0', '1'},
            {'1', '1', '0', '1', '1', '0', '1'},
            {'0', '0', '0', '1', '1', '0', '0'},
            {'0', '0', '0', '1', '1', '0', '0'},
            {'1', '1', '0', '0', '0', '0', '1'}
        };
        NumIslands numIslands = new NumIslands();
        int result = numIslands.numIslands(grid);
        assertEquals(2, result);
    }
}