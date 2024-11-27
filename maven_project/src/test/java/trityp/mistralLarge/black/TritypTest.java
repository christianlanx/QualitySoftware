package trityp.mistralLarge.black;
import trityp.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TritypTest {

    @Test
    public void testEquilateralTriangle() {
        assertEquals(3, Trityp.Triang(3, 3, 3));
        assertEquals(3, Trityp.Triang(5, 5, 5));
    }

    @Test
    public void testIsoscelesTriangle() {
        assertEquals(2, Trityp.Triang(3, 3, 4));
        assertEquals(2, Trityp.Triang(4, 4, 3));
        assertEquals(2, Trityp.Triang(3, 4, 3));
    }

    @Test
    public void testScaleneTriangle() {
        assertEquals(1, Trityp.Triang(3, 4, 5));
        assertEquals(1, Trityp.Triang(7, 8, 9));
    }

    @Test
    public void testInvalidTriangle() {
        assertEquals(0, Trityp.Triang(1, 1, 2)); // Violates triangle inequality
        assertEquals(0, Trityp.Triang(0, 3, 3)); // Non-positive side length
        assertEquals(0, Trityp.Triang(-1, 3, 3)); // Negative side length
        assertEquals(0, Trityp.Triang(1, 2, 3)); // Violates triangle inequality
    }

    @Test
    public void testEdgeCases() {
        assertEquals(0, Trityp.Triang(0, 0, 0)); // All sides are zero
        assertEquals(0, Trityp.Triang(1, 1, 100)); // Violates triangle inequality
        assertEquals(3, Trityp.Triang(1, 1, 1)); // Smallest possible equilateral triangle
    }
}