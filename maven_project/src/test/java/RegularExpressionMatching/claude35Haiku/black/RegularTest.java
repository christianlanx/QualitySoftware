package RegularExpressionMatching.claude35Haiku.black;
import RegularExpressionMatching.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RegularTest {
    private Regular regular = new Regular();

    @Test
    void testBasicMatch() {
        assertTrue(regular.isMatch("aa", "a*"));
        assertFalse(regular.isMatch("aa", "a"));
    }

    @Test
    void testDotMatching() {
        assertTrue(regular.isMatch("ab", ".*"));
        assertTrue(regular.isMatch("abc", "a.c"));
    }

    @Test
    void testZeroOrMoreMatching() {
        assertTrue(regular.isMatch("", "c*"));
        assertTrue(regular.isMatch("ccc", "c*"));
        assertFalse(regular.isMatch("abc", "c*"));
    }

    @Test
    void testComplexPatterns() {
        assertTrue(regular.isMatch("aab", "c*a*b"));
        assertTrue(regular.isMatch("mississippi", "mis*is*p*."));
    }

    @Test
    void testEdgeCases() {
        assertTrue(regular.isMatch("", ""));
        assertFalse(regular.isMatch("a", ""));
        assertTrue(regular.isMatch("a", "a"));
    }

    @Test
    void testWildcardCombinations() {
        assertTrue(regular.isMatch("abbbcd", "ab*c."));
        assertTrue(regular.isMatch("acd", "ab*c."));
        assertFalse(regular.isMatch("acd", "ab*d"));
    }

    @Test
    void testRepeatedCharacters() {
        assertTrue(regular.isMatch("aaa", "a*"));
        assertTrue(regular.isMatch("aaa", "a*a"));
        assertFalse(regular.isMatch("aaa", "a*b"));
    }

    @Test
    void testDotAndStarCombinations() {
        assertTrue(regular.isMatch("abcde", ".*"));
        assertTrue(regular.isMatch("abcde", "a.*e"));
        assertFalse(regular.isMatch("abcde", "a.*f"));
    }

    @Test
    void testConstraintLengthCases() {
        // Test cases near the length constraints (1-20 characters)
        assertTrue(regular.isMatch("a", "a"));
        assertTrue(regular.isMatch("aaaaaaaaaaaaaaaaaaa", "a*"));
        assertFalse(regular.isMatch("aaaaaaaaaaaaaaaaaaa", "b*"));
    }
}