package trityp.gpt4oMini.grey;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TritypTest {

    @Test
    public void testScaleneTriangle() {
        assertEquals(1, Trityp.Triang(2, 3, 4));
        assertEquals(1, Trityp.Triang(5, 7, 6));
    }

    @Test
    public void testIsoscelesTriangle() {
        assertEquals(2, Trityp.Triang(3, 3, 4));
        assertEquals(2, Trityp.Triang(5, 5, 8));
        assertEquals(2, Trityp.Triang(7, 10, 7));
    }

    @Test
    public void testEquilateralTriangle() {
        assertEquals(3, Trityp.Triang(4, 4, 4));
        assertEquals(3, Trityp.Triang(10, 10, 10));
    }

    @Test
    public void testInvalidTriangle() {
        assertEquals(4, Trityp.Triang(1, 1, 3));
        assertEquals(4, Trityp.Triang(5, 2, 2));
        assertEquals(4, Trityp.Triang(0, 2, 2));
        assertEquals(4, Trityp.Triang(-1, 2, 2));
        assertEquals(4, Trityp.Triang(1, 2, -2));
        assertEquals(4, Trityp.Triang(0, 0, 0));
    }
}