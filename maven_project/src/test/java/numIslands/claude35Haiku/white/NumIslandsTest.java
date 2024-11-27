package numIslands.claude35Haiku.white;
import numIslands.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NumIslandsTest {
    private NumIslands numIslands;

    @BeforeEach
    void setUp() {
        numIslands = new NumIslands();
    }

    @Test
    void testEmptyGrid() {
        char[][] grid = {};
        assertEquals(0, numIslands.numIslands(grid));
    }

    @Test
    void testGridWithNoIslands() {
        char[][] grid = {
            {'0', '0', '0'},
            {'0', '0', '0'},
            {'0', '0', '0'}
        };
        assertEquals(0, numIslands.numIslands(grid));
    }

    @Test
    void testGridWithSingleIsland() {
        char[][] grid = {
            {'1', '1', '1'},
            {'1', '1', '1'},
            {'1', '1', '1'}
        };
        assertEquals(1, numIslands.numIslands(grid));
    }

    @Test
    void testGridWithMultipleIslands() {
        char[][] grid = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };
        assertEquals(3, numIslands.numIslands(grid));
    }

    @Test
    void testGridWithAdjacentIslands() {
        char[][] grid = {
            {'1', '1', '1'},
            {'0', '1', '0'},
            {'1', '1', '1'}
        };
        assertEquals(1, numIslands.numIslands(grid));
    }

    @Test
    void testGridWithDiagonallyAdjacentIslands() {
        char[][] grid = {
            {'1', '0', '1'},
            {'0', '0', '0'},
            {'1', '0', '1'}
        };
        assertEquals(4, numIslands.numIslands(grid));
    }

    @Test
    void testLargeGrid() {
        char[][] grid = new char[100][100];
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                grid[i][j] = (i % 2 == 0 && j % 2 == 0) ? '1' : '0';
            }
        }
        assertEquals(2500, numIslands.numIslands(grid));
    }

    @Test
    void testGridWithSingleCell() {
        char[][] grid = {{'1'}};
        assertEquals(1, numIslands.numIslands(grid));
    }

    @Test
    void testGridWithSingleCellZero() {
        char[][] grid = {{'0'}};
        assertEquals(0, numIslands.numIslands(grid));
    }
}