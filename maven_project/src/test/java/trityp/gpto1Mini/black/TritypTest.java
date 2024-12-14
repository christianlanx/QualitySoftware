package trityp.gpto1Mini.black;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import trityp.Trityp;

public class TritypTest {

    // Constants representing triangle types
    private static final int EQUILATERAL = 0;
    private static final int ISOSCELES = 1;
    private static final int SCALENE = 2;
    private static final int INVALID = -1;

    @Test
    void testEquilateralTriangle() {
        int side = 5;
        int result = Trityp.Triang(side, side, side);
        assertEquals(EQUILATERAL, result, "All sides equal should be equilateral");
    }

    @Test
    void testIsoscelesTriangle_FirstTwoSidesEqual() {
        int result = Trityp.Triang(5, 5, 3);
        assertEquals(ISOSCELES, result, "First two sides equal should be isosceles");
    }

    @Test
    void testIsoscelesTriangle_FirstAndThirdSidesEqual() {
        int result = Trityp.Triang(5, 3, 5);
        assertEquals(ISOSCELES, result, "First and third sides equal should be isosceles");
    }

    @Test
    void testIsoscelesTriangle_LastTwoSidesEqual() {
        int result = Trityp.Triang(3, 5, 5);
        assertEquals(ISOSCELES, result, "Last two sides equal should be isosceles");
    }

    @Test
    void testScaleneTriangle() {
        int result = Trityp.Triang(4, 5, 6);
        assertEquals(SCALENE, result, "All sides different should be scalene");
    }

    @Test
    void testInvalidTriangle_NegativeSide() {
        int result = Trityp.Triang(-3, 4, 5);
        assertEquals(INVALID, result, "Negative side length should be invalid");
    }

    @Test
    void testInvalidTriangle_ZeroSide() {
        int result = Trityp.Triang(0, 4, 5);
        assertEquals(INVALID, result, "Zero side length should be invalid");
    }

    @Test
    void testInvalidTriangle_TriangleInequality() {
        int result = Trityp.Triang(1, 2, 3);
        assertEquals(INVALID, result, "Does not satisfy triangle inequality should be invalid");
    }

    @Test
    void testInvalidTriangle_TriangleInequality_AllSides() {
        int result = Trityp.Triang(10, 1, 1);
        assertEquals(INVALID, result, "Does not satisfy triangle inequality should be invalid");
    }

    @Test
    void testLargeValidTriangle() {
        int result = Trityp.Triang(1000, 1001, 1002);
        assertEquals(SCALENE, result, "Large scalene triangle should be valid");
    }

    @Test
    void testLargeEquilateralTriangle() {
        int side = 1000;
        int result = Trityp.Triang(side, side, side);
        assertEquals(EQUILATERAL, result, "Large equilateral triangle should be valid");
    }
}