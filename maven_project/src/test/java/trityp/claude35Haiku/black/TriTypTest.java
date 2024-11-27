package trityp.claude35Haiku.black;
import trityp.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TriTypTest {

    @Test
    void testEquilateralTriangle() {
        assertEquals(3, Trityp.Triang(5, 5, 5), "All sides equal should return 3 (Equilateral)");
    }

    @Test
    void testIsoscelesTriangle() {
        assertEquals(2, Trityp.Triang(5, 5, 6), "Two sides equal should return 2 (Isosceles)");
        assertEquals(2, Trityp.Triang(5, 6, 5), "Two sides equal should return 2 (Isosceles)");
        assertEquals(2, Trityp.Triang(6, 5, 5), "Two sides equal should return 2 (Isosceles)");
    }

    @Test
    void testScaleneTriangle() {
        assertEquals(1, Trityp.Triang(3, 4, 5), "All sides different should return 1 (Scalene)");
        assertEquals(1, Trityp.Triang(5, 6, 7), "All sides different should return 1 (Scalene)");
    }

    @Test
    void testInvalidTriangleNegativeSides() {
        assertEquals(4, Trityp.Triang(-1, 2, 3), "Negative side should return 4 (Invalid)");
        assertEquals(4, Trityp.Triang(1, -2, 3), "Negative side should return 4 (Invalid)");
        assertEquals(4, Trityp.Triang(1, 2, -3), "Negative side should return 4 (Invalid)");
    }

    @Test
    void testInvalidTriangleZeroSides() {
        assertEquals(4, Trityp.Triang(0, 2, 3), "Zero side should return 4 (Invalid)");
        assertEquals(4, Trityp.Triang(1, 0, 3), "Zero side should return 4 (Invalid)");
        assertEquals(4, Trityp.Triang(1, 2, 0), "Zero side should return 4 (Invalid)");
    }

    @Test
    void testInvalidTriangleInequalityCriterion() {
        assertEquals(4, Trityp.Triang(1, 1, 10), "Violates triangle inequality should return 4 (Invalid)");
        assertEquals(4, Trityp.Triang(1, 10, 1), "Violates triangle inequality should return 4 (Invalid)");
        assertEquals(4, Trityp.Triang(10, 1, 1), "Violates triangle inequality should return 4 (Invalid)");
    }

    @Test
    void testEdgeCases() {
        assertEquals(3, Trityp.Triang(100, 100, 100), "Large equal sides should be Equilateral");
        assertEquals(1, Trityp.Triang(3, 4, 5), "Classic right-angled triangle is Scalene");
    }
}