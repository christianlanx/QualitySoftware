package trityp.claude35Haiku.white;
import trityp.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TriTypTest {

    // Invalid Triangle Tests
    @Test
    void testInvalidTriangleWithNegativeSides() {
        assertEquals(4, Trityp.Triang(-1, 2, 3));
        assertEquals(4, Trityp.Triang(1, -2, 3));
        assertEquals(4, Trityp.Triang(1, 2, -3));
    }

    @Test
    void testInvalidTriangleWithZeroSides() {
        assertEquals(4, Trityp.Triang(0, 2, 3));
        assertEquals(4, Trityp.Triang(1, 0, 3));
        assertEquals(4, Trityp.Triang(1, 2, 0));
    }

    @Test
    void testInvalidTriangleWithImpossibleSides() {
        assertEquals(4, Trityp.Triang(1, 2, 3)); // Sum of two sides <= third side
        assertEquals(4, Trityp.Triang(1, 1, 3)); // Sum of two sides == third side
    }

    // Scalene Triangle Tests
    @Test
    void testScaleneTriangle() {
        assertEquals(1, Trityp.Triang(3, 4, 5));
        assertEquals(1, Trityp.Triang(5, 6, 7));
    }

    // Isosceles Triangle Tests
    @Test
    void testIsoscelesTriangle() {
        assertEquals(2, Trityp.Triang(5, 5, 6)); // First two sides equal
        assertEquals(2, Trityp.Triang(5, 6, 5)); // First and last sides equal
        assertEquals(2, Trityp.Triang(6, 5, 5)); // Last two sides equal
    }

    // Equilateral Triangle Tests
    @Test
    void testEquilateralTriangle() {
        assertEquals(3, Trityp.Triang(5, 5, 5));
        assertEquals(3, Trityp.Triang(100, 100, 100));
    }

    // Edge Cases
    @Test
    void testEdgeCases() {
        // Large numbers
        assertEquals(1, Trityp.Triang(1000, 1001, 1002));
        
        // Borderline valid triangles
        assertEquals(2, Trityp.Triang(3, 3, 4));
        assertEquals(2, Trityp.Triang(3, 4, 3));
        assertEquals(2, Trityp.Triang(4, 3, 3));
    }

    // Boundary Tests
    @Test
    void testBoundaryConditions() {
        // Limit cases for triangle inequality theorem
        assertEquals(4, Trityp.Triang(1, 2, 4)); // Sum of shorter sides == longer side
        assertEquals(1, Trityp.Triang(3, 4, 6)); // Sum of shorter sides > longer side
    }
}