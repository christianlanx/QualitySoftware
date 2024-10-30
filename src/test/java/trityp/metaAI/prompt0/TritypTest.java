package trityp.metaAI.prompt0;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import trityp.Trityp;

public class TritypTest {

    // Test invalid triangles
    @Test
    public void testInvalidTriangles() {
        assertEquals(4, Trityp.Triang(0, 2, 3));
        assertEquals(4, Trityp.Triang(1, 0, 3));
        assertEquals(4, Trityp.Triang(1, 2, 0));
        assertEquals(4, Trityp.Triang(-1, 2, 3));
        assertEquals(4, Trityp.Triang(1, -2, 3));
        assertEquals(4, Trityp.Triang(1, 2, -3));
    }

    // Test scalene triangles
    @Test
    public void testScaleneTriangles() {
        assertEquals(1, Trityp.Triang(3, 4, 5));
        assertEquals(1, Trityp.Triang(5, 12, 13));
        assertEquals(1, Trityp.Triang(7, 24, 25));
    }

    // Test isosceles triangles
    @Test
    public void testIsoscelesTriangles() {
        assertEquals(2, Trityp.Triang(2, 2, 3));
        assertEquals(2, Trityp.Triang(3, 2, 2));
        assertEquals(2, Trityp.Triang(2, 3, 2));
    }

    // Test equilateral triangles
    @Test
    public void testEquilateralTriangles() {
        assertEquals(3, Trityp.Triang(2, 2, 2));
        assertEquals(3, Trityp.Triang(5, 5, 5));
        assertEquals(3, Trityp.Triang(10, 10, 10));
    }

    // Test edge cases
    @Test
    public void testEdgeCases() {
        assertEquals(4, Trityp.Triang(1, 1, 3)); // Invalid due to sum of two sides
        assertEquals(4, Trityp.Triang(1, 3, 1)); // Invalid due to sum of two sides
        assertEquals(4, Trityp.Triang(3, 1, 1)); // Invalid due to sum of two sides
    }
}