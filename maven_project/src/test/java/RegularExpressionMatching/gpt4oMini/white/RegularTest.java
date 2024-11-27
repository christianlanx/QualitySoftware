package RegularExpressionMatching.gpt4oMini.white;
import RegularExpressionMatching.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RegularTest {
    private Regular regular;

    @BeforeEach
    public void setUp() {
        regular = new Regular();
    }

    @Test
    public void testExactMatch() {
        assertTrue(regular.isMatch("abc", "abc"));
    }

    @Test
    public void testDotMatchesAnyCharacter() {
        assertTrue(regular.isMatch("a", "."));
        assertTrue(regular.isMatch("b", "."));
        assertFalse(regular.isMatch("c", "."));
    }

    @Test
    public void testStarMatchesZeroOrMore() {
        assertTrue(regular.isMatch("aaa", "a*"));
        assertTrue(regular.isMatch("aa", "a*"));
        assertTrue(regular.isMatch("b", "a*b"));
        assertFalse(regular.isMatch("ab", ".*c"));
    }

    @Test
    public void testComplexPatterns() {
        assertTrue(regular.isMatch("mississippi", "mis*is*p*."));
        assertTrue(regular.isMatch("aab", "c*a*b"));
        assertFalse(regular.isMatch("ab", ".*c"));
    }

    @Test
    public void testEmptyStringPatterns() {
        assertTrue(regular.isMatch("", ""));
        assertTrue(regular.isMatch("", ".*"));
        assertFalse(regular.isMatch("", "a"));
        assertFalse(regular.isMatch("a", ""));
    }

    @Test
    public void testSpecialCharacterPatterns() {
        assertTrue(regular.isMatch("ab", ".*"));
        assertTrue(regular.isMatch("a", "a*"));
        assertFalse(regular.isMatch("aaa", "a.a"));
        assertTrue(regular.isMatch("a", "a.a"));
    }

    @Test
    public void testEdgeCasePatterns() {
        assertTrue(regular.isMatch("abc", ".*"));
        assertFalse(regular.isMatch("abc", "c*a*b"));
        assertTrue(regular.isMatch("ab", ".*b"));
        assertTrue(regular.isMatch("aab", "a*b"));
    }
}