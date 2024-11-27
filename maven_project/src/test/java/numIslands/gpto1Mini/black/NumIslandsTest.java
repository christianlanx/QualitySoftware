package numIslands.gpto1Mini.black;
import numIslands.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumIslandsTest {

    private final NumIslands solution = new NumIslands();

    @Test
    void testExample1() {
        char[][] grid = {
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'}
        };
        assertEquals(1, solution.numIslands(grid));
    }

    @Test
    void testExample2() {
        char[][] grid = {
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','1'}
        };
        assertEquals(3, solution.numIslands(grid));
    }

    @Test
    void testSingleCellLand() {
        char[][] grid = { {'1'} };
        assertEquals(1, solution.numIslands(grid));
    }

    @Test
    void testSingleCellWater() {
        char[][] grid = { {'0'} };
        assertEquals(0, solution.numIslands(grid));
    }

    @Test
    void testAllWater() {
        char[][] grid = {
            {'0','0','0'},
            {'0','0','0'},
            {'0','0','0'}
        };
        assertEquals(0, solution.numIslands(grid));
    }

    @Test
    void testAllLand() {
        char[][] grid = {
            {'1','1','1'},
            {'1','1','1'},
            {'1','1','1'}
        };
        assertEquals(1, solution.numIslands(grid));
    }

    @Test
    void testMultipleIslands() {
        char[][] grid = {
            {'1','0','1','0','1'},
            {'0','1','0','1','0'},
            {'1','0','1','0','1'},
            {'0','1','0','1','0'}
        };
        assertEquals(9, solution.numIslands(grid));
    }

    @Test
    void testLShapeIslands() {
        char[][] grid = {
            {'1','1','0','0'},
            {'1','0','0','1'},
            {'0','0','1','1'},
            {'0','1','1','0'}
        };
        assertEquals(4, solution.numIslands(grid));
    }

    @Test
    void testDisconnectedSingleCells() {
        char[][] grid = {
            {'1','0','1'},
            {'0','0','0'},
            {'1','0','1'}
        };
        assertEquals(4, solution.numIslands(grid));
    }
}