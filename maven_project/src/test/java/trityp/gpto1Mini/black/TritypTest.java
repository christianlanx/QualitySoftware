package trityp.gpto1Mini.black;
import trityp.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TritypTest {

    @Test
    void testEquilateralTriangle() {
        assertEquals(2, Trityp.Triang(3, 3, 3), "All sides equal should be Equilateral");
        assertEquals(2, Trityp.Triang(10, 10, 10), "All sides equal should be Equilateral");
    }

    @Test
    void testIsoscelesTriangle() {
        assertEquals(1, Trityp.Triang(3, 3, 2), "Two sides equal should be Isosceles");
        assertEquals(1, Trityp.Triang(3, 2, 3), "Two sides equal should be Isosceles");
        assertEquals(1, Trityp.Triang(2, 3, 3), "Two sides equal should be Isosceles");
    }

    @Test
    void testScaleneTriangle() {
        assertEquals(0, Trityp.Triang(3, 4, 5), "All sides different should be Scalene");
        assertEquals(0, Trityp.Triang(5, 6, 7), "All sides different should be Scalene");
    }

    @Test
    void testInvalidTriangle() {
        // Triangle inequality violations
        assertEquals(-1, Trityp.Triang(1, 2, 3), "Sum of two sides equals the third should be Invalid");
        assertEquals(-1, Trityp.Triang(1, 1, 2), "Sum of two sides equals the third should be Invalid");
        assertEquals(-1, Trityp.Triang(5, 1, 1), "Sum of two sides less than the third should be Invalid");

        // Non-positive side lengths
        assertEquals(-1, Trityp.Triang(0, 2, 3), "Zero length side should be Invalid");
        assertEquals(-1, Trityp.Triang(-1, 2, 3), "Negative length side should be Invalid");
        assertEquals(-1, Trityp.Triang(2, -3, 4), "Negative length side should be Invalid");
        assertEquals(-1, Trityp.Triang(2, 3, -4), "Negative length side should be Invalid");
    }

    @Test
    void testBoundaryConditions() {
        // Minimum valid triangle
        assertEquals(2, Trityp.Triang(1, 1, 1), "All sides equal with minimum positive length should be Equilateral");

        // Large side lengths
        assertEquals(0, Trityp.Triang(1000000, 1000001, 1000002), "Large different sides should be Scalene");
        assertEquals(1, Trityp.Triang(1000000, 1000000, 999999), "Large two equal sides should be Isosceles");
    }
}