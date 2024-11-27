package trityp.mistralLarge.white;
import trityp.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TritypTest {

    @Test
    void testScaleneTriangle() {
        assertEquals(1, Trityp.Triang(3, 4, 5));
        assertEquals(1, Trityp.Triang(7, 8, 9));
    }

    @Test
    void testIsoscelesTriangle() {
        assertEquals(2, Trityp.Triang(5, 5, 8));
        assertEquals(2, Trityp.Triang(6, 6, 9));
    }

    @Test
    void testEquilateralTriangle() {
        assertEquals(3, Trityp.Triang(5, 5, 5));
        assertEquals(3, Trityp.Triang(7, 7, 7));
    }

    @Test
    void testInvalidTriangle() {
        assertEquals(4, Trityp.Triang(0, 3, 4));
        assertEquals(4, Trityp.Triang(3, 4, -1));
        assertEquals(4, Trityp.Triang(1, 1, 2));
        assertEquals(4, Trityp.Triang(2, 2, 5));
    }

    @Test
    void testInvalidTriangleDueToTriangleInequality() {
        assertEquals(4, Trityp.Triang(1, 2, 3));
        assertEquals(4, Trityp.Triang(7, 1, 1));
    }

    @Test
    void testMixedValidAndInvalidTriangles() {
        assertEquals(1, Trityp.Triang(6, 8, 10));
        assertEquals(2, Trityp.Triang(10, 10, 15));
        assertEquals(4, Trityp.Triang(10, 20, 30));
    }
}