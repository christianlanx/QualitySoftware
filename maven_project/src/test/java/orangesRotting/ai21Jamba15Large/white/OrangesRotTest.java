package orangesRotting.ai21Jamba15Large.white;
import orangesRotting.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.jupiter.api.Test;

public class OrangesRotTest {

    @Test
    void testNoOranges() {
        int[][] grid = new int[][]{{}};
        OrangesRot orangesRot = new OrangesRot();
        int result = orangesRot.orangesRotting(grid);
        assertEquals(0, result);
    }

    @Test
    void testAllFreshOranges() {
        int[][] grid = new int[][]{{1, 1}, {1, 1}};
        OrangesRot orangesRot = new OrangesRot();
        int result = orangesRot.orangesRotting(grid);
        assertEquals(-1, result);
    }

    @Test
    void testAllRottenOranges() {
        int[][] grid = new int[][]{{2, 2}, {2, 2}};
        OrangesRot orangesRot = new OrangesRot();
        int result = orangesRot.orangesRotting(grid);
        assertEquals(0, result);
    }

    @Test
    void testMixedOranges() {
        int[][] grid = new int[][]{{2, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        OrangesRot orangesRot = new OrangesRot();
        int result = orangesRot.orangesRotting(grid);
        assertEquals 2, result);
    }

    @Test
    void testMixedOranges2() {
        int[][] grid = new int[][]{{2, 1, 0}, {0, 1, 2}, {1, 1, 1}};
        OrangesRot orangesRot = new OrangesRot();
        int result = orangesRot.orangesRotting(grid);
        assertEquals 4, result);
    }

    @Test
    void testMixedOranges3() {
        int[][] grid = new int[][]{{2, 1}, {1, 1}};
        OrangesRot orangesRot = new OrangesRot();
        int result = orangesRot.orangesRotting(grid);
        assertEquals 2, result);
    }

    @Test
    void testMixedOranges4() {
        int[][] grid = new int[][]{{2, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        OrangesRot orangesRot = new OrangesRot();
        int result = orangesRot.orangesRotting(grid);
        assertEquals 3, result);
    }

    @Test
    void testMixedOranges5() {
        int[][] grid = new int[][]{{1, 1, 1}, {1, 2, 1}, {1, 1, 1}};
        OrangesRot orangesRot = new OrangesRot();
        int result = orangesRot.orangesRotting(grid);
        assertEquals 1, result);
    }
}