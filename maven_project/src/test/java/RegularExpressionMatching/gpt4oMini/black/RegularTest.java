package RegularExpressionMatching.gpt4oMini.black;
import RegularExpressionMatching.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RegularTest {

    private final Regular regular = new Regular();

    @Test
    void testExactMatch() {
        assertFalse(regular.isMatch("aa", "a"));
        assertTrue(regular.isMatch("aa", "aa"));
        assertFalse(regular.isMatch("aaa", "aa"));
    }

    @Test
    void testStarMatch() {
        assertTrue(regular.isMatch("aa", "a*"));
        assertTrue(regular.isMatch("aaa", "a*"));
        assertTrue(regular.isMatch("ab", ".*"));
        assertFalse(regular.isMatch("aab", "c*a*b"));
        assertTrue(regular.isMatch("mississippi", "mis*is*p*."));
        assertTrue(regular.isMatch("a", ".*"));
        assertTrue(regular.isMatch("", ".*"));
    }

    @Test
    void testDotMatch() {
        assertTrue(regular.isMatch("abc", "a.c"));
        assertFalse(regular.isMatch("ab", ".*c"));
        assertTrue(regular.isMatch("aa", "a."));
        assertTrue(regular.isMatch("a", "."));
        assertFalse(regular.isMatch("a", ".."));
    }

    @Test
    void testMixedCases() {
        assertTrue(regular.isMatch("ab", ".*"));
        assertTrue(regular.isMatch("aab", "c*a*b"));
        assertFalse(regular.isMatch("abcde", ".*a"));
        assertTrue(regular.isMatch("abcde", "abcde"));
    }

    @Test
    void testEdgeCases() {
        assertFalse(regular.isMatch("", "a"));
        assertTrue(regular.isMatch("", ".*"));
        assertTrue(regular.isMatch("abc", ".*"));
        assertFalse(regular.isMatch("a", "b*"));
    }

    @Test
    void testMinimumInput() {
        assertTrue(regular.isMatch("a", "a"));
        assertFalse(regular.isMatch("a", "b"));
        assertTrue(regular.isMatch("a", "."));
        assertTrue(regular.isMatch("a", "a*"));
    }
}