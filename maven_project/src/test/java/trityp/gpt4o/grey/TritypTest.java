package trityp.gpt4o.grey;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import trityp.Trityp;

public class TritypTest {

    @Test
    public void testEquilateralTriangle() {
        // All sides are equal
        assertEquals(3, Trityp.Triang(5, 5, 5), "All sides equal should return equilateral");
    }

    @Test
    public void testIsoscelesTriangle() {
        // Two sides are equal
        assertEquals(2, Trityp.Triang(5, 5, 8), "Two sides equal should return isosceles");
        assertEquals(2, Trityp.Triang(5, 8, 5), "Two sides equal should return isosceles");
        assertEquals(2, Trityp.Triang(8, 5, 5), "Two sides equal should return isosceles");
    }

    @Test
    public void testScaleneTriangle() {
        // All sides are different
        assertEquals(1, Trityp.Triang(4, 5, 6), "All sides different should return scalene");
        assertEquals(1, Trityp.Triang(7, 5, 10), "All sides different should return scalene");
    }

    @Test
    public void testInvalidTriangle() {
        // One or more sides are zero or negative
        assertEquals(4, Trityp.Triang(0, 5, 5), "Zero side should return invalid");
        assertEquals(4, Trityp.Triang(-1, 5, 5), "Negative side should return invalid");

        // Triangle inequality not satisfied
        assertEquals(4, Trityp.Triang(1, 2, 3), "Triangle inequality not satisfied should return invalid");
        assertEquals(4, Trityp.Triang(1, 10, 12), "Triangle inequality not satisfied should return invalid");
        assertEquals(4, Trityp.Triang(10, 3, 3), "Triangle inequality not satisfied should return invalid");
    }

    @Test
    public void testEdgeCases() {
        // Check for valid triangle with smallest positive integers
        assertEquals(2, Trityp.Triang(2, 2, 3), "Two sides equal with smallest integers should return isosceles");
        // Large equal sides, checking for integer overflow considerations
        assertEquals(3, Trityp.Triang(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE), "Max integer sides should return equilateral");
    }
}