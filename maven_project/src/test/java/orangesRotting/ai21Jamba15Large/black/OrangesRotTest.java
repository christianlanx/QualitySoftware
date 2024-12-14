package orangesRotting.ai21Jamba15Large.black;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import orangesRotting.OrangesRot;

public class OrangesRotTest {

    private OrangesRot orangesRot;

    @BeforeEach
    void setUp() {
        orangesRot = new OrangesRot();
    }

    @Test
    void testExample1() {
        int[][] grid = {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
        };
        int expectedMinutes = 4;
        assertEquals(expectedMinutes, orangesRot.orangesRotting(grid));
    }

    @Test
    void testExample2() {
        int[][] grid = {
            {2, 1, 1},
            {0, 1, 1},
            {1, 0, 1}
        };
        int expectedMinutes = -1;
        assertEquals(expectedMinutes, orangesRot.orangesRotting(grid));
    }

    @Test
    void testExample3() {
        int[][] grid = {
            {0, 2}
        };
        int expectedMinutes = 0;
        assertEquals(expectedMinutes, orangesRot.orangesRotting(grid));
    }

    @Test
    void testAllOrangesRotten() {
        int[][] grid = {
            {2, 2, 2},
            {2, 2, 2},
            {2, 2, 2}
        };
        int expectedMinutes = 0;
        assertEquals(expectedMinutes, orangesRot.orangesRotting(grid));
    }

    @Test
    void testNoOranges() {
        int[][] grid = {
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
        };
        int expectedMinutes = 0;
        assertEquals(expectedMinutes, orangesRot.orangesRotting(grid));
    }

    @Test
    void testOneFreshOrange() {
        int[][] grid = {
            {0, 0, 1},
            {0, 0, 0},
            {0, 0, 0}
        };
        int expectedMinutes = -1;
        assertEquals(expectedMinutes, orangesRot.orangesRotting(grid));
    }

    @Test
    void testComplexGrid() {
        int[][] grid = {
            {1, 1, 0, 2, 2},
            {2, 1, 1, 0, 2},
            {0, 2, 1, 2, 2},
            {1, 0, 1, 2, 2},
            {2, 2, 2, 2, 1}
        };
        int expectedMinutes = 8;
        assertEquals(expectedMinutes, orangesRot.orangesRotting(grid));
    }

    @Test
    void testLargeGrid() {
        int[][] grid = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                grid[i][j] = 1;
            }
        }
        grid[5][5] = 2;
        int expectedMinutes = 20;
        assertEquals(expectedMinutes, orangesRot.orangesRotting(grid));
    }
}