package numIslands.claudeSonnet.prompt1;


import org.junit.Test;

import numIslands.NumIslands;

import org.junit.Before;
import static org.junit.Assert.*;

public class numIslandsclaudeSonnetTest {
    private NumIslands solution;

    @Before
    public void setUp() {
        solution = new NumIslands();
    }

    @Test
    public void testExample1() {
        char[][] grid = {
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'}
        };
        assertEquals(1, solution.numIslands(grid));
    }

    @Test
    public void testExample2() {
        char[][] grid = {
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','1'}
        };
        assertEquals(3, solution.numIslands(grid));
    }

    @Test
    public void testEmptyGrid() {
        char[][] grid = new char[0][0];
        assertEquals(0, solution.numIslands(grid));
    }

    @Test
    public void testSingleElementGrid() {
        char[][] grid = {{'1'}};
        assertEquals(1, solution.numIslands(grid));
        
        char[][] waterGrid = {{'0'}};
        assertEquals(0, solution.numIslands(waterGrid));
    }

    @Test
    public void testAllWater() {
        char[][] grid = {
            {'0','0','0'},
            {'0','0','0'},
            {'0','0','0'}
        };
        assertEquals(0, solution.numIslands(grid));
    }

    @Test
    public void testAllLand() {
        char[][] grid = {
            {'1','1','1'},
            {'1','1','1'},
            {'1','1','1'}
        };
        assertEquals(1, solution.numIslands(grid));
    }

    @Test
    public void testDiagonalIslands() {
        char[][] grid = {
            {'1','0','1'},
            {'0','0','0'},
            {'1','0','1'}
        };
        assertEquals(4, solution.numIslands(grid));
    }

    @Test
    public void testSingleRowGrid() {
        char[][] grid = {{'1', '0', '1', '0', '1'}};
        assertEquals(3, solution.numIslands(grid));
    }

    @Test
    public void testSingleColumnGrid() {
        char[][] grid = {
            {'1'},
            {'0'},
            {'1'},
            {'0'},
            {'1'}
        };
        assertEquals(3, solution.numIslands(grid));
    }

    @Test
    public void testComplexIslandShape() {
        char[][] grid = {
            {'1','1','0','1','0'},
            {'1','0','0','0','0'},
            {'1','1','0','1','0'},
            {'0','1','0','1','0'}
        };
        assertEquals(3, solution.numIslands(grid));
    }

    @Test
    public void testMaximumConstraints() {
        // Test with 300x300 grid (maximum constraints)
        char[][] grid = new char[300][300];
        // Fill with alternating 1s and 0s
        for (int i = 0; i < 300; i++) {
            for (int j = 0; j < 300; j++) {
                grid[i][j] = (i + j) % 2 == 0 ? '1' : '0';
            }
        }
        assertTrue(solution.numIslands(grid) > 0);
    }

    @Test(expected = NullPointerException.class)
    public void testNullGrid() {
        solution.numIslands(null);
    }
}