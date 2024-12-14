package trityp.ai21Jamba15Large.black;

import trityp.Trityp;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TritypTest {

    @Test
    void testScaleneTriangle() {
        int side1 = 3;
        int side2 = 4;
        int side3 = 5;
        int expected = 1; // Scalene
        assertEquals(expected, Trityp.Triang(side1, side2, side3));
    }

    @Test
    void testIsoscelesTriangle() {
        int side1 = 4;
        int side2 = 4;
        int side3 = 5;
        int expected = 2; // Isosceles
        assertEquals(expected, Trityp.Triang(side1, side2, side3));
    }

    @Test
    void testEquilateralTriangle() {
        int side1 = 5;
        int side2 = 5;
        int side3 = 5;
        int expected = 3; // Equilateral
        assertEquals(expected, Trityp.Triang(side1, side2, side3));
    }

    @Test
    void testInvalidTriangle() {
        int side1 = 1;
        int side2 = 2;
        int side3 = 3;
        int expected = 4; // Invalid Triangle
        assertEquals(expected, Trityp.Triang(side1, side2, side3));
    }

    @Test
    void testNonPositiveSide() {
        int side1 = 1;
        int side2 = 0;
        int side3 = 3;
        int expected = 4; // Invalid Triangle
        assertEquals(expected, Trityp.Triang(side1, side2, side3));
    }

    @Test
    void testNegativeSide() {
        int side1 = 1;
        int side2 = -2;
        int side3 = 3;
        int expected = 4; // Invalid Triangle
        assertEquals(expected, Trityp.Triang(side1, side2, side3));
    }
}