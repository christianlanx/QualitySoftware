package orangesRotting.ai21Jamba15Mini.black;
import orangesRotting.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OrangesRotTest {

    @Test
    void testExample1() {
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        assertEquals(4, new OrangesRot().orangesRotting(grid));
    }

    @Test
    void testExample2() {
        int[][] grid = {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
        assertEquals(-1, new OrangesRot().orangesRotting(grid));
    }

    @Test
    void testExample3() {
        int[][] grid = {{0, 2}};
        assertEquals(0, new OrangesRot().orangesRotting(grid));
    }

    @Test
    void testEmptyGrid() {
        int[][] grid = {};
        assertEquals(0, new OrangesRot().orangesRotting(grid));
    }

    @Test
    void testAllFresh() {
        int[][] grid = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        assertEquals(0, new OrangesRot().orangesRotting(grid));
    }

    @Test
    void testAllRotten() {
        int[][] grid = {{2, 2, 2}, {2, 2, 2}, {2, 2, 2}};
        assertEquals(0, new OrangesRot().orangesRotting(grid));
    }

    @Test
    void testLargeGrid() {
        int[][] grid = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                grid[i][j] = (i + j) % 3 == 0 ? 1 : 0;
            }
        }
        assertEquals(0, new OrangesRot().orangesRotting(grid));
    }
}