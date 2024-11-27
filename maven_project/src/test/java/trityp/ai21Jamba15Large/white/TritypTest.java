package trityp.ai21Jamba15Large.white;
import trityp.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TritypTest {

    @Test
    void testScalene() {
        assertEquals(1, Trityp.Triang(3, 4, 5));
    }

    @Test
    void testIsosceles() {
        assertEquals(2, Trityp.Triang(4, 4, 5));
    }

    @Test
    void testEquilateral() {
        assertEquals(3, Trityp.Triang(5, 5, 5));
    }

    @Test
    void testInvalidTriangle() {
        assertEquals(4, Trityp.Triang(1, 2, 3));
    }

    @Test
    void testNegativeSide() {
        assertEquals(4, Trityp.Triang(3, -4, 5));
    }

    @Test
    void testZeroSide() {
        assertEquals(4, Trityp.Triang(0, 4, 5));
    }
}