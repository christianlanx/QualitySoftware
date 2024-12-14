package trityp.gpto1Mini.grey;

import trityp.Trityp;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TritypTest {

    @Test
    void testEquilateral() {
        int result = Trityp.Triang(5, 5, 5);
        assertEquals(3, result, "Should be equilateral");
    }

    @Test
    void testIsoscelesFirstTwoEqual() {
        int result = Trityp.Triang(5, 5, 3);
        assertEquals(2, result, "Should be isosceles");
    }

    @Test
    void testIsoscelesFirstAndThirdEqual() {
        int result = Trityp.Triang(5, 3, 5);
        assertEquals(2, result, "Should be isosceles");
    }

    @Test
    void testIsoscelesLastTwoEqual() {
        int result = Trityp.Triang(3, 5, 5);
        assertEquals(2, result, "Should be isosceles");
    }

    @Test
    void testScalene() {
        int result = Trityp.Triang(4, 5, 6);
        assertEquals(1, result, "Should be scalene");
    }

    @Test
    void testInvalidNegativeSides() {
        int result = Trityp.Triang(-1, 5, 5);
        assertEquals(4, result, "Should be invalid");
    }

    @Test
    void testInvalidZeroSide() {
        int result = Trityp.Triang(0, 5, 5);
        assertEquals(4, result, "Should be invalid");
    }

    @Test
    void testInvalidTriangleInequality1() {
        int result = Trityp.Triang(1, 2, 3);
        assertEquals(4, result, "Should be invalid");
    }

    @Test
    void testInvalidTriangleInequality2() {
        int result = Trityp.Triang(10, 1, 1);
        assertEquals(4, result, "Should be invalid");
    }

    @Test
    void testLargeNumbersValidScalene() {
        int result = Trityp.Triang(1000, 1001, 1002);
        assertEquals(1, result, "Should be scalene");
    }

    @Test
    void testLargeNumbersInvalid() {
        int result = Trityp.Triang(1000, 1, 1);
        assertEquals(4, result, "Should be invalid");
    }

    @Test
    void testAllSidesZero() {
        int result = Trityp.Triang(0, 0, 0);
        assertEquals(4, result, "Should be invalid");
    }

    @Test
    void testTwoSidesZero() {
        int result = Trityp.Triang(0, 5, 5);
        assertEquals(4, result, "Should be invalid");
    }

    @Test
    void testOneSideZero() {
        int result = Trityp.Triang(0, 0, 5);
        assertEquals(4, result, "Should be invalid");
    }
}