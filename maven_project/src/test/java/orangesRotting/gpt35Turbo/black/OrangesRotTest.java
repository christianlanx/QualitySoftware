package orangesRotting.gpt35Turbo.black;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrangesRotTest {

    private OrangesRot orangesRot;

    @BeforeEach
    public void setup() {
        orangesRot = new OrangesRot();
    }

    @Test
    public void testOrangesRotExample1() {
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        int expected = 4;
        int result = orangesRot.orangesRotting(grid);
        assertEquals(expected, result);
    }

    @Test
    public void testOrangesRotExample2() {
        int[][] grid = {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
        int expected = -1;
        int result = orangesRot.orangesRotting(grid);
        assertEquals(expected, result);
    }

    @Test
    public void testOrangesRotExample3() {
        int[][] grid = {{0, 2}};
        int expected = 0;
        int result = orangesRot.orangesRotting(grid);
        assertEquals(expected, result);
    }
}