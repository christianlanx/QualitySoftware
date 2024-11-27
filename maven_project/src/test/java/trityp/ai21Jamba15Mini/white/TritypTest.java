package trityp.ai21Jamba15Mini.white;
import trityp.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TritypTest {

    @Test
    void testTriangValidScalene() {
        assertEquals(1, Trityp.Triang(3, 4, 5));
    }

    @Test
    void testTriangValidIsosceles() {
        assertEquals(2, Trityp.Triang(3, 3, 5));
        assertEquals(2, Trityp.Triang(4, 4, 5));
    }

    @Test
    void testTriangValidEquilateral() {
        assertEquals(3, Trityp.Triang(3, 3, 3));
    }

    @Test
    void testTriangInvalidSideNegative() {
        assertEquals(4, Trityp.Triang(3, 4, -5));
    }

    @Test
    void testTriangInvalidSideZero() {
        assertEquals(4, Trityp.Triang(3, 0, 5));
    }

    @Test
    void testTriangInvalidSideZero2() {
        assertEquals(4, Trityp.Triang(0, 4, 5));
    }

    @Test
    void testTriangInvalidSideZero3() {
        assertEquals(4, Trityp.Triang(3, 4, 0));
    }

    @Test
    void testTriangInvalidSumLessThanSumOfOtherTwo() {
        assertEquals(4, Trityp.Triang(1, 2, 5));
    }

    @Test
    void testTriangInvalidSumLessThanSumOfOtherTwo2() {
        assertEquals(4, Trityp.Triang(1, 5, 2));
    }

    @Test
    void testTriangInvalidSumLessThanSumOfOtherTwo3() {
        assertEquals(4, Trityp.Triang(2, 1, 5));
    }
}