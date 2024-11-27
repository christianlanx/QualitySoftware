package RegularExpressionMatching.claude35Haiku.white;
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
    void testBasicMatch() {
        assertTrue(regular.isMatch("aa", "a*"));
        assertTrue(regular.isMatch("aa", "aa"));
        assertFalse(regular.isMatch("aa", "a"));
    }

    @Test
    void testDotMatch() {
        assertTrue(regular.isMatch("ab", ".*"));
        assertTrue(regular.isMatch("aab", "c*a*b"));
    }

    @Test
    void testZeroOrMoreMatches() {
        assertTrue(regular.isMatch("", "c*"));
        assertTrue(regular.isMatch("aaa", "a*"));
        assertFalse(regular.isMatch("mississippi", "mis*is*p*."));
    }

    @Test
    void testComplexPatterns() {
        assertTrue(regular.isMatch("aab", "c*a*b"));
        assertTrue(regular.isMatch("", ""));
        assertFalse(regular.isMatch("", ".*"));
    }

    @Test
    void testEdgeCases() {
        assertFalse(regular.isMatch("a", ""));
        assertTrue(regular.isMatch("", ".*"));
        assertTrue(regular.isMatch("a", ".*"));
    }

    @Test
    void testRepeatedCharacters() {
        assertTrue(regular.isMatch("aaaaaa", "a*"));
        assertTrue(regular.isMatch("aaabbbccc", ".*"));
        assertFalse(regular.isMatch("aaabbbccc", "a*b*d*"));
    }

    @Test
    void testMixedPatterns() {
        assertTrue(regular.isMatch("abcde", ".*"));
        assertTrue(regular.isMatch("abcde", "a.*e"));
        assertFalse(regular.isMatch("abcde", "a.*f"));
    }

    @Test
    void testSpecialCharacterPatterns() {
        assertTrue(regular.isMatch(".", "\\."));
        assertTrue(regular.isMatch("abc", "a.c"));
        assertFalse(regular.isMatch("abcd", "a.c"));
    }
}