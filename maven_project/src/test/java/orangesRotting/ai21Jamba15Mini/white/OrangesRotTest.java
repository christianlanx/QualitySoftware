package orangesRotting.ai21Jamba15Mini.white;
import orangesRotting.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Queue;
import java.util.LinkedList;

public class OrangesRotTest {

    @Test
    void testOrangesRotting_EmptyGrid() {
        int[][] grid = {};
        assertEquals(0, new OrangesRot().orangesRotting(grid));
    }

    @Test
    void testOrangesRotting_NoRottenOranges() {
        int[][] grid = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        assertEquals(0, new OrangesRot().orangesRotting(grid));
    }

    @Test
    void testOrangesRotting_AllRottenOranges() {
        int[][] grid = {{2, 1, 1}, {1, 1, 1}, {1, 1, 2}};
        assertEquals(1, new OrangesRot().orangesRotting(grid));
    }

    @Test
    void testOrangesRotting_SomeRottenOranges() {
        int[][] grid = {{1, 1, 1}, {1, 2, 1}, {1, 1, 1}};
        assertEquals(2, new OrangesRot().orangesRotting(grid));
    }

    @Test
    void testOrangesRotting_NoFreshOranges() {
        int[][] grid = {{2, 2, 2}, {2, 2, 2}, {2, 2, 2}};
        assertEquals(0, new OrangesRot().orangesRotting(grid));
    }

    @Test
    void testOrangesRotting_MultipleRottenOranges() {
        int[][] grid = {{1, 2, 1}, {2, 1, 2}, {1, 2, 1}};
        assertEquals(2, new OrangesRot().orangesRotting(grid));
    }

    @Test
    void testOrangesRotting_LargeGrid() {
        int[][] grid = {
                {1, 1, 1, 1, 1},
                {1, 2, 1, 2, 1},
                {1, 1, 1, 1, 1},
                {1, 2, 2, 2, 1},
                {1, 1, 1, 1, 1}
        };
        assertEquals(3, new OrangesRot().orangesRotting(grid));
    }
}