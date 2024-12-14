package trityp.gpt4o.white;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import trityp.Trityp;

public class TritypTest {

    @Test
    public void testInvalidTriangleWithZeroSides() {
        assertEquals(4, Trityp.Triang(0, 0, 0));
    }

    @Test
    public void testInvalidTriangleWithNegativeSides() {
        assertEquals(4, Trityp.Triang(-1, 2, 3));
        assertEquals(4, Trityp.Triang(3, -1, 2));
        assertEquals(4, Trityp.Triang(3, 2, -1));
    }

    @Test
    public void testInvalidTriangleWithSumOfTwoSidesEqualToThird() {
        assertEquals(4, Trityp.Triang(1, 2, 3));
        assertEquals(4, Trityp.Triang(2, 3, 1));
        assertEquals(4, Trityp.Triang(3, 1, 2));
    }

    @Test
    public void testScaleneTriangle() {
        assertEquals(1, Trityp.Triang(3, 4, 5));
    }

    @Test
    public void testEquilateralTriangle() {
        assertEquals(3, Trityp.Triang(5, 5, 5));
    }

    @Test
    public void testIsoscelesTriangle() {
        assertEquals(2, Trityp.Triang(5, 5, 3));
        assertEquals(2, Trityp.Triang(5, 3, 5));
        assertEquals(2, Trityp.Triang(3, 5, 5));
    }

    @Test
    public void testInvalidIsoscelesTriangle() {
        assertEquals(4, Trityp.Triang(5, 5, 10));
        assertEquals(4, Trityp.Triang(5, 10, 5));
        assertEquals(4, Trityp.Triang(10, 5, 5));
    }
}