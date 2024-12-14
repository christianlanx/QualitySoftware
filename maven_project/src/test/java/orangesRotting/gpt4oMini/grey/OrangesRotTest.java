package orangesRotting.gpt4oMini.grey;

import org.junit.jupiter.api.Test;

import orangesRotting.OrangesRot;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrangesRotTest {

    private final OrangesRot orangesRot = new OrangesRot();

    @Test
    public void testAllFreshOrangesRotten() {
        int[][] grid1 = {{2,1,1}, {1,1,0}, {0,1,1}};
        assertEquals(4, orangesRot.orangesRotting(grid1));
    }

    @Test
    public void testImpossibleToRotAllOranges() {
        int[][] grid2 = {{2,1,1}, {0,1,1}, {1,0,1}};
        assertEquals(-1, orangesRot.orangesRotting(grid2));
    }

    @Test
    public void testNoFreshOrangesAtStart() {
        int[][] grid3 = {{0,2}};
        assertEquals(0, orangesRot.orangesRotting(grid3));
    }

    @Test
    public void testEmptyGrid() {
        int[][] grid4 = {{0, 0}, {0, 0}};
        assertEquals(0, orangesRot.orangesRotting(grid4));
    }

    @Test
    public void testAllRottenOranges() {
        int[][] grid5 = {{2, 2}, {2, 2}};
        assertEquals(0, orangesRot.orangesRotting(grid5));
    }

    @Test
    public void testSingleFreshOrange() {
        int[][] grid6 = {{1}};
        assertEquals(-1, orangesRot.orangesRotting(grid6));
    }

    @Test
    public void testSingleRottenOrange() {
        int[][] grid7 = {{2}};
        assertEquals(0, orangesRot.orangesRotting(grid7));
    }

    @Test
    public void testMultipleRottenAndFreshMixed() {
        int[][] grid8 = {{2, 1}, {1, 0}, {0, 1}};
        assertEquals(-1, orangesRot.orangesRotting(grid8));
    }

    @Test
    public void testComplexGridScenario() {
        int[][] grid9 = {{0, 1, 2}, {1, 1, 0}, {2, 1, 1}};
        assertEquals(2, orangesRot.orangesRotting(grid9));
    }
}