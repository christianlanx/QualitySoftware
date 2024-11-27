package RegularExpressionMatching.mistralLarge.white;
import RegularExpressionMatching.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import RegularExpressionMatching.Regular;

class RegularTest {

    @Test
    void testIsMatch() {
        Regular regular = new Regular();

        assertTrue(regular.isMatch("aa", "a"));
        assertFalse(regular.isMatch("aa", "a*"));
        assertTrue(regular.isMatch("ab", ".*"));
        assertTrue(regular.isMatch("aab", "c*a*b"));
        assertFalse(regular.isMatch("mississippi", "mis*is*p*."));
        assertTrue(regular.isMatch("aaa", "a*a"));
        assertFalse(regular.isMatch("aaa", "a*"));
        assertFalse(regular.isMatch("aaa", "a*b"));
        assertFalse(regular.isMatch("aaa", "a*a*"));
        assertTrue(regular.isMatch("aaa", "a*aa"));
        assertFalse(regular.isMatch("aaa", "a*b*"));
        assertFalse(regular.isMatch("aaa", "a*b*a"));
        assertFalse(regular.isMatch("aaa", "a*b*a*"));
        assertFalse(regular.isMatch("aaa", "a*b*a*b*"));
        assertFalse(regular.isMatch("aaa", "a*b*a*b*c*"));
        assertFalse(regular.isMatch("aaa", "a*b*a*b*c*d*"));
        assertFalse(regular.isMatch("aaa", "a*b*a*b*c*d*e*"));
        assertTrue(regular.isMatch("aaa", "a*b*a*b*c*d*e*f*"));
    }
}