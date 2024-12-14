package numIslands.gpt4o.grey;

import numIslands.NumIslands;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NumIslandsTest {

    @Test
    public void testSingleIsland() {
        NumIslands solution = new NumIslands();
        char[][] grid = {
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '0'}
        };
        assertEquals(1, solution.numIslands(grid));
    }

    @Test
    public void testMultipleIslands() {
        NumIslands solution = new NumIslands();
        char[][] grid = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };
        assertEquals(3, solution.numIslands(grid));
    }

    @Test
    public void testNoIslands() {
        NumIslands solution = new NumIslands();
        char[][] grid = {
            {'0', '0', '0', '0', '0'},
            {'0', '0', '0', '0', '0'},
            {'0', '0', '0', '0', '0'},
            {'0', '0', '0', '0', '0'}
        };
        assertEquals(0, solution.numIslands(grid));
    }

    @Test
    public void testAllLand() {
        NumIslands solution = new NumIslands();
        char[][] grid = {
            {'1', '1', '1', '1', '1'},
            {'1', '1', '1', '1', '1'},
            {'1', '1', '1', '1', '1'},
            {'1', '1', '1', '1', '1'}
        };
        assertEquals(1, solution.numIslands(grid));
    }

    @Test
    public void testEdgeCases() {
        NumIslands solution = new NumIslands();
        
        // Single cell island
        char[][] singleCellIsland = {{'1'}};
        assertEquals(1, solution.numIslands(singleCellIsland));

        // Single cell water
        char[][] singleCellWater = {{'0'}};
        assertEquals(0, solution.numIslands(singleCellWater));
    }

    @Test
    public void testDifferentConnectedComponents() {
        NumIslands solution = new NumIslands();
        char[][] grid = {
            {'1', '0', '1', '0', '0'},
            {'1', '0', '1', '1', '0'},
            {'0', '0', '1', '0', '0'},
            {'1', '1', '0', '1', '1'}
        };
        assertEquals(4, solution.numIslands(grid));
    }
}