package trityp.gpt4o.black;
import trityp.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TritypTest {

    @Test
    public void testEquilateralTriangle() {
        assertEquals(2, Trityp.Triang(3, 3, 3), "Expected Equilateral triangle");
    }

    @Test
    public void testIsoscelesTriangle() {
        assertEquals(1, Trityp.Triang(3, 3, 4), "Expected Isosceles triangle");
        assertEquals(1, Trityp.Triang(4, 3, 3), "Expected Isosceles triangle");
        assertEquals(1, Trityp.Triang(3, 4, 3), "Expected Isosceles triangle");
    }

    @Test
    public void testScaleneTriangle() {
        assertEquals(0, Trityp.Triang(3, 4, 5), "Expected Scalene triangle");
    }

    @Test
    public void testInvalidTriangle() {
        // Test with one or more non-positive sides
        assertEquals(-1, Trityp.Triang(0, 3, 3), "Expected Invalid triangle");
        assertEquals(-1, Trityp.Triang(-1, 3, 3), "Expected Invalid triangle");
        assertEquals(-1, Trityp.Triang(3, 0, 3), "Expected Invalid triangle");
        assertEquals(-1, Trityp.Triang(3, 3, 0), "Expected Invalid triangle");

        // Test with sides that do not satisfy the triangle inequality
        assertEquals(-1, Trityp.Triang(1, 2, 3), "Expected Invalid triangle");
        assertEquals(-1, Trityp.Triang(3, 1, 2), "Expected Invalid triangle");
        assertEquals(-1, Trityp.Triang(2, 3, 1), "Expected Invalid triangle");
    }
}