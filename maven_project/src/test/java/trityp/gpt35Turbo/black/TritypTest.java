package trityp.gpt35Turbo.black;
import trityp.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TritypTest {

    @Test
    void testScaleneTriangle() {
        assertEquals(1, Trityp.Triang(3, 4, 5));
    }

    @Test
    void testIsoscelesTriangle() {
        assertEquals(2, Trityp.Triang(5, 5, 3));
    }

    @Test
    void testEquilateralTriangle() {
        assertEquals(3, Trityp.Triang(4, 4, 4));
    }

    @Test
    void testInvalidTriangle() {
        assertEquals(4, Trityp.Triang(1, 2, 3));
    }
}