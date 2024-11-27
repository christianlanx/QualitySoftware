package numIslands.gpt35Turbo.black;
import numIslands.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumIslandsTest {

    @Test
    void testNumIslandsExample1() {
        char[][] grid1 = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        NumIslands numIslands = new NumIslands();
        int result1 = numIslands.numIslands(grid1);
        assertEquals(1, result1);
    }

    @Test
    void testNumIslandsExample2() {
        char[][] grid2 = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        NumIslands numIslands = new NumIslands();
        int result2 = numIslands.numIslands(grid2);
        assertEquals(3, result2);
    }
}