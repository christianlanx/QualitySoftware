package numIslands.ai21Jamba15Large.black;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import numIslands.NumIslands;

public class NumIslandsTest {

    private NumIslands numIslands = new NumIslands();

    @Test
    void testSingleIsland() {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        int expected = 1;
        assertEquals(expected, numIslands.numIslands(grid));
    }

    @Test
    void testMultipleIslands() {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        int expected = 3;
        assertEquals(expected, numIslands.numIslands(grid));
    }

    @Test
    void testNoIslands() {
        char[][] grid = {
                {'0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        int expected = 0;
        assertEquals(expected, numIslands.numIslands(grid));
    }

    @Test
    void testAllIslands() {
        char[][] grid = {
                {'1', '1', '1'},
                {'1', '1', '1'},
                {'1', '1', '1'}
        };
        int expected = 1;
        assertEquals(expected, numIslands.numIslands(grid));
    }

    @Test
    void testComplexGrid() {
        char[][] grid = {
                {'1', '1', '0', '0', '0', '0', '1', '1', '0', '0'},
                {'1', '1', '0', '1', '1', '0', '1', '1', '0', '0'},
                {'0', '0', '1', '0', '0', '1', '0', '0', '1', '1'},
                {'0', '0', '0', '1', '1', '0', '0', '0', '0', '0'},
                {'0', '1', '0', '0', '0', '0', '1', '1', '0', '0'}
        };
        int expected = 5;
        assertEquals(expected, numIslands.numIslands(grid));
    }
}