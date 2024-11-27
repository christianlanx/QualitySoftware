package numIslands.gpt35Turbo.white;
import numIslands.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NumIslandsTest {
    
    private NumIslands numIslands;
    
    @BeforeEach
    void setUp() {
        numIslands = new NumIslands();
    }

    @Test
    void testNumIslands() {
        char[][] grid1 = {
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '0'}
        };
        assertEquals(1, numIslands.numIslands(grid1));
        
        char[][] grid2 = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };
        assertEquals(3, numIslands.numIslands(grid2));
        
        char[][] grid3 = {
            {'1', '0', '1', '1', '0'},
            {'1', '0', '1', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '1', '1'}
        };
        assertEquals(3, numIslands.numIslands(grid3));
    }
}