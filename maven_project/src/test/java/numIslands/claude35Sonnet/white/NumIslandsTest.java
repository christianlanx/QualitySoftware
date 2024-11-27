package numIslands.claude35Sonnet.white;
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
    void testSingleIsland() {
        char[][] grid = {
            {'1', '1', '1'},
            {'1', '1', '1'},
            {'1', '1', '1'}
        };
        assertEquals(1, numIslands.numIslands(grid));
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
    void testMultipleIslands() {
        char[][] grid = {
            {'1', '0', '1'},
            {'0', '1', '0'},
            {'1', '0', '1'}
        };
        assertEquals(5, numIslands.numIslands(grid));
    }

    @Test
    void testSingleCellIsland() {
        char[][] grid = {
            {'1'}
        };
        assertEquals(1, numIslands.numIslands(grid));
    }

    @Test
    void testEmptyGrid() {
        char[][] grid = {
            {}
        };
        assertEquals(0, numIslands.numIslands(grid));
    }

    @Test
    void testLongIsland() {
        char[][] grid = {
            {'1', '1', '1'},
            {'0', '0', '0'},
            {'1', '1', '1'}
        };
        assertEquals(2, numIslands.numIslands(grid));
    }

    @Test
    void testDisconnectedIslands() {
        char[][] grid = {
            {'1', '0', '0', '1'},
            {'0', '1', '1', '0'},
            {'0', '0', '0', '1'}
        };
        assertEquals(4, numIslands.numIslands(grid));
    }

    @Test
    void testIrregularShapedIsland() {
        char[][] grid = {
            {'1', '1', '0'},
            {'1', '0', '0'},
            {'0', '0', '1'}
        };
        assertEquals(2, numIslands.numIslands(grid));
    }

    @Test
    void testLargeGrid() {
        char[][] grid = new char[1000][1000];
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                grid[i][j] = '0';
            }
        }
        grid[0][0] = '1';
        grid[999][999] = '1';
        assertEquals(2, numIslands.numIslands(grid));
    }
}