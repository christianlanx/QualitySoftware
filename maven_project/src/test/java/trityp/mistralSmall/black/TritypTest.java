package trityp.mistralSmall.black;
import trityp.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TritypTest {

    @Test
    public void testEquilateralTriangle() {
        assertEquals(1, Trityp.Triang(3, 3, 3));
    }

    @Test
    public void testIsoscelesTriangle() {
        assertEquals(2, Trityp.Triang(3, 3, 4));
    }

    @Test
    public void testScaleneTriangle() {
        assertEquals(3, Trityp.Triang(3, 4, 5));
    }

    @Test
    public void testInvalidTriangleNonPositive() {
        assertEquals(0, Trityp.Triang(-1, 2, 3));
    }

    @Test
    public void testInvalidTriangleNotSatisfyingInequality() {
        assertEquals(0, Trityp.Triang(1, 2, 3));
    }

    @Test
    public void testInvalidTriangleAllSidesSame() {
        assertEquals(0, Trityp.Triang(1, 1, 1));
    }

    @Test
    public void testInvalidTriangleOneSideZero() {
        assertEquals(0, Trityp.Triang(0, 2, 3));
    }

    @Test
    public void testInvalidTriangleTwoSidesEqual() {
        assertEquals(0, Trityp.Triang(1, 2, 2));
    }
}