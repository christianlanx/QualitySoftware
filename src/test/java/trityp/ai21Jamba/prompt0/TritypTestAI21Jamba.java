package trityp.ai21Jamba.prompt0;

import org.junit.Test;

import trityp.Trityp;

import static org.junit.Assert.assertEquals;

public class TritypTestAI21Jamba {

    @Test
    public void testInvalidTriangleDueToNegativeSide() {
        assertEquals(4, Trityp.Triang(-1, 2, 3));
        assertEquals(4, Trityp.Triang(1, -2, 3));
        assertEquals(4, Trityp.Triang(1, 2, -3));
    }

    @Test
    public void testInvalidTriangleDueToZeroSide() {
        assertEquals(4, Trityp.Triang(0, 2, 3));
        assertEquals(4, Trityp.Triang(1, 0, 3));
        assertEquals(4, Trityp.Triang(1, 2, 0));
    }

    @Test
    public void testInvalidTriangleDueToSumCondition() {
        assertEquals(4, Trityp.Triang(1, 2, 3)); // Side1 + Side2 <= Side3
        assertEquals(4, Trityp.Triang(2, 3, 1)); // Side2 + Side3 <= Side1
        assertEquals(4, Trityp.Triang(3, 1, 2)); // Side1 + Side3 <= Side2
    }

    @Test
    public void testScaleneTriangle() {
        assertEquals(1, Trityp.Triang(3, 4, 5));
        assertEquals(1, Trityp.Triang(5, 6, 7));
    }

    @Test
    public void testEquilateralTriangle() {
        assertEquals(3, Trityp.Triang(3, 3, 3));
        assertEquals(3, Trityp.Triang(5, 5, 5));
    }

    @Test
    public void testIsoscelesTriangle() {
        assertEquals(2, Trityp.Triang(3, 3, 4)); // Side1 == Side2
        assertEquals(2, Trityp.Triang(3, 4, 3)); // Side1 == Side3
        assertEquals(2, Trityp.Triang(4, 3, 3)); // Side2 == Side3
    }
}