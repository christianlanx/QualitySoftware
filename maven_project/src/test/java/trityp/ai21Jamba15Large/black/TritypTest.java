package trityp.ai21Jamba15Large.black;
import trityp.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TritypTest {
    
    // Test for an equilateral triangle
    @Test
    void testEquilateralTriangle() {
        int result = Trityp.Triang(3, 3, 3);
        assertEquals(3, result);
    }

    // Test for an isosceles triangle
    @Test
    void testIsoscelesTriangle() {
        int result = Trityp.Triang(4, 4, 5);
        assertEquals(2, result);
    }

    // Test for a scalene triangle
    @Test
    void testScaleneTriangle() {
        int result = Trityp.Triang(3, 4, 5);
        assertEquals(1, result);
    }

    // Test for an invalid triangle
    @Test
    void testInvalidTriangle() {
        int result = Trityp.Triang(1, 2, 3);
        assertEquals(0, result);
    }

    // Test for another invalid triangle
    @Test
    void testInvalidTriangle2() {
        int result = Trityp.Triang(2, 2, 5);
        assertEquals(0, result);
    }

    // Test for a triangle with zero length
    @Test
    void testZeroLengthSide() {
        int result = Trityp.Triang(0, 1, 1);
        assertEquals(0, result);
    }

    // Test for a triangle with negative length
    @Test
    void testNegativeLengthSide() {
        int result = Trityp.Triang(-1, 1, 1);
        assertEquals(0, result);
    }
}