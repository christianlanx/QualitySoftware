package numIslands.ai21Jamba15Mini.white;
import numIslands.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Queue;
import java.util.LinkedList;

public class NumIslandsTest {

    @Test
    void testNumIslands_EmptyGrid() {
        char[][] grid = {};
        assertEquals(0, new NumIslands().numIslands(grid));
    }

    @Test
    void testNumIslands_SingleIsland() {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        assertEquals(1, new NumIslands().numIslands(grid));
    }

    @Test
    void testNumIslands_MultipleIslands() {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'},
                {'0', '0', '0', '0', '1'}
        };
        assertEquals(2, new NumIslands().numIslands(grid));
    }

    @Test
    void testNumIslands_NoIslands() {
        char[][] grid = {
                {'0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        assertEquals(0, new NumIslands().numIslands(grid));
    }

    @Test
    void testNumIslands_IslandOnEdge() {
        char[][] grid = {
                {'0', '0', '1', '0', '0'},
                {'0', '1', '1', '0', '0'},
                {'0', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        assertEquals(1, new NumIslands().numIslands(grid));
    }

    @Test
    void testNumIslands_ComplexGrid() {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '1', '0', '0'},
                {'0', '1', '1', '1', '0'},
                {'0', '0', '0', '1', '1'},
                {'0', '0', '0', '0', '0'}
        };
        assertEquals(2, new NumIslands().numIslands(grid));
    }
}