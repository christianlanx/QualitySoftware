package trityp.claude35Sonnet.white;
import trityp.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class TritypTest {

    @Test
    @DisplayName("Test invalid triangles with zero or negative sides")
    void testInvalidTriangleWithZeroOrNegativeSides() {
        assertEquals(4, Trityp.Triang(0, 1, 1), "Zero side should be invalid");
        assertEquals(4, Trityp.Triang(-1, 2, 2), "Negative side should be invalid");
        assertEquals(4, Trityp.Triang(1, -1, 1), "Negative side should be invalid");
        assertEquals(4, Trityp.Triang(1, 1, -1), "Negative side should be invalid");
    }

    @Test
    @DisplayName("Test scalene triangles")
    void testScaleneTriangles() {
        assertEquals(1, Trityp.Triang(3, 4, 5), "Valid scalene triangle");
        assertEquals(1, Trityp.Triang(5, 12, 13), "Valid scalene triangle");
        assertEquals(4, Trityp.Triang(1, 2, 4), "Invalid scalene triangle - sum of two sides <= third side");
    }

    @Test
    @DisplayName("Test isosceles triangles")
    void testIsoscelesTriangles() {
        assertEquals(2, Trityp.Triang(2, 2, 3), "Isosceles triangle with first two sides equal");
        assertEquals(2, Trityp.Triang(2, 3, 2), "Isosceles triangle with first and last sides equal");
        assertEquals(2, Trityp.Triang(3, 2, 2), "Isosceles triangle with last two sides equal");
        assertEquals(4, Trityp.Triang(2, 2, 4), "Invalid isosceles triangle");
    }

    @Test
    @DisplayName("Test equilateral triangles")
    void testEquilateralTriangles() {
        assertEquals(3, Trityp.Triang(5, 5, 5), "Valid equilateral triangle");
        assertEquals(3, Trityp.Triang(1, 1, 1), "Valid equilateral triangle");
    }

    @Test
    @DisplayName("Test invalid triangles where sum of two sides <= third side")
    void testInvalidTrianglesSides() {
        assertEquals(4, Trityp.Triang(1, 2, 3), "Invalid triangle: sum of two sides equals third side");
        assertEquals(4, Trityp.Triang(1, 1, 3), "Invalid triangle: sum of two sides less than third side");
        assertEquals(4, Trityp.Triang(3, 1, 1), "Invalid triangle: sum of two sides less than third side");
    }

    @Test
    @DisplayName("Test boundary cases")
    void testBoundaryCases() {
        assertEquals(2, Trityp.Triang(2, 2, 3), "Isosceles triangle at boundary");
        assertEquals(4, Trityp.Triang(1, 1, 2), "Invalid triangle at boundary");
    }
}