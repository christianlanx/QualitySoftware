package orangesRotting.gpt35Turbo.black;
import orangesRotting.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class OrangesRotTest {

    @Test
    public void testOrangesRotting_Example1() {
        OrangesRot orangesRot = new OrangesRot();
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        int result = orangesRot.orangesRotting(grid);
        assertEquals(4, result);
    }

    @Test
    public void testOrangesRotting_Example2() {
        OrangesRot orangesRot = new OrangesRot();
        int[][] grid = {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
        int result = orangesRot.orangesRotting(grid);
        assertEquals(-1, result);
    }

    @Test
    public void testOrangesRotting_Example3() {
        OrangesRot orangesRot = new OrangesRot();
        int[][] grid = {{0, 2}};
        int result = orangesRot.orangesRotting(grid);
        assertEquals(0, result);
    }
}