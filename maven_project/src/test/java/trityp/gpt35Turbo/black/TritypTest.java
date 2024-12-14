package trityp.gpt35Turbo.black;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import trityp.Trityp;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test Trityp class")
class TritypTest {

    Trityp trityp;

    @BeforeEach
    void setUp() {
        trityp = new Trityp();
    }

    @Nested
    @DisplayName("Test Triang method")
    class TriangTests {

        @Test
        @DisplayName("Should return Equilateral for sides of the same length")
        void testEquilateralTriangle() {
            int result = Trityp.Triang(3, 3, 3);
            assertEquals(1, result);
        }

        @Test
        @DisplayName("Should return Isosceles for two sides of the same length")
        void testIsoscelesTriangle() {
            int result = Trityp.Triang(3, 3, 2);
            assertEquals(2, result);
        }

        @Test
        @DisplayName("Should return Scalene for all sides of different lengths")
        void testScaleneTriangle() {
            int result = Trityp.Triang(3, 4, 5);
            assertEquals(3, result);
        }

        @Test
        @DisplayName("Should return Invalid Triangle for non-positive side lengths")
        void testInvalidTriangle() {
            int result = Trityp.Triang(-1, 2, 3);
            assertEquals(4, result);
        }

        @Test
        @DisplayName("Should return Invalid Triangle for triangle inequality")
        void testInvalidTriangleInequality() {
            int result = Trityp.Triang(1, 2, 4);
            assertEquals(4, result);
        }
    }
}