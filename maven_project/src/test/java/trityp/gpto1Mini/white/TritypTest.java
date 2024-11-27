package trityp.gpto1Mini.white;
import trityp.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TritypTest {

    @Test
    @DisplayName("Test Equilateral Triangles")
    void testEquilateralTriangles() {
        assertEquals(3, Trityp.Triang(1, 1, 1), "All sides equal should be equilateral");
        assertEquals(3, Trityp.Triang(5, 5, 5), "All sides equal should be equilateral");
        assertEquals(3, Trityp.Triang(10, 10, 10), "All sides equal should be equilateral");
    }

    @Test
    @DisplayName("Test Isosceles Triangles")
    void testIsoscelesTriangles() {
        assertEquals(2, Trityp.Triang(2, 2, 3), "Two sides equal should be isosceles");
        assertEquals(2, Trityp.Triang(4, 5, 4), "Two sides equal should be isosceles");
        assertEquals(2, Trityp.Triang(6, 7, 7), "Two sides equal should be isosceles");
        assertEquals(2, Trityp.Triang(5, 5, 8), "Two sides equal should be isosceles");
    }

    @Test
    @DisplayName("Test Scalene Triangles")
    void testScaleneTriangles() {
        assertEquals(1, Trityp.Triang(3, 4, 5), "All sides different should be scalene");
        assertEquals(1, Trityp.Triang(5, 6, 7), "All sides different should be scalene");
        assertEquals(1, Trityp.Triang(8, 10, 12), "All sides different should be scalene");
        assertEquals(1, Trityp.Triang(7, 9, 11), "All sides different should be scalene");
    }

    @Test
    @DisplayName("Test Invalid Triangles with Non-Positive Sides")
    void testInvalidTriangles_NonPositiveSides() {
        assertEquals(4, Trityp.Triang(0, 4, 5), "Zero side length should be invalid");
        assertEquals(4, Trityp.Triang(-1, 4, 5), "Negative side length should be invalid");
        assertEquals(4, Trityp.Triang(3, -2, 5), "Negative side length should be invalid");
        assertEquals(4, Trityp.Triang(3, 4, -5), "Negative side length should be invalid");
        assertEquals(4, Trityp.Triang(0, 0, 0), "All sides zero should be invalid");
    }

    @Test
    @DisplayName("Test Invalid Triangles Violating Triangle Inequality")
    void testInvalidTriangles_TriangleInequality() {
        assertEquals(4, Trityp.Triang(1, 2, 3), "Triangle inequality violated");
        assertEquals(4, Trityp.Triang(2, 1, 3), "Triangle inequality violated");
        assertEquals(4, Trityp.Triang(5, 1, 1), "Triangle inequality violated");
        assertEquals(4, Trityp.Triang(10, 2, 3), "Triangle inequality violated");
        assertEquals(4, Trityp.Triang(7, 10, 3), "Triangle inequality violated");
    }

    @Test
    @DisplayName("Test Boundary Cases for Triangle Inequality")
    void testBoundaryCases_TriangleInequality() {
        assertEquals(1, Trityp.Triang(2, 3, 4), "Valid scalene triangle");
        assertEquals(2, Trityp.Triang(2, 2, 3), "Valid isosceles triangle");
        assertEquals(3, Trityp.Triang(5, 5, 5), "Valid equilateral triangle");
        assertEquals(4, Trityp.Triang(1, 1, 2), "Boundary invalid triangle");
    }
}