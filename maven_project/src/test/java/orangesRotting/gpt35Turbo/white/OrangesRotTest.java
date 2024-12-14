package orangesRotting.gpt35Turbo.white;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import orangesRotting.OrangesRot;

public class OrangesRotTest {

    private OrangesRot orangesRot;

    @BeforeEach
    void setUp() {
        orangesRot = new OrangesRot();
    }

    @Test
    void testOrangesRotting_NoRottenOranges_ReturnsZero() {
        int[][] grid = {{0, 0}, {0, 0}};
        int expected = 0;
        int actual = orangesRot.orangesRotting(grid);
        assertEquals(expected, actual);
    }

    @Test
    void testOrangesRotting_AllOrangesRottenInOneMinute_ReturnsZero() {
        int[][] grid = {{2, 2}, {2, 2}};
        int expected = 0;
        int actual = orangesRot.orangesRotting(grid);
        assertEquals(expected, actual);
    }

    @Test
    void testOrangesRotting_OneMinuteToRottenAllOranges_ReturnsOne() {
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        int expected = 1;
        int actual = orangesRot.orangesRotting(grid);
        assertEquals(expected, actual);
    }

    @Test
    void testOrangesRotting_UnableToRottenAllOranges_ReturnsMinusOne() {
        int[][] grid = {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
        int expected = -1;
        int actual = orangesRot.orangesRotting(grid);
        assertEquals(expected, actual);
    }
}