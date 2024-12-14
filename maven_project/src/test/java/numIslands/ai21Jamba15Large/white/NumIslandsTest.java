package numIslands.ai21Jamba15Large.white;

import numIslands.NumIslands;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class NumIslandsTest {

    @Test
    void testNumIslandsEmptyGrid() {
        NumIslands numIslands = new NumIslands();
        char[][] grid = new char[][]{};
        int expected = 0;
        int actual = numIslands.numIslands(grid);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testNumIslandsSingleIsland() {
        NumIslands numIslands = new NumIslands();
        char[][] grid = new char[][]{
            {'1'}
        };
        int expected = 1;
        int actual = numIslands.numIslands(grid);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testNumIslandsMultipleIslands() {
        NumIslands numIslands = new NumIslands();
        char[][] grid = new char[][]{
            {'1', '0', '1'},
            {'0', '1', '0'},
            {'1', '0', '1'}
        };
        int expected = 5;
        int actual = numIslands.numIslands(grid);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testNumIslandsNoIslands() {
        NumIslands numIslands = new NumIslands();
        char[][] grid = new char[][]{
            {'0', '0', '0'},
            {'0', '0', '0'},
            {'0', '0', '0'}
        };
        int expected = 0;
        int actual = numIslands.numIslands(grid);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testNumIslandsLargeGrid() {
        NumIslands numIslands = new NumIslands();
        char[][] grid = new char[][]{
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'},
            {'0', '0', '0', '1', '1'}
        };
        int expected = 3;
        int actual = numIslands.numIslands(grid);
        Assertions.assertEquals(expected, actual);
    }
}