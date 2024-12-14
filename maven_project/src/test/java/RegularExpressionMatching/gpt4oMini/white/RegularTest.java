package RegularExpressionMatching.gpt4oMini.white;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import RegularExpressionMatching.Regular;

import static org.junit.jupiter.api.Assertions.*;

class RegularTest {
    private Regular regular;

    @BeforeEach
    void setUp() {
        regular = new Regular();
    }

    @Test
    void testExactMatch() {
        assertTrue(regular.isMatch("abc", "abc"));
    }

    @Test
    void testMatchWithDot() {
        assertTrue(regular.isMatch("a", "."));
        assertTrue(regular.isMatch("abc", "a.c"));
    }

    @Test
    void testMatchWithStar() {
        assertTrue(regular.isMatch("aa", "a*"));
        assertTrue(regular.isMatch("ab", ".*"));
        assertTrue(regular.isMatch("aab", "c*a*b"));
    }

    @Test
    void testNonMatch() {
        assertFalse(regular.isMatch("mississippi", "mis*is*p*."));
        assertFalse(regular.isMatch("ab", ".*c"));
    }

    @Test
    void testEmptyStringMatch() {
        assertTrue(regular.isMatch("", ".*"));
        assertTrue(regular.isMatch("", ""));
        assertFalse(regular.isMatch("", "a"));
    }

    @Test
    void testPatternOnlyWithStar() {
        assertTrue(regular.isMatch("aa", "a*"));
        assertTrue(regular.isMatch("a", "a*"));
        assertFalse(regular.isMatch("b", "a*"));
    }

    @Test
    void testComplexPatterns() {
        assertTrue(regular.isMatch("abcd", "a.*d"));
        assertTrue(regular.isMatch("aaa", "a*a"));
        assertTrue(regular.isMatch("ab", ".*"));
    }

    @Test
    void testEdgeCases() {
        assertFalse(regular.isMatch("aaa", "a*a*a"));
        assertTrue(regular.isMatch("ab", "a*b*"));
        assertTrue(regular.isMatch("a", "a*b*"));
        assertFalse(regular.isMatch("b", "a*b*"));
    }
}