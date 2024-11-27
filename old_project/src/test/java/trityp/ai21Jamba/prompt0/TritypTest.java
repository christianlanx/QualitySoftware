package trityp.ai21Jamba.prompt0;
import trityp.Trityp;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TritypTest {

    @Test
    public void testTriang() {
        Trityp trityp = new Trityp();

        // Test case 1: Scalene triangle
        assertEquals(1, Trityp.Triang(3, 4, 5));

        // Test case 2: Isosceles triangle
        assertEquals(2, Trityp.Triang(4, 4, 5));

        // Test case 3: Equilateral triangle
        assertEquals(3, Trityp.Triang(4, 4, 4));

        // Test case 4: Invalid triangle due to zero side
        assertEquals(4, Trityp.Triang(0, 4, 5));

        // Test case 5: Invalid triangle due to negative side
        assertEquals(4, Trityp.Triang(-1, 4, 5));

        // Test case 6: Invalid triangle due to violation of triangle inequality theorem
        assertEquals(4, Trityp.Triang(1, 1, 3));

        // Test case 7: Isosceles triangle with different side order
        assertEquals(2, Trityp.Triang(5, 4, 4));

        // Test case 8: Equilateral triangle with different side order
        assertEquals(3, Trityp.Triang(4, 4, 4));

        // Test case 9: Scalene triangle with different side order
        assertEquals(1, Trityp.Triang(5, 3, 4));

        // Test case 10: Invalid triangle with sides that don't form a triangle
        assertEquals(4, Trityp.Triang(1, 2, 3));
    }
}