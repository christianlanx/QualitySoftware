package trityp;

import org.junit.Test;
import static org.junit.Assert.*;

public class TritypTestChatGPTo1Preview {

    // Test case 1: Negative side length
    @Test
    public void testNegativeSide() {
        assertEquals(4, Trityp.Triang(-1, 1, 1));
    }

    // Test case 2: Zero side length
    @Test
    public void testZeroSide() {
        assertEquals(4, Trityp.Triang(0, 1, 1));
    }

    // Test case 3: All sides equal (Equilateral triangle)
    @Test
    public void testEquilateralTriangle() {
        assertEquals(3, Trityp.Triang(2, 2, 2));
    }

    // Test case 4: Valid scalene triangle
    @Test
    public void testValidScaleneTriangle() {
        assertEquals(1, Trityp.Triang(3, 4, 5));
    }

    // Test case 5: Invalid scalene triangle (violates triangle inequality)
    @Test
    public void testInvalidScaleneTriangle() {
        assertEquals(4, Trityp.Triang(1, 2, 3));
    }

    // Test case 6: Valid isosceles triangle where Side1 == Side2
    @Test
    public void testValidIsoscelesTriangle_Side1EqualsSide2() {
        assertEquals(2, Trityp.Triang(2, 2, 3));
    }

    // Test case 7: Invalid isosceles triangle where Side1 == Side2 (violates triangle inequality)
    @Test
    public void testInvalidIsoscelesTriangle_Side1EqualsSide2() {
        assertEquals(4, Trityp.Triang(2, 2, 5));
    }

    // Test case 8: Valid isosceles triangle where Side1 == Side3
    @Test
    public void testValidIsoscelesTriangle_Side1EqualsSide3() {
        assertEquals(2, Trityp.Triang(2, 3, 2));
    }

    // Test case 9: Invalid isosceles triangle where Side1 == Side3 (violates triangle inequality)
    @Test
    public void testInvalidIsoscelesTriangle_Side1EqualsSide3() {
        assertEquals(4, Trityp.Triang(2, 5, 2));
    }

    // Test case 10: Valid isosceles triangle where Side2 == Side3
    @Test
    public void testValidIsoscelesTriangle_Side2EqualsSide3() {
        assertEquals(2, Trityp.Triang(3, 2, 2));
    }

    // Test case 11: Invalid isosceles triangle where Side2 == Side3 (violates triangle inequality)
    @Test
    public void testInvalidIsoscelesTriangle_Side2EqualsSide3() {
        assertEquals(4, Trityp.Triang(5, 2, 2));
    }

    // Test case 12: Another equilateral triangle
    @Test
    public void testEquilateralTriangle_AllSidesEqual() {
        assertEquals(3, Trityp.Triang(1, 1, 1));
    }
}
