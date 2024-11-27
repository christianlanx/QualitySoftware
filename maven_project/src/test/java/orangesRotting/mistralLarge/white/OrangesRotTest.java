package orangesRotting.mistralLarge.white;
import orangesRotting.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrangesRotTest {

    private OrangesRot orangesRot;

    @BeforeEach
    public void setUp() {
        orangesRot = new OrangesRot();
    }

    @Test
    public void testOrangesRotting_AllOrangesRotten() {
        int[][] grid = {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
        };
        int result = orangesRot.orangesRotting(grid);
        assertEquals(4, result);
    }

    @Test
    public void testOrangesRotting_NoOranges() {
        int[][] grid = {
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
        };
        int result = orangesRot.orangesRotting(grid);
        assertEquals(0, result);
    }

    @Test
    public void testOrangesRotting_SomeOrangesRotten() {
        int[][] grid = {
            {2, 1, 1},
            {0, 1, 1},
            {1, 0, 1}
        };
        int result = orangesRot.orangesRotting(grid);
        assertEquals(-1, result);
    }

    @Test
    public void testOrangesRotting_SingleOrange() {
        int[][] grid = {
            {2}
        };
        int result = orangesRot.orangesRotting(grid);
        assertEquals(0, result);
    }

    @Test
    public void testOrangesRotting_AllFreshOranges() {
        int[][] grid = {
            {1, 1, 1},
            {1, 1, 1},
            {1, 1, 1}
        };
        int result = orangesRot.orangesRotting(grid);
        assertEquals(-1, result);
    }

    @Test
    public void testOrangesRotting_MixedOranges() {
        int[][] grid = {
            {2, 1, 0},
            {1, 1, 0},
            {0, 1, 2}
        };
        int result = orangesRot.orangesRotting(grid);
        assertEquals(2, result);
    }

    @Test
    public void testInBounds_True() {
        int[][] grid = {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
        };
        boolean result = orangesRot.inBounds(1, 1, grid);
        assertTrue(result);
    }

    @Test
    public void testInBounds_False() {
        int[][] grid = {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
        };
        boolean result = orangesRot.inBounds(3, 3, grid);
        assertFalse(result);
    }
}