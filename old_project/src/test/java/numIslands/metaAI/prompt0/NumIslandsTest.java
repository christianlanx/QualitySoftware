package numIslands.metaAI.prompt0;
import numIslands.NumIslands;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class NumIslandsTest {

    NumIslands numIslands = new NumIslands();

    // Test no islands
    @Test
    public void testNoIslands() {
        char[][] grid = {{'0', '0', '0'}, {'0', '0', '0'}};
        assertEquals(0, numIslands.numIslands(grid));
    }

    // Test single island
    @Test
    public void testSingleIsland() {
        char[][] grid = {{'1', '1', '1'}, {'1', '1', '1'}};
        assertEquals(1, numIslands.numIslands(grid));
    }

    // Test multiple islands
    @Test
    public void testMultipleIslands() {
        char[][] grid1 = {{'1', '1', '0'}, {'1', '0', '1'}};
        assertEquals(2, numIslands.numIslands(grid1));

        char[][] grid2 = {{'1', '1', '0', '0'}, {'0', '1', '1', '0'}, {'0', '0', '1', '0'}};
        assertEquals(2, numIslands.numIslands(grid2));
    }

    // Test edge cases
    @Test
    public void testEdgeCases() {
        char[][] grid1 = {{'1'}};
        assertEquals(1, numIslands.numIslands(grid1));

        char[][] grid2 = {{'0', '0'}, {'0', '0'}};
        assertEquals(0, numIslands.numIslands(grid2));
    }

    // Test complex scenarios
    @Test
    public void testComplexScenarios() {
        char[][] grid1 = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };
        assertEquals(3, numIslands.numIslands(grid1));

        char[][] grid2 = {
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '0'}
        };
        assertEquals(1, numIslands.numIslands(grid2));
    }
}