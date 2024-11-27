package numIslands.gpt4oMini.white;
import numIslands.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NumIslandsTest {

    private NumIslands numIslands;

    @BeforeEach
    public void setUp() {
        numIslands = new NumIslands();
    }

    @Test
    public void testEmptyGrid() {
        char[][] grid = {};
        assertEquals(0, numIslands.numIslands(grid));
    }

    @Test
    public void testGridWithNoIslands() {
        char[][] grid = {
            {'0', '0', '0'},
            {'0', '0', '0'},
            {'0', '0', '0'}
        };
        assertEquals(0, numIslands.numIslands(grid));
    }

    @Test
    public void testGridWithOneIsland() {
        char[][] grid = {
            {'1', '1', '0'},
            {'1', '0', '0'},
            {'0', '0', '0'}
        };
        assertEquals(1, numIslands.numIslands(grid));
    }

    @Test
    public void testGridWithMultipleIslands() {
        char[][] grid = {
            {'1', '1', '0', '0', '0'},
            {'1', '0', '0', '1', '1'},
            {'0', '0', '0', '1', '0'},
            {'0', '1', '0', '0', '0'}
        };
        assertEquals(3, numIslands.numIslands(grid));
    }

    @Test
    public void testGridWithDiagonalIslands() {
        char[][] grid = {
            {'1', '0', '0', '1'},
            {'0', '1', '0', '0'},
            {'0', '0', '1', '1'},
            {'0', '0', '0', '1'}
        };
        assertEquals(5, numIslands.numIslands(grid));
    }

    @Test
    public void testGridWithTouchingIslands() {
        char[][] grid = {
            {'1', '1', '0', '1'},
            {'1', '0', '0', '1'},
            {'0', '0', '1', '1'},
            {'0', '1', '1', '0'}
        };
        assertEquals(3, numIslands.numIslands(grid));
    }

    @Test
    public void testLargeGrid() {
        char[][] grid = {
            {'1', '1', '0', '0', '0', '1', '1'},
            {'1', '1', '0', '0', '0', '0', '0'},
            {'0', '0', '1', '1', '1', '0', '0'},
            {'0', '0', '1', '0', '0', '0', '1'},
            {'1', '1', '0', '0', '1', '1', '0'}
        };
        assertEquals(5, numIslands.numIslands(grid));
    }
}