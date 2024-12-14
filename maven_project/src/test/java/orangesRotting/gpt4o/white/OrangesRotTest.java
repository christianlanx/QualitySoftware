package orangesRotting.gpt4o.white;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import orangesRotting.OrangesRot;

public class OrangesRotTest {

    private OrangesRot orangesRot;

    @BeforeEach
    public void setUp() {
        orangesRot = new OrangesRot();
    }

    @Test
    public void testAllFreshOranges() {
        int[][] grid = {
            {1, 1, 1},
            {1, 1, 1},
            {1, 1, 1}
        };
        assertEquals(-1, orangesRot.orangesRotting(grid));
    }

    @Test
    public void testAllRottenOranges() {
        int[][] grid = {
            {2, 2, 2},
            {2, 2, 2},
            {2, 2, 2}
        };
        assertEquals(0, orangesRot.orangesRotting(grid));
    }

    @Test
    public void testMixedOrangesCase1() {
        int[][] grid = {
            {2, 1, 1},
            {0, 1, 1},
            {1, 0, 1}
        };
        assertEquals(4, orangesRot.orangesRotting(grid));
    }

    @Test
    public void testMixedOrangesCase2() {
        int[][] grid = {
            {2, 1, 0},
            {1, 1, 0},
            {0, 1, 1}
        };
        assertEquals(4, orangesRot.orangesRotting(grid));
    }

    @Test
    public void testIsolatedFreshOrange() {
        int[][] grid = {
            {2, 0, 0},
            {0, 1, 0},
            {0, 0, 2}
        };
        assertEquals(-1, orangesRot.orangesRotting(grid));
    }

    @Test
    public void testNoOranges() {
        int[][] grid = {
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
        };
        assertEquals(0, orangesRot.orangesRotting(grid));
    }

    @Test
    public void testSingleFreshOrange() {
        int[][] grid = {
            {1}
        };
        assertEquals(-1, orangesRot.orangesRotting(grid));
    }

    @Test
    public void testSingleRottenOrange() {
        int[][] grid = {
            {2}
        };
        assertEquals(0, orangesRot.orangesRotting(grid));
    }
}