package orangesRotting.gpt4o.black;
import orangesRotting.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class OrangesRotTest {

    @Test
    public void testExample1() {
        OrangesRot solution = new OrangesRot();
        int[][] grid = {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
        };
        int expected = 4;
        assertEquals(expected, solution.orangesRotting(grid));
    }

    @Test
    public void testExample2() {
        OrangesRot solution = new OrangesRot();
        int[][] grid = {
            {2, 1, 1},
            {0, 1, 1},
            {1, 0, 1}
        };
        int expected = -1;
        assertEquals(expected, solution.orangesRotting(grid));
    }

    @Test
    public void testExample3() {
        OrangesRot solution = new OrangesRot();
        int[][] grid = {
            {0, 2}
        };
        int expected = 0;
        assertEquals(expected, solution.orangesRotting(grid));
    }
    
    @Test
    public void testNoFreshOranges() {
        OrangesRot solution = new OrangesRot();
        int[][] grid = {
            {2, 2, 0},
            {0, 2, 2}
        };
        int expected = 0;
        assertEquals(expected, solution.orangesRotting(grid));
    }

    @Test
    public void testAllFreshOrangesImpossible() {
        OrangesRot solution = new OrangesRot();
        int[][] grid = {
            {1, 1, 1},
            {1, 1, 1},
            {1, 1, 1}
        };
        int expected = -1;
        assertEquals(expected, solution.orangesRotting(grid));
    }
    
    @Test
    public void testAllFreshOrangesNearRotten() {
        OrangesRot solution = new OrangesRot();
        int[][] grid = {
            {2, 1, 1},
            {1, 1, 1},
            {1, 1, 1}
        };
        int expected = 3;
        assertEquals(expected, solution.orangesRotting(grid));
    }
    
    @Test
    public void testSingleElementGridRotten() {
        OrangesRot solution = new OrangesRot();
        int[][] grid = {
            {2}
        };
        int expected = 0;
        assertEquals(expected, solution.orangesRotting(grid));
    }

    @Test
    public void testSingleElementGridFresh() {
        OrangesRot solution = new OrangesRot();
        int[][] grid = {
            {1}
        };
        int expected = -1;
        assertEquals(expected, solution.orangesRotting(grid));
    }
    
    @Test
    public void testSingleElementGridEmpty() {
        OrangesRot solution = new OrangesRot();
        int[][] grid = {
            {0}
        };
        int expected = 0;
        assertEquals(expected, solution.orangesRotting(grid));
    }
}