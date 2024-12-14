package RegularExpressionMatching.gpt4oMini.black;

import org.junit.jupiter.api.Test;

import RegularExpressionMatching.Regular;

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
    void testStarMatching() {
        assertTrue(regular.isMatch("aa", "a*"));
        assertTrue(regular.isMatch("aab", "c*a*b"));
        assertFalse(regular.isMatch("mississippi", "mis*is*p*."));
        assertFalse(regular.isMatch("ab", ".*c"));
    }

    @Test
    void testDotStandingIn() {
        assertTrue(regular.isMatch("a", "."));
        assertTrue(regular.isMatch("abc", "a.c"));
        assertTrue(regular.isMatch("abcd", "a.d"));
        assertFalse(regular.isMatch("abcd", "a.."));
    }

    @Test
    void testComplexPatterns() {
        assertTrue(regular.isMatch("ab", ".*"));
        assertTrue(regular.isMatch("aaaa", "a*"));
        assertTrue(regular.isMatch("aa", "a*.*"));
        assertFalse(regular.isMatch("abc", "a.*b.*c.*d"));
    }

    @Test
    void testEdgeCases() {
        assertFalse(regular.isMatch("", "a"));
        assertTrue(regular.isMatch("", ".*"));
        assertFalse(regular.isMatch("", "a*"));
        assertTrue(regular.isMatch("abc", ""));
        assertTrue(regular.isMatch("", ""));
    }
}