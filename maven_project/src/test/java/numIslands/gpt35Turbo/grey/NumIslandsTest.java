package numIslands.gpt35Turbo.grey;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumIslandsTest {

    @Test
    public void testNumIslandsExample1() {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        NumIslands numIslands = new NumIslands();
        assertEquals(1, numIslands.numIslands(grid));
    }

    @Test
    public void testNumIslandsExample2() {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        NumIslands numIslands = new NumIslands();
        assertEquals(3, numIslands.numIslands(grid));
    }

}