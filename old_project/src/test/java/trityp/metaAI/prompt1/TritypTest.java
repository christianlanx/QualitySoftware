package trityp.metaAI.prompt1;
import trityp.Trityp;

import org.junit.Test;
import static org.junit.Assert.*;

public class TritypTest {

    @Test
    public void testScalene() {
        int side1 = 3;
        int side2 = 4;
        int side3 = 5;
        int expected = 1; // Scalene
        assertEquals(expected, Trityp.Triang(side1, side2, side3));
    }

    @Test
    public void testIsosceles() {
        int side1 = 3;
        int side2 = 3;
        int side3 = 4;
        int expected = 2; // Isosceles
        assertEquals(expected, Trityp.Triang(side1, side2, side3));
    }

    @Test
    public void testEquilateral() {
        int side1 = 3;
        int side2 = 3;
        int side3 = 3;
        int expected = 3; // Equilateral
        assertEquals(expected, Trityp.Triang(side1, side2, side3));
    }

    @Test
    public void testInvalidTriangle() {
        int side1 = 1;
        int side2 = 2;
        int side3 = 3;
        int expected = 0; // Invalid Triangle
        assertEquals(expected, Trityp.Triang(side1, side2, side3));
    }

    @Test
    public void testNonPositiveSide() {
        int side1 = -1;
        int side2 = 2;
        int side3 = 3;
        int expected = 0; // Invalid Triangle
        assertEquals(expected, Trityp.Triang(side1, side2, side3));
    }

    @Test
    public void testZeroSide() {
        int side1 = 0;
        int side2 = 2;
        int side3 = 3;
        int expected = 0; // Invalid Triangle
        assertEquals(expected, Trityp.Triang(side1, side2, side3));
    }
}