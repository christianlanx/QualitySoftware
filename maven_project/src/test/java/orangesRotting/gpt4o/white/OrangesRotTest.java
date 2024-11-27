package orangesRotting.gpt4o.white;
import orangesRotting.*;

import orangesRotting.OrangesRot;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrangesRotTest {

    private final OrangesRot orangesRot = new OrangesRot();

    @Test
    public void testAllRottenOranges() {
        int[][] grid = {
            {2, 2, 2},
            {2, 2, 2},
            {2, 2, 2}
        };
        assertEquals(0, orangesRot.orangesRotting(grid), "All oranges are already rotten, no minutes needed");
    }
    
    @Test
    public void testSingleFreshOrange() {
        int[][] grid = {
            {0, 1, 0}
        };
        assertEquals(-1, orangesRot.orangesRotting(grid), "Single fresh orange cannot rot");
    }

    @Test
    public void testMixedGrid() {
        int[][] grid = {
            {2, 1, 0},
            {1, 1, 0},
            {0, 1, 1}
        };
        assertEquals(4, orangesRot.orangesRotting(grid), "Mixed grid requires 4 minutes for every orange to rot");
    }
    
    @Test
    public void testGridWithIsolatedFreshOrange() {
        int[][] grid = {
            {2, 0, 0},
            {0, 1, 0},
            {0, 0, 0}
        };
        assertEquals(-1, orangesRot.orangesRotting(grid), "Isolated fresh orange cannot rot");
    }
    
    @Test
    public void testEmptyGrid() {
        int[][] grid = {};
        assertEquals(0, orangesRot.orangesRotting(grid), "Empty grid should return 0");
    }
    
    @Test
    public void testNoOranges() {
        int[][] grid = {
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
        };
        assertEquals(0, orangesRot.orangesRotting(grid), "No oranges in grid should return 0");
    }
    
    @Test
    public void testMultipleRottingPaths() {
        int[][] grid = {
            {2, 1, 1},
            {1, 1, 1},
            {0, 1, 2}
        };
        assertEquals(2, orangesRot.orangesRotting(grid), "Parallel rotting paths require 2 minutes");
    }
}