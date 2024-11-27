package numIslands.mistralSmall.white;
import numIslands.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NumIslandsTest {

    @Test
    public void testNumIslands() {
        NumIslands numIslands = new NumIslands();

        char[][] grid1 = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };
        int result1 = numIslands.numIslands(grid1);
        assertEquals(3, result1);

        char[][] grid2 = {
            {'1', '1', '0'},
            {'0', '1', '1'},
            {'0', '0', '0'}
        };
        int result2 = numIslands.numIslands(grid2);
        assertEquals(2, result2);

        char[][] grid3 = {
            {'1', '1', '1'},
            {'1', '1', '1'},
            {'1', '1', '1'}
        };
        int result3 = numIslands.numIslands(grid3);
        assertEquals(1, result3);

        char[][] grid4 = {
            {'0', '0', '0'},
            {'0', '0', '0'},
            {'0', '0', '0'}
        };
        int result4 = numIslands.numIslands(grid4);
        assertEquals(0, result4);

        char[][] grid5 = {
            {'1', '1', '0', '0'},
            {'0', '0', '1', '1'},
            {'0', '1', '0', '0'},
            {'1', '0', '0', '1'}
        };
        int result5 = numIslands.numIslands(grid5);
        assertEquals(4, result5);
    }
}