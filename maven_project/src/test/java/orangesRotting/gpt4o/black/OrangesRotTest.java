package orangesRotting.gpt4o.black;

import orangesRotting.OrangesRot;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class OrangesRotTest {

    @Test
    public void testExample1() {
        OrangesRot solver = new OrangesRot();
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        int expected = 4;
        assertEquals(expected, solver.orangesRotting(grid));
    }

    @Test
    public void testExample2() {
        OrangesRot solver = new OrangesRot();
        int[][] grid = {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
        int expected = -1;
        assertEquals(expected, solver.orangesRotting(grid));
    }

    @Test
    public void testExample3() {
        OrangesRot solver = new OrangesRot();
        int[][] grid = {{0, 2}};
        int expected = 0;
        assertEquals(expected, solver.orangesRotting(grid));
    }

    @Test
    public void testNoOranges() {
        OrangesRot solver = new OrangesRot();
        int[][] grid = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        int expected = 0;
        assertEquals(expected, solver.orangesRotting(grid));
    }

    @Test
    public void testAllRotten() {
        OrangesRot solver = new OrangesRot();
        int[][] grid = {{2, 2, 2}, {2, 2, 2}, {2, 2, 2}};
        int expected = 0;
        assertEquals(expected, solver.orangesRotting(grid));
    }

    @Test
    public void testIsolatedFreshOrange() {
        OrangesRot solver = new OrangesRot();
        int[][] grid = {{2, 0, 0}, {0, 1, 0}, {0, 0, 2}};
        int expected = -1;
        assertEquals(expected, solver.orangesRotting(grid));
    }

    @Test
    public void testLargeGridWithImmediateRottenSpread() {
        OrangesRot solver = new OrangesRot();
        int[][] grid = {
            {2, 2, 1, 1, 1, 2},
            {2, 1, 1, 1, 2, 1},
            {1, 1, 1, 2, 1, 1},
            {1, 1, 2, 1, 1, 1},
            {2, 1, 1, 1, 1, 2}
        };
        int expected = 2;
        assertEquals(expected, solver.orangesRotting(grid));
    }
}