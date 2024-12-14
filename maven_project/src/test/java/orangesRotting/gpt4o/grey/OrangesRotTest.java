package orangesRotting.gpt4o.grey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import orangesRotting.OrangesRot;

public class OrangesRotTest {

    @Test
    public void testOrangesRottingExample1() {
        OrangesRot or = new OrangesRot();
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        int expected = 4;
        int result = or.orangesRotting(grid);
        assertEquals(expected, result);
    }

    @Test
    public void testOrangesRottingExample2() {
        OrangesRot or = new OrangesRot();
        int[][] grid = {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
        int expected = -1;
        int result = or.orangesRotting(grid);
        assertEquals(expected, result);
    }

    @Test
    public void testOrangesRottingExample3() {
        OrangesRot or = new OrangesRot();
        int[][] grid = {{0, 2}};
        int expected = 0;
        int result = or.orangesRotting(grid);
        assertEquals(expected, result);
    }

    @Test
    public void testAllRotten() {
        OrangesRot or = new OrangesRot();
        int[][] grid = {{2, 2, 2}, {2, 2, 2}, {2, 2, 2}};
        int expected = 0;
        int result = or.orangesRotting(grid);
        assertEquals(expected, result);
    }

    @Test
    public void testNoRotten() {
        OrangesRot or = new OrangesRot();
        int[][] grid = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        int expected = -1;
        int result = or.orangesRotting(grid);
        assertEquals(expected, result);
    }

    @Test
    public void testSmallGrid() {
        OrangesRot or = new OrangesRot();
        int[][] grid = {{2}};
        int expected = 0;
        int result = or.orangesRotting(grid);
        assertEquals(expected, result);
    }

    @Test
    public void testEmptyGrid() {
        OrangesRot or = new OrangesRot();
        int[][] grid = {{}};
        int expected = 0;
        int result = or.orangesRotting(grid);
        assertEquals(expected, result);
    }
}