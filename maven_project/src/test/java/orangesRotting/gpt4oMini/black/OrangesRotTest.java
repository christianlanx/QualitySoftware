package orangesRotting.gpt4oMini.black;

import org.junit.jupiter.api.Test;

import orangesRotting.OrangesRot;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrangesRotTest {

    private final OrangesRot orangesRot = new OrangesRot();

    @Test
    public void testAllFreshOrangesBecomeRotten() {
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        assertEquals(4, orangesRot.orangesRotting(grid));
    }

    @Test
    public void testImpossibleToRotAllOranges() {
        int[][] grid = {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
        assertEquals(-1, orangesRot.orangesRotting(grid));
    }

    @Test
    public void testNoFreshOrangesInitially() {
        int[][] grid = {{0, 2}};
        assertEquals(0, orangesRot.orangesRotting(grid));
    }
    
    @Test
    public void testSingleFreshOrangeSurroundedByRotten() {
        int[][] grid = {{2, 2}, {1, 2}};
        assertEquals(1, orangesRot.orangesRotting(grid));
    }

    @Test
    public void testGridWithNoRottenOranges() {
        int[][] grid = {{1, 1}, {1, 1}};
        assertEquals(-1, orangesRot.orangesRotting(grid));
    }
    
    @Test
    public void testLargerGridWithMultipleScenarios() {
        int[][] grid = {{2, 1, 0}, {1, 1, 1}, {0, 1, 2}};
        assertEquals(2, orangesRot.orangesRotting(grid));
    }

    @Test
    public void testLargerGridWithAllFreshOranges() {
        int[][] grid = {{1, 1, 1}, {1, 1, 1}};
        assertEquals(-1, orangesRot.orangesRotting(grid));
    }

    @Test
    public void testOnlyOneFreshOrangeInGrid() {
        int[][] grid = {{0, 0}, {0, 1}};
        assertEquals(-1, orangesRot.orangesRotting(grid));
    }
    
    @Test
    public void testSingleCellFreshOrange() {
        int[][] grid = {{1}};
        assertEquals(-1, orangesRot.orangesRotting(grid));
    }

    @Test
    public void testSingleCellRottenOrange() {
        int[][] grid = {{2}};
        assertEquals(0, orangesRot.orangesRotting(grid));
    }
}