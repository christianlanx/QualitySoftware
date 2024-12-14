package trityp.gpt35Turbo.grey;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TritypTest {

    private Trityp trityp;

    @BeforeEach
    void setUp() {
        trityp = new Trityp();
    }

    @Test
    void testScaleneTriangle() {
        assertEquals(1, trityp.Triang(3, 4, 5));
    }

    @Test
    void testIsoscelesTriangle() {
        assertEquals(2, trityp.Triang(5, 5, 7));
    }

    @Test
    void testEquilateralTriangle() {
        assertEquals(3, trityp.Triang(6, 6, 6));
    }

    @Test
    void testInvalidTriangle() {
        assertEquals(4, trityp.Triang(0, 5, 5));
    }
}