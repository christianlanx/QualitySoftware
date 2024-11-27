package trityp.ai21Jamba.prompt1;
import trityp.Trityp;

import org.junit.Assert;
import org.junit.Test;

public class TritypTest {

    // Test for an equilateral triangle
    @Test
    public void testEquilateralTriangle() {
        int result = Trityp.Triang(3, 3, 3);
        Assert.assertEquals(3, result);
    }

    // Test for an isosceles triangle
    @Test
    public void testIsoscelesTriangle() {
        int result = Trityp.Triang(4, 4, 5);
        Assert.assertEquals(2, result);
    }

    // Test for a scalene triangle
    @Test
    public void testScaleneTriangle() {
        int result = Trityp.Triang(3, 4, 5);
        Assert.assertEquals(1, result);
    }

    // Test for an invalid triangle due to non-positive side length
    @Test
    public void testInvalidTriangleNonPositiveSide() {
        int result = Trityp.Triang(3, 4, -1);
        Assert.assertEquals(0, result);
    }

    // Test for an invalid triangle due to violation of triangle inequality theorem
    @Test
    public void testInvalidTriangleViolation() {
        int result = Trityp.Triang(1, 2, 3);
        Assert.assertEquals(0, result);
    }

    // Test for another example of a scalene triangle
    @Test
    public void testScaleneTriangle2() {
        int result = Trityp.Triang(8, 9, 10);
        Assert.assertEquals(1, result);
    }

    // Test for another example of an isosceles triangle
    @Test
    public void testIsoscelesTriangle2() {
        int result = Trityp.Triang(7, 7, 8);
        Assert.assertEquals(2, result);
    }

    // Test for another example of an equilateral triangle
    @Test
    public void testEquilateralTriangle2() {
        int result = Trityp.Triang(5, 5, 5);
        Assert.assertEquals(3, result);
    }

    // Test for another example of an invalid triangle due to non-positive side length
    @Test
    public void testInvalidTriangleNonPositiveSide2() {
        int result = Trityp.Triang(0, 4, 5);
        Assert.assertEquals(0, result);
    }

    // Test for another example of an invalid triangle due to violation of triangle inequality theorem
    @Test
    public void testInvalidTriangleViolation2() {
        int result = Trityp.Triang(1, 1, 3);
        Assert.assertEquals(0, result);
    }
}