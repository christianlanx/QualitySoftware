package numIslands.ai21Jamba.prompt1;
import numIslands.NumIslands;

import org.junit.Assert;
import org.junit.Test;

public class NumIslandsTest {

    @Test
    public void testNumIslands_SingleIsland() {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        NumIslands numIslands = new NumIslands();
        int result = numIslands.numIslands(grid);

        Assert.assertEquals(1, result);
    }

    @Test
    public void testNumIslands_MultipleIslands() {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        NumIslands numIslands = new NumIslands();
        int result = numIslands.numIslands(grid);

        Assert.assertEquals(3, result);
    }

    @Test
    public void testNumIslands_NoIslands() {
        char[][] grid = {
                {'0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        NumIslands numIslands = new NumIslands();
        int result = numIslands.numIslands(grid);

        Assert.assertEquals(0, result);
    }

    @Test
    public void testNumIslands_AllLand() {
        char[][] grid = {
                {'1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1'}
        };

        NumIslands numIslands = new NumIslands();
        int result = numIslands.numIslands(grid);

        Assert.assertEquals(1, result);
    }

    @Test
    public void testNumIslands_EdgeCases() {
        char[][] grid = {
                {'1'}
        };

        NumIslands numIslands = new NumIslands();
        int result = numIslands.numIslands(grid);

        Assert.assertEquals(1, result);
    }

    @Test
    public void testNumIslands_EmptyGrid() {
        char[][] grid = {};

        NumIslands numIslands = new NumIslands();
        int result = numIslands.numIslands(grid);

        Assert.assertEquals(0, result);
    }
}