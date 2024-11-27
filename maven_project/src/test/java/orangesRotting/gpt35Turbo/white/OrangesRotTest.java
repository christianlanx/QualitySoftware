package orangesRotting.gpt35Turbo.white;
import orangesRotting.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class OrangesRotTest {

    @Test
    public void testOrangesRotting_NoFreshOranges_ReturnsZero() {
        OrangesRot rotting = new OrangesRot();
        int[][] grid = {{2}};
        int result = rotting.orangesRotting(grid);
        assertEquals(0, result);
    }

    @Test
    public void testOrangesRotting_OneMinuteToRotAllOranges_ReturnsOne() {
        OrangesRot rotting = new OrangesRot();
        int[][] grid = {{2, 1}};
        int result = rotting.orangesRotting(grid);
        assertEquals(1, result);
    }

    @Test
    public void testOrangesRotting_UnableToRotAllOranges_ReturnsMinusOne() {
        OrangesRot rotting = new OrangesRot();
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        int result = rotting.orangesRotting(grid);
        assertEquals(-1, result);
    }

    @Test
    public void testOrangesRotting_AllOrangesAlreadyRotten_ReturnsZero() {
        OrangesRot rotting = new OrangesRot();
        int[][] grid = {{2, 2, 2}, {2, 2, 2}, {2, 2, 2}};
        int result = rotting.orangesRotting(grid);
        assertEquals(0, result);
    }

}