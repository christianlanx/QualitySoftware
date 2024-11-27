package RegularExpressionMatching.claude35Sonnet.white;
import RegularExpressionMatching.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RegularTest {
    private Regular regular;

    @BeforeEach
    void setUp() {
        regular = new Regular();
    }

    @Test
    void testBasicMatching() {
        assertTrue(regular.isMatch("aa", "aa"));
        assertTrue(regular.isMatch("ab", "ab"));
        assertFalse(regular.isMatch("aa", "a"));
    }

    @Test
    void testDotOperator() {
        assertTrue(regular.isMatch("aa", "a."));
        assertTrue(regular.isMatch("ab", ".b"));
        assertTrue(regular.isMatch("abc", "..."));
        assertFalse(regular.isMatch("aa", "."));
    }

    @Test
    void testStarOperator() {
        assertTrue(regular.isMatch("aa", "a*"));
        assertTrue(regular.isMatch("aaa", "a*"));
        assertTrue(regular.isMatch("", "a*"));
        assertFalse(regular.isMatch("ab", "a*"));
    }

    @Test
    void testDotStarCombination() {
        assertTrue(regular.isMatch("ab", ".*"));
        assertTrue(regular.isMatch("abc", ".*"));
        assertTrue(regular.isMatch("", ".*"));
        assertTrue(regular.isMatch("aab", "c*a*b"));
    }

    @Test
    void testComplexPatterns() {
        assertTrue(regular.isMatch("aab", "c*a*b"));
        assertTrue(regular.isMatch("mississippi", "mis*is*ip*."));
        assertFalse(regular.isMatch("mississippi", "mis*is*p*."));
        assertTrue(regular.isMatch("aaa", "ab*ac*a"));
    }

    @Test
    void testEmptyStrings() {
        assertTrue(regular.isMatch("", ""));
        assertTrue(regular.isMatch("", "a*"));
        assertTrue(regular.isMatch("", ".*"));
        assertFalse(regular.isMatch("", "a"));
    }

    @Test
    void testLongStrings() {
        assertTrue(regular.isMatch("aaaaaaaa", "a*"));
        assertTrue(regular.isMatch("aaaaaaaa", ".*"));
        assertFalse(regular.isMatch("aaaaaaaa", "a*b"));
        assertTrue(regular.isMatch("aaabbbccc", "a*b*c*"));
    }

    @Test
    void testEdgeCases() {
        assertFalse(regular.isMatch("a", ""));
        assertFalse(regular.isMatch("a", "*"));
        assertTrue(regular.isMatch("a", "a*a"));
        assertFalse(regular.isMatch("ab", ".*c"));
    }
}