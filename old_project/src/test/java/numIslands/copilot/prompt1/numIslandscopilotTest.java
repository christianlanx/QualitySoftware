package numIslands.copilot.prompt1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import numIslands.NumIslands;

public class numIslandscopilotTest {

    @Test
    public void testNumIslands_Example1() {
        NumIslands solution = new NumIslands();
        char[][] grid = {
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '0'}
        };
        int expected = 1;
        int result = solution.numIslands(grid);
        assertEquals(expected, result);
    }

    @Test
    public void testNumIslands_Example2() {
        NumIslands solution = new NumIslands();
        char[][] grid = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };
        int expected = 3;
        int result = solution.numIslands(grid);
        assertEquals(expected, result);
    }

    @Test
    public void testNumIslands_SingleIsland() {
        NumIslands solution = new NumIslands();
        char[][] grid = {
            {'1', '0', '0', '0'},
            {'0', '0', '0', '0'},
            {'0', '0', '0', '0'},
            {'0', '0', '0', '0'}
        };
        int expected = 1;
        int result = solution.numIslands(grid);
        assertEquals(expected, result);
    }

    @Test
    public void testNumIslands_EmptyGrid() {
        NumIslands solution = new NumIslands();
        char[][] grid = {};
        int expected = 0;
        int result = solution.numIslands(grid);
        assertEquals(expected, result);
    }

    @Test
    public void testNumIslands_AllWater() {
        NumIslands solution = new NumIslands();
        char[][] grid = {
            {'0', '0', '0', '0'},
            {'0', '0', '0', '0'},
            {'0', '0', '0', '0'},
            {'0', '0', '0', '0'}
        };
        int expected = 0;
        int result = solution.numIslands(grid);
        assertEquals(expected, result);
    }
}
