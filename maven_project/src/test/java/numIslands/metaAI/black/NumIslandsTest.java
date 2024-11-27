package numIslands.metaAI.black;
import numIslands.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NumIslandsTest {

    private NumIslands numIslands = new NumIslands();

    @Test
    public void testNumIslands_Example1() {
        char[][] grid = {
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '0'}
        };
        int expected = 1;
        int actual = numIslands.numIslands(grid);
        assertEquals(expected, actual);
    }

    @Test
    public void testNumIslands_Example2() {
        char[][] grid = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };
        int expected = 3;
        int actual = numIslands.numIslands(grid);
        assertEquals(expected, actual);
    }

    @Test
    public void testNumIslands_EmptyGrid() {
        char[][] grid = {};
        int expected = 0;
        int actual = numIslands.numIslands(grid);
        assertEquals(expected, actual);
    }

    @Test
    public void testNumIslands_GridWithNoIslands() {
        char[][] grid = {
            {'0', '0', '0', '0', '0'},
            {'0', '0', '0', '0', '0'},
            {'0', '0', '0', '0', '0'},
            {'0', '0', '0', '0', '0'}
        };
        int expected = 0;
        int actual = numIslands.numIslands(grid);
        assertEquals(expected, actual);
    }

    @Test
    public void testNumIslands_GridWithOneIsland() {
        char[][] grid = {
            {'1', '1', '1', '1', '1'},
            {'1', '1', '1', '1', '1'},
            {'1', '1', '1', '1', '1'},
            {'1', '1', '1', '1', '1'}
        };
        int expected = 1;
        int actual = numIslands.numIslands(grid);
        assertEquals(expected, actual);
    }
}