package trityp.ai21Jamba15Large.grey;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import trityp.Trityp;

public class TritypTest {
    
    @Test
    void testScalene() {
        assertEquals(1, Trityp.Triang(3, 4, 5));
    }

    @Test
    void testIsosceles() {
        assertEquals(2, Trityp.Triang(3, 3, 4));
    }

    @Test
    void testEquilateral() {
        assertEquals(3, Trityp.Triang(4, 4, 4));
    }

    @Test
    void testInvalidTriangle() {
        assertEquals(4, Trityp.Triang(1, 2, 3));
        assertEquals(4, Trityp.Triang(0, 2, 3));
        assertEquals(4, Trityp.Triang(1, 0, 3));
        assertEquals(4, Trityp.Triang(1, 2, 0));
        assertEquals(4, Trityp.Triang(1, 2, 4));
    }
}