package trityp.gpt4oMini.white;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import trityp.Trityp;

public class TritypTest {

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
    public void testScaleneTriangle() {
        assertEquals(1, Trityp.Triang(3, 4, 5));
        assertEquals(1, Trityp.Triang(10, 15, 20));
    }

    @Test
    public void testInvalidTriangle() {
        assertEquals(4, Trityp.Triang(1, 2, 3)); // sum of two sides not greater than the third
        assertEquals(4, Trityp.Triang(1, 1, -1)); // negative side
        assertEquals(4, Trityp.Triang(0, 1, 1)); // zero side
        assertEquals(4, Trityp.Triang(-1, -1, -1)); // all negative sides
    }

    @Test
    public void testZeroAndNegativeSides() {
        assertEquals(4, Trityp.Triang(0, 2, 2));
        assertEquals(4, Trityp.Triang(2, 0, 2));
        assertEquals(4, Trityp.Triang(2, 2, 0));
        assertEquals(4, Trityp.Triang(-1, 1, 1));
        assertEquals(4, Trityp.Triang(1, -1, 1));
        assertEquals(4, Trityp.Triang(1, 1, -1));
    }
}