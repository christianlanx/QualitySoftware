package trityp.gpt35Turbo.white;
import trityp.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import trityp.Trityp;

public class TritypTest {

    @Test
    void testScaleneTriangle() {
        assertEquals(1, Trityp.Triang(3, 4, 5));
    }

    @Test
    void testIsoscelesTriangle() {
        assertEquals(2, Trityp.Triang(3, 3, 5));
    }
    
    @Test
    void testEquilateralTriangle() {
        assertEquals(3, Trityp.Triang(2, 2, 2));
    }
    
    @Test
    void testInvalidTriangle() {
        assertEquals(4, Trityp.Triang(1, 2, 3));
    }

    @Test
    void testInvalidSideLength() {
        assertEquals(4, Trityp.Triang(-1, 2, 3));
    }

}