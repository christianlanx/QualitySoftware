package trityp.chatGPT4o.prompt0;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import trityp.Trityp;

public class TritypTestChatGPT4o {

    @Test
    public void testEquilateralTriangle() {
        // Test for an equilateral triangle (all sides are equal)
        assertEquals(3, Trityp.Triang(3, 3, 3));
    }

    @Test
    public void testIsoscelesTriangle() {
        // Test for an isosceles triangle (two sides are equal)
        assertEquals(2, Trityp.Triang(3, 3, 4));
        assertEquals(2, Trityp.Triang(4, 3, 4));
        assertEquals(2, Trityp.Triang(3, 4, 4));
    }

    @Test
    public void testScaleneTriangle() {
        // Test for a scalene triangle (no sides are equal)
        assertEquals(1, Trityp.Triang(3, 4, 5));
    }

    @Test
    public void testInvalidTriangle() {
        // Test for invalid triangles (side lengths that don't form a triangle)
        assertEquals(4, Trityp.Triang(0, 4, 5));  // Side length of 0
        assertEquals(4, Trityp.Triang(1, 2, 3));  // Sum of two sides is equal to the third
        assertEquals(4, Trityp.Triang(10, 1, 1)); // One side is larger than the sum of the other two
    }
}
