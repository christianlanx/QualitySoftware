package trityp.copilot.prompt0;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import trityp.Trityp;

public class TritypTestCopilot {

   @Test
   public void testInvalidTriangles() {
       assertEquals(4, Trityp.Triang(0, 5, 5));
       assertEquals(4, Trityp.Triang(-1, 5, 5));
       assertEquals(4, Trityp.Triang(5, 0, 5));
       assertEquals(4, Trityp.Triang(5, 5, 0));
       assertEquals(4, Trityp.Triang(1, 1, 3));
       assertEquals(4, Trityp.Triang(1, 3, 1));
       assertEquals(4, Trityp.Triang(3, 1, 1));
   }

   @Test
   public void testScaleneTriangles() {
       assertEquals(1, Trityp.Triang(3, 4, 5));
       assertEquals(1, Trityp.Triang(5, 4, 3));
       assertEquals(1, Trityp.Triang(7, 10, 5));
   }

   @Test
   public void testEquilateralTriangles() {
       assertEquals(3, Trityp.Triang(5, 5, 5));
       assertEquals(3, Trityp.Triang(10, 10, 10));
   }

   @Test
   public void testIsoscelesTriangles() {
       assertEquals(2, Trityp.Triang(5, 5, 3));
       assertEquals(2, Trityp.Triang(5, 3, 5));
       assertEquals(2, Trityp.Triang(3, 5, 5));
       assertEquals(2, Trityp.Triang(10, 10, 5));
   }
}
