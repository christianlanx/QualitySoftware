package numIslands.gpt4o.white;
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
    public void testNoIslands() {
        char[][] grid = {
            {'0', '0', '0'},
            {'0', '0', '0'},
            {'0', '0', '0'}
        };
        assertEquals(0, numIslands.numIslands(grid));
    }

    @Test
    public void testOneIsland() {
        char[][] grid = {
            {'1', '1', '1'},
            {'0', '1', '0'},
            {'0', '0', '0'}
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
    public void testConnectedHorizontallyAndVertically() {
        char[][] grid = {
            {'1', '0', '1', '1', '0'},
            {'1', '0', '1', '0', '0'},
            {'1', '1', '1', '0', '1'},
            {'0', '1', '0', '1', '1'}
        };
        assertEquals(2, numIslands.numIslands(grid));
    }

    @Test
    public void testSingleElementIsland() {
        char[][] grid = {
            {'1'}
        };
        assertEquals(1, numIslands.numIslands(grid));
    }

    @Test
    public void testSingleElementNonIsland() {
        char[][] grid = {
            {'0'}
        };
        assertEquals(0, numIslands.numIslands(grid));
    }

    @Test
    public void testLargeGridNoIslands() {
        char[][] grid = new char[100][100];
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                grid[i][j] = '0';
            }
        }
        assertEquals(0, numIslands.numIslands(grid));
    }

    @Test
    public void testLargeGridFullIsland() {
        char[][] grid = new char[100][100];
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                grid[i][j] = '1';
            }
        }
        assertEquals(1, numIslands.numIslands(grid));
    }
}