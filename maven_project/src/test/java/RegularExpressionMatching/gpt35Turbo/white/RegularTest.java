package RegularExpressionMatching.gpt35Turbo.white;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import RegularExpressionMatching.Regular;

import static org.junit.jupiter.api.Assertions.*;

public class RegularTest {

    private Regular regular;

    @BeforeEach
    void setUp() {
        regular = new Regular();
    }

    @Test
    void testIsMatch_Example1() {
        String s = "aa";
        String p = "a";
        assertFalse(regular.isMatch(s, p));
    }

    @Test
    void testIsMatch_Example2() {
        String s = "aa";
        String p = "a*";
        assertTrue(regular.isMatch(s, p));
    }

    @Test
    void testIsMatch_Example3() {
        String s = "ab";
        String p = ".*";
        assertTrue(regular.isMatch(s, p));
    }

    @Test
    void testIsMatch_Example4() {
        String s = "aab";
        String p = "c*a*b";
        assertTrue(regular.isMatch(s, p));
    }

    @Test
    void testIsMatch_Example5() {
        String s = "mississippi";
        String p = "mis*is*p*.";
        assertFalse(regular.isMatch(s, p));
    }
    
    // Add more test cases to cover various scenarios
}