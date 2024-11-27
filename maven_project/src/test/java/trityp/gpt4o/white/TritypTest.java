package trityp.gpt4o.white;
import trityp.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TritypTest {

    @Test
    public void testInvalidTriangleWithZeroSides() {
        assertEquals(4, Trityp.Triang(0, 0, 0));
    }

    @Test
    public void testInvalidTriangleWithNegativeSides() {
        assertEquals(4, Trityp.Triang(-1, 5, 7));
        assertEquals(4, Trityp.Triang(4, -2, 5));
        assertEquals(4, Trityp.Triang(3, 6, -3));
    }

    @Test
    public void testInvalidTriangleWithInequality() {
        assertEquals(4, Trityp.Triang(1, 2, 3));
        assertEquals(4, Trityp.Triang(7, 1, 2));
        assertEquals(4, Trityp.Triang(1, 9, 4));
    }

    @Test
    public void testScaleneTriangle() {
        assertEquals(1, Trityp.Triang(3, 4, 5));
        assertEquals(1, Trityp.Triang(6, 8, 10));
    }

    @Test
    public void testEquilateralTriangle() {
        assertEquals(3, Trityp.Triang(5, 5, 5));
        assertEquals(3, Trityp.Triang(10, 10, 10));
    }

    @Test
    public void testIsoscelesTriangle() {
        assertEquals(2, Trityp.Triang(5, 5, 8));
        assertEquals(2, Trityp.Triang(8, 5, 5));
        assertEquals(2, Trityp.Triang(5, 8, 5));
    }
}