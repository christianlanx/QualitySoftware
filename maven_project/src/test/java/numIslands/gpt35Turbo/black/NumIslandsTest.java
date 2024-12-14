package numIslands.gpt35Turbo.black;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import numIslands.NumIslands;

public class NumIslandsTest {

    private NumIslands numIslands;

    @BeforeEach
    public void setUp() {
        numIslands = new NumIslands();
    }

    @Test
    public void testNumIslandsExample1() {
        char[][] grid = {
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'}
        };
        int expected = 1;
        int result = numIslands.numIslands(grid);
        assertEquals(expected, result);
    }

    @Test
    public void testNumIslandsExample2() {
        char[][] grid = {
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','1'}
        };
        int expected = 3;
        int result = numIslands.numIslands(grid);
        assertEquals(expected, result);
    }

    // Add more test cases if needed...
}