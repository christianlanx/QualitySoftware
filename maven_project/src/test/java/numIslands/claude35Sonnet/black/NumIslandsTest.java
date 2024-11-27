package numIslands.claude35Sonnet.black;
import numIslands.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class NumIslandsTest {
    private NumIslands numIslands;

    @BeforeEach
    void setUp() {
        numIslands = new NumIslands();
    }

    @Test
    void testEmptyGrid() {
        char[][] grid = new char[0][0];
        assertEquals(0, numIslands.numIslands(grid));
    }

    @Test
    void testSingleElementGrid_Water() {
        char[][] grid = {{'0'}};
        assertEquals(0, numIslands.numIslands(grid));
    }

    @Test
    void testSingleElementGrid_Land() {
        char[][] grid = {{'1'}};
        assertEquals(1, numIslands.numIslands(grid));
    }

    @Test
    void testOneIsland() {
        char[][] grid = {
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '0'}
        };
        assertEquals(1, numIslands.numIslands(grid));
    }

    @Test
    void testThreeIslands() {
        char[][] grid = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };
        assertEquals(3, numIslands.numIslands(grid));
    }

    @Test
    void testNoIslands() {
        char[][] grid = {
            {'0', '0', '0'},
            {'0', '0', '0'},
            {'0', '0', '0'}
        };
        assertEquals(0, numIslands.numIslands(grid));
    }

    @Test
    void testAllLand() {
        char[][] grid = {
            {'1', '1', '1'},
            {'1', '1', '1'},
            {'1', '1', '1'}
        };
        assertEquals(1, numIslands.numIslands(grid));
    }

    @Test
    void testDiagonalIslands() {
        char[][] grid = {
            {'1', '0', '1'},
            {'0', '1', '0'},
            {'1', '0', '1'}
        };
        assertEquals(5, numIslands.numIslands(grid));
    }

    @Test
    void testSingleRowGrid() {
        char[][] grid = {{'1', '0', '1', '1', '0', '1'}};
        assertEquals(3, numIslands.numIslands(grid));
    }

    @Test
    void testSingleColumnGrid() {
        char[][] grid = {
            {'1'},
            {'0'},
            {'1'},
            {'1'}
        };
        assertEquals(2, numIslands.numIslands(grid));
    }

    @Test
    void testNullGrid() {
        assertThrows(NullPointerException.class, () -> numIslands.numIslands(null));
    }
}