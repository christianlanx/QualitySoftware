package trityp.gpt4oMini.black;
import trityp.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TritypTest {

    @Test
    public void testEquilateralTriangle() {
        assertEquals(3, Trityp.Triang(5, 5, 5));
    }

    @Test
    public void testIsoscelesTriangle() {
        assertEquals(2, Trityp.Triang(5, 5, 3));
        assertEquals(2, Trityp.Triang(3, 5, 5));
        assertEquals(2, Trityp.Triang(5, 3, 5));
    }

    @Test
    public void testScaleneTriangle() {
        assertEquals(1, Trityp.Triang(3, 4, 5));
        assertEquals(1, Trityp.Triang(5, 4, 3));
    }

    @Test
    public void testInvalidTriangle_NonPositiveSides() {
        assertEquals(0, Trityp.Triang(-1, 2, 2));
        assertEquals(0, Trityp.Triang(2, -2, 2));
        assertEquals(0, Trityp.Triang(2, 2, -2));
        assertEquals(0, Trityp.Triang(0, 2, 2));
    }

    @Test
    public void testInvalidTriangle_TriangleInequality() {
        assertEquals(0, Trityp.Triang(1, 1, 3)); // 1 + 1 <= 3
        assertEquals(0, Trityp.Triang(1, 2, 3)); // 1 + 2 <= 3
        assertEquals(0, Trityp.Triang(5, 3, 9)); // 5 + 3 <= 9
        assertEquals(0, Trityp.Triang(4, 1, 2)); // 1 + 2 <= 4
    }

    @Test
    public void testInvalidTriangle_AllSidesInvalid() {
        assertEquals(0, Trityp.Triang(-1, -1, -1));
        assertEquals(0, Trityp.Triang(0, 0, 0));
    }
}