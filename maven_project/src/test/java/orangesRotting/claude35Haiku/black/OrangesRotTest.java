package orangesRotting.claude35Haiku.black;
import orangesRotting.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OrangesRotTest {
    private OrangesRot orangesRot = new OrangesRot();

    @Test
    void testBasicRotting() {
        int[][] grid = {
            {2,1,1},
            {1,1,0},
            {0,1,1}
        };
        assertEquals(4, orangesRot.orangesRotting(grid));
    }

    @Test
    void testImpossibleRotting() {
        int[][] grid = {
            {2,1,1},
            {0,1,1},
            {1,0,1}
        };
        assertEquals(-1, orangesRot.orangesRotting(grid));
    }

    @Test
    void testNoFreshOranges() {
        int[][] grid = {{0,2}};
        assertEquals(0, orangesRot.orangesRotting(grid));
    }

    @Test
    void testOnlyFreshOranges() {
        int[][] grid = {
            {1,1,1},
            {1,1,1},
            {1,1,1}
        };
        assertEquals(-1, orangesRot.orangesRotting(grid));
    }

    @Test
    void testOnlyRottedOranges() {
        int[][] grid = {
            {2,2,2},
            {2,2,2},
            {2,2,2}
        };
        assertEquals(0, orangesRot.orangesRotting(grid));
    }

    @Test
    void testSingleCellGrid() {
        int[][] grid1 = {{1}};
        assertEquals(-1, orangesRot.orangesRotting(grid1));

        int[][] grid2 = {{2}};
        assertEquals(0, orangesRot.orangesRotting(grid2));

        int[][] grid3 = {{0}};
        assertEquals(0, orangesRot.orangesRotting(grid3));
    }

    @Test
    void testComplexRotting() {
        int[][] grid = {
            {2,1,1,1},
            {1,1,0,1},
            {0,1,1,2}
        };
        assertEquals(4, orangesRot.orangesRotting(grid));
    }

    @Test
    void testMinimumGrid() {
        int[][] grid = {
            {2,1},
            {1,1}
        };
        assertEquals(2, orangesRot.orangesRotting(grid));
    }
}