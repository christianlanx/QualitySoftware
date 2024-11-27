package orangesRotting.metaAI.prompt1;
import orangesRotting.OrangesRot;

import org.junit.Test;
import static org.junit.Assert.*;

public class OrangesRotTest {

    OrangesRot orangesRot = new OrangesRot();

    @Test
    public void testExample1() {
        int[][] grid = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };
        int expected = 4;
        assertEquals(expected, orangesRot.orangesRotting(grid));
    }

    @Test
    public void testExample2() {
        int[][] grid = {
                {2, 1, 1},
                {0, 1, 1},
                {1, 0, 1}
        };
        int expected = -1;
        assertEquals(expected, orangesRot.orangesRotting(grid));
    }

    @Test
    public void testExample3() {
        int[][] grid = {
                {0, 2}
        };
        int expected = 0;
        assertEquals(expected, orangesRot.orangesRotting(grid));
    }

    @Test
    public void testNoOranges() {
        int[][] grid = {
                {0, 0},
                {0, 0}
        };
        int expected = 0;
        assertEquals(expected, orangesRot.orangesRotting(grid));
    }

    @Test
    public void testAllRotten() {
        int[][] grid = {
                {2, 2},
                {2, 2}
        };
        int expected = 0;
        assertEquals(expected, orangesRot.orangesRotting(grid));
    }

    @Test
    public void testImpossible() {
        int[][] grid = {
                {1, 1},
                {1, 0},
                {0, 1}
        };
        int expected = -1;
        assertEquals(expected, orangesRot.orangesRotting(grid));
    }
}