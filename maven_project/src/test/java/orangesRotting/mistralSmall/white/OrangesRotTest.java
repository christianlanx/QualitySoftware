package orangesRotting.mistralSmall.white;
import orangesRotting.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrangesRotTest {

    private OrangesRot orangesRot;

    @BeforeEach
    public void setUp() {
        orangesRot = new OrangesRot();
    }

    @Test
    public void testOrangesRotting_allFresh() {
        int[][] grid = {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
        };
        assertEquals(4, orangesRot.orangesRotting(grid));
    }

    @Test
    public void testOrangesRotting_emptyGrid() {
        int[][] grid = {};
        assertEquals(0, orangesRot.orangesRotting(grid));
    }

    @Test
    public void testOrangesRotting_allRotten() {
        int[][] grid = {
            {2, 2, 2},
            {2, 2, 2},
            {2, 2, 2}
        };
        assertEquals(0, orangesRot.orangesRotting(grid));
    }

    @Test
    public void testOrangesRotting_notAllRotten() {
        int[][] grid = {
            {2, 1, 1},
            {0, 1, 1},
            {1, 1, 2}
        };
        assertEquals(-1, orangesRot.orangesRotting(grid));
    }

    @Test
    public void testOrangesRotting_isolatedFresh() {
        int[][] grid = {
            {2, 1},
            {1, 0}
        };
        assertEquals(2, orangesRot.orangesRotting(grid));
    }

    @Test
    public void testOrangesRotting_emptyGridWithNoOranges() {
        int[][] grid = {
            {0, 0},
            {0, 0}
        };
        assertEquals(0, orangesRot.orangesRotting(grid));
    }
}