package orangesRotting.gpt4oMini.black;
import orangesRotting.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrangesRotTest {
    private final OrangesRot orangesRot = new OrangesRot();

    @Test
    public void testRottingProcessExample1() {
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        int result = orangesRot.orangesRotting(grid);
        assertEquals(4, result);
    }

    @Test
    public void testRottingProcessExample2() {
        int[][] grid = {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
        int result = orangesRot.orangesRotting(grid);
        assertEquals(-1, result);
    }

    @Test
    public void testRottingProcessExample3() {
        int[][] grid = {{0, 2}};
        int result = orangesRot.orangesRotting(grid);
        assertEquals(0, result);
    }
    
    @Test
    public void testAllFreshOranges() {
        int[][] grid = {{1, 1}, {1, 1}};
        int result = orangesRot.orangesRotting(grid);
        assertEquals(-1, result);
    }

    @Test
    public void testAllRottenOranges() {
        int[][] grid = {{2, 2}, {2, 2}};
        int result = orangesRot.orangesRotting(grid);
        assertEquals(0, result);
    }

    @Test
    public void testSingleCellRotten() {
        int[][] grid = {{2}};
        int result = orangesRot.orangesRotting(grid);
        assertEquals(0, result);
    }

    @Test
    public void testSingleCellFresh() {
        int[][] grid = {{1}};
        int result = orangesRot.orangesRotting(grid);
        assertEquals(-1, result);
    }

    @Test
    public void testMixedCase() {
        int[][] grid = {{0, 1}, {2, 1}};
        int result = orangesRot.orangesRotting(grid);
        assertEquals(2, result);
    }
    
    @Test
    public void testLargerGrid() {
        int[][] grid = {
            {1, 1, 0},
            {1, 2, 1},
            {0, 1, 1}
        };
        int result = orangesRot.orangesRotting(grid);
        assertEquals(3, result);
    }
}