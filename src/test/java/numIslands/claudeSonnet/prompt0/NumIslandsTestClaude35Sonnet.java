package numIslands.claudeSonnet.prompt0;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import numIslands.NumIslands;

public class NumIslandsTestClaude35Sonnet {
    private NumIslands solution;

    @Before
    public void setUp() {
        solution = new NumIslands();
    }

    // @Test
    // public void testEmptyGrid() {
    //     char[][] grid = new char[0][0];
    //     assertEquals(0, solution.numIslands(grid));
    // }

    @Test
    public void testSingleCellGrid_Island() {
        char[][] grid = {{'1'}};
        assertEquals(1, solution.numIslands(grid));
    }

    @Test
    public void testSingleCellGrid_Water() {
        char[][] grid = {{'0'}};
        assertEquals(0, solution.numIslands(grid));
    }

    @Test
    public void testAllWater() {
        char[][] grid = {
            {'0', '0', '0'},
            {'0', '0', '0'},
            {'0', '0', '0'}
        };
        assertEquals(0, solution.numIslands(grid));
    }

    @Test
    public void testAllLand() {
        char[][] grid = {
            {'1', '1', '1'},
            {'1', '1', '1'},
            {'1', '1', '1'}
        };
        assertEquals(1, solution.numIslands(grid));
    }

    // @Test
    // public void testMultipleIslands() {
    //     char[][] grid = {
    //         {'1', '0', '1', '0'},
    //         {'0', '1', '0', '1'},
    //         {'1', '0', '1', '0'}
    //     };
    //     assertEquals(5, solution.numIslands(grid));
    // }

    @Test
    public void testSingleRowGrid() {
        char[][] grid = {{'1', '0', '1', '1', '0', '1'}};
        assertEquals(3, solution.numIslands(grid));
    }

    @Test
    public void testSingleColumnGrid() {
        char[][] grid = {
            {'1'},
            {'0'},
            {'1'},
            {'1'}
        };
        assertEquals(2, solution.numIslands(grid));
    }

    @Test
    public void testComplexIslandShapes() {
        char[][] grid = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };
        assertEquals(3, solution.numIslands(grid));
    }

    @Test
    public void testDiagonalIslands() {
        char[][] grid = {
            {'1', '0', '0'},
            {'0', '1', '0'},
            {'0', '0', '1'}
        };
        assertEquals(3, solution.numIslands(grid));
    }

    @Test
    public void testLargeGrid() {
        char[][] grid = new char[1000][1000];
        // Fill with water
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                grid[i][j] = '0';
            }
        }
        // Add a few islands
        grid[0][0] = '1';
        grid[999][999] = '1';
        grid[500][500] = '1';
        assertEquals(3, solution.numIslands(grid));
    }

    @Test
    public void testIslandWithHole() {
        char[][] grid = {
            {'1', '1', '1'},
            {'1', '0', '1'},
            {'1', '1', '1'}
        };
        assertEquals(1, solution.numIslands(grid));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testInvalidGrid_Empty2DArray() {
        char[][] grid = new char[0][];
        solution.numIslands(grid);
    }

    @Test(expected = NullPointerException.class)
    public void testNullGrid() {
        solution.numIslands(null);
    }
}