package trityp.gpt4o.black;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import trityp.Trityp;

public class TritypTest {
    
    // Assuming return values for types are: 0 for Invalid, 1 for Scalene, 2 for Isosceles, 3 for Equilateral.

    @Test
    public void testEquilateralTriangle() {
        assertEquals(3, Trityp.Triang(3, 3, 3), "All sides equal should be Equilateral.");
    }

    @Test
    public void testIsoscelesTriangle() {
        assertEquals(2, Trityp.Triang(5, 5, 3), "Two sides equal should be Isosceles.");
        assertEquals(2, Trityp.Triang(5, 3, 5), "Two sides equal should be Isosceles.");
        assertEquals(2, Trityp.Triang(3, 5, 5), "Two sides equal should be Isosceles.");
    }

    @Test
    public void testScaleneTriangle() {
        assertEquals(1, Trityp.Triang(5, 4, 3), "All sides different should be Scalene.");
    }

    @Test
    public void testInvalidTriangleDueToInequality() {
        assertEquals(0, Trityp.Triang(1, 1, 3), "Sum of two sides less than third should be Invalid.");
        assertEquals(0, Trityp.Triang(3, 1, 1), "Sum of two sides less than third should be Invalid.");
        assertEquals(0, Trityp.Triang(1, 3, 1), "Sum of two sides less than third should be Invalid.");
    }

    @Test
    public void testInvalidTriangleDueToNonPositiveSides() {
        assertEquals(0, Trityp.Triang(0, 5, 5), "Zero side length should be Invalid.");
        assertEquals(0, Trityp.Triang(-3, 5, 5), "Negative side length should be Invalid.");
        assertEquals(0, Trityp.Triang(5, 0, 5), "Zero side length should be Invalid.");
        assertEquals(0, Trityp.Triang(5, 5, 0), "Zero side length should be Invalid.");
    }
}