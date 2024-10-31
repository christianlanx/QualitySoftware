package orangesRotting.ai21Jamba.prompt0;
import orangesRotting.orangesRot;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class orangesRotTest {

    @Test
    public void testOrangesRotting() {
        orangesRot orangesRot = new orangesRot();

        // Test case 1: No oranges
        int[][] grid1 = {
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
        };
        assertEquals(0, orangesRot.orangesRotting(grid1));

        // Test case 2: All fresh oranges
        int[][] grid2 = {
            {1, 1, 1},
            {1, 1, 1},
            {1, 1, 1}
        };
        assertEquals(-1, orangesRot.orangesRotting(grid2));

        // Test case 3: All rotten oranges
        int[][] grid3 = {
            {2, 2, 2},
            {2, 2, 2},
            {2, 2, 2}
        };
        assertEquals(0, orangesRot.orangesRotting(grid3));

        // Test case 4: Some rotten oranges, some fresh oranges, all rotten in 1 minute
        int[][] grid4 = {
            {2, 1, 1},
            {1, 1, 0},
            {1, 0, 2}
        };
        assertEquals(1, orangesRot.orangesRotting(grid4));

        // Test case 5: Some rotten oranges, some fresh oranges, all rotten in 2 minutes
        int[][] grid5 = {
            {2, 1, 0},
            {1, 1, 0},
            {0, 0, 2}
        };
        assertEquals(2, orangesRot.orangesRotting(grid5));

        // Test case 6: Some rotten oranges, some fresh oranges, not all can be rotten
        int[][] grid6 = {
            {2, 1, 0},
            {0, 1, 0},
            {0, 0, 1}
        };
        assertEquals(-1, orangesRot.orangesRotting(grid6));

        // Test case 7: Complex grid with multiple rotting stages
        int[][] grid7 = {
            {2, 1, 0, 2, 1},
            {1, 1, 0, 1, 2},
            {0, 0, 2, 0, 0},
            {2, 1, 0, 2, 1},
            {1, 1, 0, 1, 2}
        };
        assertEquals(3, orangesRot.orangesRotting(grid7));
    }
}