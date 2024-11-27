package trityp.gpt4oMini.white;
import trityp.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TritypTest {

    @Test
    public void testScaleneTriangle() {
        assertEquals(1, Trityp.Triang(3, 4, 5));
        assertEquals(1, Trityp.Triang(5, 4, 3));
        assertEquals(1, Trityp.Triang(6, 8, 10));
    }

    @Test
    public void testIsoscelesTriangle() {
        assertEquals(2, Trityp.Triang(5, 5, 3));
        assertEquals(2, Trityp.Triang(6, 6, 4));
        assertEquals(2, Trityp.Triang(7, 7, 10));
        assertEquals(2, Trityp.Triang(10, 10, 5));
    }

    @Test
    public void testEquilateralTriangle() {
        assertEquals(3, Trityp.Triang(2, 2, 2));
        assertEquals(3, Trityp.Triang(5, 5, 5));
    }

    @Test
    public void testInvalidTriangle() {
        assertEquals(4, Trityp.Triang(1, 2, 3)); // Not forming a triangle
        assertEquals(4, Trityp.Triang(5, 10, 20)); // Not forming a triangle
        assertEquals(4, Trityp.Triang(-1, 2, 3)); // Negative side
        assertEquals(4, Trityp.Triang(0, 0, 0)); // All sides zero
        assertEquals(4, Trityp.Triang(2, 2, 4)); // Not a valid triangle
    }

    @Test
    public void testZeroAndNegativeSides() {
        assertEquals(4, Trityp.Triang(0, 2, 3)); // One side zero
        assertEquals(4, Trityp.Triang(1, 0, 1)); // One side zero
        assertEquals(4, Trityp.Triang(1, 1, -1)); // Negative side
    }
}