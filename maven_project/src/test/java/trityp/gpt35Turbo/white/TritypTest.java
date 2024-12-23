package trityp.gpt35Turbo.white;

import trityp.Trityp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TritypTest {

    private Trityp trityp;

    @BeforeEach
    void setUp() {
        trityp = new Trityp();
    }

    @Test
    @DisplayName("Test for scalene triangle")
    void testScaleneTriangle() {
        assertEquals(1, trityp.Triang(3, 4, 5));
    }

    @Test
    @DisplayName("Test for isosceles triangle")
    void testIsoscelesTriangle() {
        assertEquals(2, trityp.Triang(3, 3, 5));
    }

    @Test
    @DisplayName("Test for equilateral triangle")
    void testEquilateralTriangle() {
        assertEquals(3, trityp.Triang(5, 5, 5));
    }

    @Test
    @DisplayName("Test for invalid triangle")
    void testInvalidTriangle() {
        assertEquals(4, trityp.Triang(0, 1, 2));
    }
}