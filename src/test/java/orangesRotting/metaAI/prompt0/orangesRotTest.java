package orangesRotting.metaAI.prompt0;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import orangesRotting.OrangesRot;

public class orangesRotTest {

    OrangesRot rot = new OrangesRot();

    // Test no oranges
    @Test
    public void testNoOranges() {
        int[][] grid = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        assertEquals(0, rot.orangesRotting(grid));
    }

    // Test no rotten oranges
    @Test
    public void testNoRottenOranges() {
        int[][] grid = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        assertEquals(-1, rot.orangesRotting(grid));
    }

    // Test all rotten oranges
    @Test
    public void testAllRottenOranges() {
        int[][] grid = {{2, 2, 2}, {2, 2, 2}, {2, 2, 2}};
        assertEquals(0, rot.orangesRotting(grid));
    }

    // Test valid scenarios
    @Test
    public void testValidScenarios() {
        int[][] grid1 = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        assertEquals(4, rot.orangesRotting(grid1));

        int[][] grid2 = {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
        assertEquals(3, rot.orangesRotting(grid2));
    }

    // Test edge cases
    @Test
    public void testEdgeCases() {
        int[][] grid1 = {{2}};
        assertEquals(0, rot.orangesRotting(grid1));

        int[][] grid2 = {{1}};
        assertEquals(-1, rot.orangesRotting(grid2));
    }

    // Test invalid scenarios (all oranges can't be rotten)
    @Test
    public void testInvalidScenarios() {
        int[][] grid1 = {{2, 1, 1}, {1, 0, 1}, {0, 1, 2}};
        assertEquals(-1, rot.orangesRotting(grid1));

        int[][] grid2 = {{1, 2}, {0, 1}};
        assertEquals(-1, rot.orangesRotting(grid2));
    }
}