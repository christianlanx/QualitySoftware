package numIslands.gpto1Mini.white;
import numIslands.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NumIslandsTest {

    private final NumIslands numIslands = new NumIslands();

    @Test
    void testEmptyGrid() {
        char[][] grid = {};
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            numIslands.numIslands(grid);
        }, "Expected to throw ArrayIndexOutOfBoundsException for empty grid");
    }

    @Test
    void testSingleCellWater() {
        char[][] grid = { {'0'} };
        assertEquals(0, numIslands.numIslands(grid), "Expected 0 islands for single water cell");
    }

    @Test
    void testSingleCellLand() {
        char[][] grid = { {'1'} };
        assertEquals(1, numIslands.numIslands(grid), "Expected 1 island for single land cell");
    }

    @Test
    void testMultipleIslands() {
        char[][] grid = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };
        assertEquals(3, numIslands.numIslands(grid), "Expected 3 islands");
    }

    @Test
    void testAllWater() {
        char[][] grid = {
            {'0', '0', '0'},
            {'0', '0', '0'},
            {'0', '0', '0'}
        };
        assertEquals(0, numIslands.numIslands(grid), "Expected 0 islands when all cells are water");
    }

    @Test
    void testAllLand() {
        char[][] grid = {
            {'1', '1', '1'},
            {'1', '1', '1'},
            {'1', '1', '1'}
        };
        assertEquals(1, numIslands.numIslands(grid), "Expected 1 island when all cells are land");
    }

    @Test
    void testDisconnectedIslands() {
        char[][] grid = {
            {'1', '0', '1', '0', '1'},
            {'0', '1', '0', '1', '0'},
            {'1', '0', '1', '0', '1'},
            {'0', '1', '0', '1', '0'}
        };
        assertEquals(8, numIslands.numIslands(grid), "Expected 8 disconnected islands");
    }

    @Test
    void testSingleRow() {
        char[][] grid = { {'1', '1', '0', '1'} };
        assertEquals(2, numIslands.numIslands(grid), "Expected 2 islands in single row");
    }

    @Test
    void testSingleColumn() {
        char[][] grid = {
            {'1'},
            {'1'},
            {'0'},
            {'1'}
        };
        assertEquals(2, numIslands.numIslands(grid), "Expected 2 islands in single column");
    }

    @Test
    void testLargeGrid() {
        char[][] grid = new char[100][100];
        for(int i=0; i<100; i++) {
            for(int j=0; j<100; j++) {
                grid[i][j] = (i == j) ? '1' : '0';
            }
        }
        assertEquals(100, numIslands.numIslands(grid), "Expected 100 diagonal islands in large grid");
    }
}