package RegularExpressionMatching.gpt35Turbo.black;

import org.junit.jupiter.api.Test;

import RegularExpressionMatching.Regular;

import static org.junit.jupiter.api.Assertions.*;

public class RegularTest {

    @Test
    public void testIsMatch_Example1() {
        Regular regular = new Regular();
        assertFalse(regular.isMatch("aa", "a"));
    }

    @Test
    public void testIsMatch_Example2() {
        Regular regular = new Regular();
        assertTrue(regular.isMatch("aa", "a*"));
    }

    @Test
    public void testIsMatch_Example3() {
        Regular regular = new Regular();
        assertTrue(regular.isMatch("ab", ".*"));
    }

    // Add more test cases to cover different scenarios

}