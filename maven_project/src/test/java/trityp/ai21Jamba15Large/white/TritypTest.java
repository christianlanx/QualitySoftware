package trityp.ai21Jamba15Large.white;

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
    void testInvalid() {
        assertEquals(4, Trityp.Triang(1, 2, 3));
    }

    @Test
    void testNegativeSides() {
        assertEquals(4, Trityp.Triang(-1, 2, 3));
    }

    @Test
    void testZeroSides() {
        assertEquals(4, Trityp.Triang(0, 2, 3));
    }

    @Test
    void testAllSidesEqual() {
        assertEquals(3, Trityp.Triang(5, 5, 5));
    }

    @Test
    void testTwoSidesEqual() {
        assertEquals(2, Trityp.Triang(5, 5, 6));
    }

    @Test
    void testSumOfTwoSidesLessThanThirdSide() {
        assertEquals(4, Trityp.Triang(1, 2, 4));
    }
}