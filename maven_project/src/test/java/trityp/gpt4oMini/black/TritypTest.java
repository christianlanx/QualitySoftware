package trityp.gpt4oMini.black;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        assertEquals(1, Trityp.Triang(5, 4, 3));
        assertEquals(1, Trityp.Triang(7, 8, 9));
        assertEquals(1, Trityp.Triang(10, 6, 8));
    }

    @Test
    public void testInvalidTriangle() {
        assertEquals(0, Trityp.Triang(1, 2, 3)); // Fails triangle inequality
        assertEquals(0, Trityp.Triang(5, 10, 20)); // Fails triangle inequality
        assertEquals(0, Trityp.Triang(0, 5, 5)); // Non-positive length
        assertEquals(0, Trityp.Triang(5, -1, 5)); // Non-positive length
        assertEquals(0, Trityp.Triang(-1, -1, -1)); // All sides non-positive
    }
}