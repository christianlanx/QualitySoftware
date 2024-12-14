package orangesRotting.gpt35Turbo.grey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class OrangesRotTest {

    @Test
    void testOrangesRottingExample1() {
        OrangesRot testObject = new OrangesRot();
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        assertEquals(4, testObject.orangesRotting(grid));
    }

    @Test
    void testOrangesRottingExample2() {
        OrangesRot testObject = new OrangesRot();
        int[][] grid = {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
        assertEquals(-1, testObject.orangesRotting(grid));
    }

    @Test
    void testOrangesRottingExample3() {
        OrangesRot testObject = new OrangesRot();
        int[][] grid = {{0, 2}};
        assertEquals(0, testObject.orangesRotting(grid));
    }
}