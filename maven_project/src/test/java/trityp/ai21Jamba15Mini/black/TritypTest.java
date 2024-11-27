package trityp.ai21Jamba15Mini.black;
import trityp.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TritypTest {

    @Test
    void testScalene() {
        assertEquals(Trityp.Triang(3, 4, 5), 1);
    }

    @Test
    void testIsosceles() {
        assertEquals(Trityp.Triang(3, 3, 5), 2);
    }

    @Test
    void testEquilateral() {
        assertEquals(Trityp.Triang(3, 3, 3), 3);
    }

    @Test
    void testInvalidTriangle() {
        assertEquals(Trityp.Triang(1, 2, 3), 4);
    }

    @Test
    void testNonPositiveSide() {
        assertEquals(Trityp.Triang(0, 2, 3), 4);
    }

    @Test
    void testNegativeSide() {
        assertEquals(Trityp.Triang(-1, 2, 3), 4);
    }
}