package trityp;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TritypTestClaude35Sonnet {

    @Test
    public void testInvalidTriangles() {
        assertEquals(4, Trityp.Triang(0, 1, 1));
        assertEquals(4, Trityp.Triang(-1, 2, 2));
        assertEquals(4, Trityp.Triang(1, 1, 3));
        assertEquals(4, Trityp.Triang(1, 3, 1));
    }

    @Test
    public void testScaleneTriangles() {
        assertEquals(1, Trityp.Triang(3, 4, 5));
        assertEquals(1, Trityp.Triang(5, 12, 13));
    }

    @Test
    public void testIsoscelesTriangles() {
        assertEquals(2, Trityp.Triang(5, 5, 3));
        assertEquals(2, Trityp.Triang(5, 3, 5));
        assertEquals(2, Trityp.Triang(3, 5, 5));
    }

    // @Test
    // public void testEquilateralTriangles() {
    //     assertEquals(1, Trityp.Triang(1, 1, 1));
    //     assertEquals(1, Trityp.Triang(100, 100, 100));
    // }

    // @Test
    // public void testBorderlineCases() {
    //     assertEquals(4, Trityp.Triang(1, 2, 3));
    //     assertEquals(4, Trityp.Triang(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE));
    // }
}