package trityp.metaAI.white;
import trityp.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TritypTest {

    @Test
    public void testTriang_Equilateral() {
        int side1 = 5;
        int side2 = 5;
        int side3 = 5;
        int expected = 3; // Equilateral
        int actual = Trityp.Triang(side1, side2, side3);
        assertEquals(expected, actual);
    }

    @Test
    public void testTriang_Isosceles() {
        int side1 = 5;
        int side2 = 5;
        int side3 = 7;
        int expected = 2; // Isosceles
        int actual = Trityp.Triang(side1, side2, side3);
        assertEquals(expected, actual);
    }

    @Test
    public void testTriang_Scalene() {
        int side1 = 5;
        int side2 = 7;
        int side3 = 9;
        int expected = 1; // Scalene
        int actual = Trityp.Triang(side1, side2, side3);
        assertEquals(expected, actual);
    }

    @Test
    public void testTriang_InvalidTriangle_NonPositiveSide() {
        int side1 = 0;
        int side2 = 5;
        int side3 = 7;
        int expected = 4; // Invalid Triangle
        int actual = Trityp.Triang(side1, side2, side3);
        assertEquals(expected, actual);
    }

    @Test
    public void testTriang_InvalidTriangle_TriangleInequality() {
        int side1 = 1;
        int side2 = 5;
        int side3 = 7;
        int expected = 4; // Invalid Triangle
        int actual = Trityp.Triang(side1, side2, side3);
        assertEquals(expected, actual);
    }

    @Test
    public void testTriang_SidesWithSameLength() {
        int side1 = 5;
        int side2 = 5;
        int side3 = 5;
        int expected = 3; // Equilateral
        int actual = Trityp.Triang(side1, side2, side3);
        assertEquals(expected, actual);
    }

    @Test
    public void testTriang_TwoSidesWithSameLength() {
        int side1 = 5;
        int side2 = 5;
        int side3 = 7;
        int expected = 2; // Isosceles
        int actual = Trityp.Triang(side1, side2, side3);
        assertEquals(expected, actual);
    }
}