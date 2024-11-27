package numIslands.claude35Haiku.black;
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
    void testSingleIsland() {
        char[][] grid = {
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'}
        };
        assertEquals(1, numIslands.numIslands(grid));
    }

    @Test
    void testMultipleIslands() {
        char[][] grid = {
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','1'}
        };
        assertEquals(3, numIslands.numIslands(grid));
    }

    @Test
    void testNoIslands() {
        char[][] grid = {
            {'0','0','0'},
            {'0','0','0'},
            {'0','0','0'}
        };
        assertEquals(0, numIslands.numIslands(grid));
    }

    @Test
    void testSingleCellIsland() {
        char[][] grid = {
            {'1'}
        };
        assertEquals(1, numIslands.numIslands(grid));
    }

    @Test
    void testAllLandGrid() {
        char[][] grid = {
            {'1','1','1'},
            {'1','1','1'},
            {'1','1','1'}
        };
        assertEquals(1, numIslands.numIslands(grid));
    }

    @Test
    void testIrregularGrid() {
        char[][] grid = {
            {'1','0','1','1','0','1','1'}
        };
        assertEquals(3, numIslands.numIslands(grid));
    }

    @Test
    void testNullGrid() {
        assertThrows(IllegalArgumentException.class, () -> {
            numIslands.numIslands(null);
        });
    }

    @Test
    void testEmptyGrid() {
        char[][] grid = {};
        assertEquals(0, numIslands.numIslands(grid));
    }

    @Test
    void testLargeGrid() {
        char[][] grid = new char[300][300];
        for (int i = 0; i < 300; i++) {
            for (int j = 0; j < 300; j++) {
                grid[i][j] = '1';
            }
        }
        assertEquals(1, numIslands.numIslands(grid));
    }
}