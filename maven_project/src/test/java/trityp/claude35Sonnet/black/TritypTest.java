package trityp.claude35Sonnet.black;
import trityp.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TritypTest {

    @Test
    void testEquilateralTriangle() {
        assertEquals(3, Trityp.Triang(3, 3, 3));
        assertEquals(3, Trityp.Triang(5, 5, 5));
    }

    @Test
    void testIsoscelesTriangle() {
        assertEquals(2, Trityp.Triang(5, 5, 3));
        assertEquals(2, Trityp.Triang(5, 3, 5));
        assertEquals(2, Trityp.Triang(3, 5, 5));
    }

    @Test
    void testScaleneTriangle() {
        assertEquals(1, Trityp.Triang(3, 4, 5));
        assertEquals(1, Trityp.Triang(5, 12, 13));
        assertEquals(1, Trityp.Triang(7, 8, 9));
    }

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
    void testInvalidTriangleInequalityViolation() {
        // Sum of any two sides must be greater than third side
        assertEquals(4, Trityp.Triang(1, 2, 10));
        assertEquals(4, Trityp.Triang(2, 10, 1));
        assertEquals(4, Trityp.Triang(10, 1, 2));
    }

    @Test
    void testEdgeCases() {
        // Testing with equal sides but violating triangle inequality
        assertEquals(4, Trityp.Triang(1, 1, 2));
        assertEquals(4, Trityp.Triang(2, 1, 1));
        assertEquals(4, Trityp.Triang(1, 2, 1));
    }

    @Test
    void testLargeValidNumbers() {
        assertEquals(1, Trityp.Triang(100, 101, 102));
        assertEquals(2, Trityp.Triang(1000, 1000, 500));
        assertEquals(3, Trityp.Triang(10000, 10000, 10000));
    }
}