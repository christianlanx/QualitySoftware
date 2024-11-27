package orangesRotting.mistralSmall.black;
import orangesRotting.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OrangesRotTest {

    @Test
    public void testExample1() {
        OrangesRot orangesRot = new OrangesRot();
        int[][] grid = {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
        };
        assertEquals(4, orangesRot.orangesRotting(grid));
    }

    @Test
    public void testExample2() {
        OrangesRot orangesRot = new OrangesRot();
        int[][] grid = {
            {2, 1, 1},
            {0, 1, 1},
            {1, 0, 1}
        };
        assertEquals(-1, orangesRot.orangesRotting(grid));
    }

    @Test
    public void testExample3() {
        OrangesRot orangesRot = new OrangesRot();
        int[][] grid = {
            {0, 2}
        };
        assertEquals(0, orangesRot.orangesRotting(grid));
    }

    @Test
    public void testAllOrangesRotten() {
        OrangesRot orangesRot = new OrangesRot();
        int[][] grid = {
            {2, 1, 1},
            {1, 1, 1},
            {1, 1, 1}
        };
        assertEquals(2, orangesRot.orangesRotting(grid));
    }

    @Test
    public void testNoOranges() {
        OrangesRot orangesRot = new OrangesRot();
        int[][] grid = {
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
        };
        assertEquals(0, orangesRot.orangesRotting(grid));
    }

    @Test
    public void testSingleOrange() {
        OrangesRot orangesRot = new OrangesRot();
        int[][] grid = {
            {1}
        };
        assertEquals(-1, orangesRot.orangesRotting(grid));
    }

    @Test
    public void testLargeGrid() {
        OrangesRot orangesRot = new OrangesRot();
        int[][] grid = {
            {2, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        };
        assertEquals(4, orangesRot.orangesRotting(grid));
    }
}