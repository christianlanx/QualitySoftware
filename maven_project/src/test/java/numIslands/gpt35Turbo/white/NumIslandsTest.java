package numIslands.gpt35Turbo.white;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NumIslandsTest {
    
    private NumIslands numIslands;

    @BeforeEach
    void setup() {
        numIslands = new NumIslands();
    }

    @Test
    void testNumIslands_GridWithOneIsland_ReturnsOne() {
        char[][] grid = {{'1','1','0','0','0'},
                         {'1','1','0','0','0'},
                         {'0','0','1','0','0'},
                         {'0','0','0','1','1'}};
        int result = numIslands.numIslands(grid);
        assertEquals(3, result);
    }

    @Test
    void testNumIslands_GridWithMultipleIslands_ReturnsCorrectCount() {
        char[][] grid = {{'1','1','1','1','0'},
                         {'1','1','0','1','0'},
                         {'1','1','0','0','1'},
                         {'0','0','1','1','0'}};
        int result = numIslands.numIslands(grid);
        assertEquals(5, result);
    }

    // Add more test cases as needed
}