package trityp.mistralSmall.white;
import trityp.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TritypTest {

    @Test
    public void testScaleneTriangle() {
        assertEquals(1, Trityp.Triang(3, 4, 5));
    }

    @Test
    public void testIsoscelesTriangle1() {
        assertEquals(2, Trityp.Triang(5, 5, 3));
    }

    @Test
    public void testIsoscelesTriangle2() {
        assertEquals(2, Trityp.Triang(4, 3, 4));
    }

    @Test
    public void testIsoscelesTriangle3() {
        assertEquals(2, Trityp.Triang(3, 4, 4));
    }

    @Test
    public void testEquilateralTriangle() {
        assertEquals(3, Trityp.Triang(6, 6, 6));
    }

    @Test
    public void testInvalidTriangleSideLessThanOrEqualToZero() {
        assertEquals(4, Trityp.Triang(0, 3, 4));
        assertEquals(4, Trityp.Triang(2, -1, 4));
        assertEquals(4, Trityp.Triang(3, 0, 4));
    }

    @Test
    public void testInvalidTriangleSumOfTwoSidesNotGreaterThanThird() {
        assertEquals(4, Trityp.Triang(1, 2, 3));
        assertEquals(4, Trityp.Triang(2, 3, 6));
        assertEquals(4, Trityp.Triang(3, 5, 10));
    }

    @Test
    public void testInvalidTriangleNonPositiveSides() {
        assertEquals(4, Trityp.Triang(-1, 2, 3));
        assertEquals(4, Trityp.Triang(1, -2, 3));
        assertEquals(4, Trityp.Triang(1, 2, -3));
    }

    @Test
    public void testInvalidTriangleSingleInvalidSide() {
        assertEquals(4, Trityp.Triang(1, 2, 3));
    }
}