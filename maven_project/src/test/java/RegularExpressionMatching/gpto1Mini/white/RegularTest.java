package RegularExpressionMatching.gpto1Mini.white;

import RegularExpressionMatching.Regular;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RegularTest {

    private final Regular regular = new Regular();

    @Test
    void testBothEmptyStrings() {
        assertTrue(regular.isMatch("", ""), "Both input string and pattern are empty.");
    }

    @Test
    void testEmptyStringWithNonEmptyPattern() {
        assertFalse(regular.isMatch("", "a"), "Empty string with non-empty pattern without '*'.");
        assertTrue(regular.isMatch("", "a*"), "Empty string with pattern containing '*'.");
        assertTrue(regular.isMatch("", ".*"), "Empty string with pattern '.*'.");
    }

    @Test
    void testNonEmptyStringWithEmptyPattern() {
        assertFalse(regular.isMatch("a", ""), "Non-empty string with empty pattern.");
    }

    @Test
    void testExactMatch() {
        assertTrue(regular.isMatch("abc", "abc"), "Exact match without wildcards.");
    }

    @Test
    void testSingleCharacterWildcard() {
        assertTrue(regular.isMatch("a", "."), "Single character string with '.' wildcard.");
        assertFalse(regular.isMatch("ab", "."), "Multi-character string with single '.' wildcard.");
    }

    @Test
    void testStarWildcard() {
        assertTrue(regular.isMatch("aaa", "a*"), "Multiple characters with '*' wildcard.");
        assertTrue(regular.isMatch("aaab", "a*b"), "Multiple 'a's followed by 'b' with 'a*' wildcard.");
        assertFalse(regular.isMatch("aaab", "a*c"), "Mismatch with 'a*' wildcard followed by 'c'.");
    }

    @Test
    void testDotAndStarCombination() {
        assertTrue(regular.isMatch("ab", ".*"), "'.*' should match any string.");
        assertTrue(regular.isMatch("aab", "c*a*b"), "'c*a*b' should match 'aab'.");
        assertFalse(regular.isMatch("mississippi", "mis*is*p*."), "Complex pattern that should not match.");
    }

    @Test
    void testComplexPatterns() {
        assertTrue(regular.isMatch("aaa", "a.a"), "Pattern with '.' wildcard in the middle.");
        assertFalse(regular.isMatch("abcd", "d*"), "Pattern does not match the beginning of the string.");
        assertTrue(regular.isMatch("aab", "c*a*b"), "Pattern with multiple '*' wildcards.");
    }

    @Test
    void testEdgeCases() {
        assertTrue(regular.isMatch("a", "ab*"), "Pattern allows 'a' followed by zero 'b's.");
        assertFalse(regular.isMatch("a", "ab"), "Pattern expects 'a' followed by 'b'.");
        assertTrue(regular.isMatch("bbbba", ".*a*a"), "Complex pattern with multiple wildcards.");
    }
}