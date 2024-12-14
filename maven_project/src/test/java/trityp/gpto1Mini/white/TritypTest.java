package trityp.gpto1Mini.white;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import trityp.Trityp;

public class TritypTest {

    @Test
    void testEquilateralTriangle() {
        int result = Trityp.Triang(5, 5, 5);
        assertEquals(3, result, "Expected equilateral triangle");
    }

    @Test
    void testIsoscelesTriangle_Side1EqualSide2() {
        int result = Trityp.Triang(5, 5, 3);
        assertEquals(2, result, "Expected isosceles triangle");
    }

    @Test
    void testIsoscelesTriangle_Side1EqualSide3() {
        int result = Trityp.Triang(5, 3, 5);
        assertEquals(2, result, "Expected isosceles triangle");
    }

    @Test
    void testIsoscelesTriangle_Side2EqualSide3() {
        int result = Trityp.Triang(3, 5, 5);
        assertEquals(2, result, "Expected isosceles triangle");
    }

    @Test
    void testScaleneTriangle() {
        int result = Trityp.Triang(4, 5, 6);
        assertEquals(1, result, "Expected scalene triangle");
    }

    @Test
    void testInvalidTriangle_NegativeSides() {
        int result = Trityp.Triang(-1, 5, 5);
        assertEquals(4, result, "Expected invalid triangle due to negative side");
    }

    @Test
    void testInvalidTriangle_ZeroSides() {
        int result = Trityp.Triang(0, 5, 5);
        assertEquals(4, result, "Expected invalid triangle due to zero side");
    }

    @Test
    void testInvalidTriangle_TriangleInequality1() {
        int result = Trityp.Triang(1, 2, 3);
        assertEquals(4, result, "Expected invalid triangle due to triangle inequality");
    }

    @Test
    void testInvalidTriangle_TriangleInequality2() {
        int result = Trityp.Triang(10, 2, 2);
        assertEquals(4, result, "Expected invalid triangle due to triangle inequality");
    }

    @Test
    void testBoundaryTriangle() {
        int result = Trityp.Triang(1, 1, 2);
        assertEquals(4, result, "Expected invalid triangle on boundary condition");
    }
}