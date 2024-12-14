package RegularExpressionMatching.gpt4oMini.grey;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RegularTest {

    private final Regular regular = new Regular();

    @Test
    public void testMatchBasicCases() {
        assertFalse(regular.isMatch("aa", "a"));
        assertTrue(regular.isMatch("aa", "a*"));
        assertTrue(regular.isMatch("ab", ".*"));
    }

    @Test
    public void testMatchWithDot() {
        assertTrue(regular.isMatch("a", "."));
        assertTrue(regular.isMatch("abcd", "a.b.d"));
        assertFalse(regular.isMatch("abcd", "a..d"));
    }

    @Test
    public void testMatchWithStar() {
        assertTrue(regular.isMatch("a", "a*"));
        assertTrue(regular.isMatch("aaa", "a*"));
        assertFalse(regular.isMatch("aab", "c*a*b"));
        assertTrue(regular.isMatch("abcd", ".*"));
    }

    @Test
    public void testMatchComplexPatterns() {
        assertTrue(regular.isMatch("mississippi", "mis*is*p*."));
        assertFalse(regular.isMatch("ab", ".*c"));
        assertTrue(regular.isMatch("aa", "a*"));
        assertFalse(regular.isMatch("ab", "."));
    }

    @Test
    public void testMatchEdgeCases() {
        assertTrue(regular.isMatch("", ""));
        assertTrue(regular.isMatch("", ".*"));
        assertFalse(regular.isMatch("", "a*"));
        assertFalse(regular.isMatch("a", ""));
        assertTrue(regular.isMatch("bbaaa", "b*a*"));
        assertFalse(regular.isMatch("b", "a*b*"));
    }

    @Test
    public void testMatchPatternLength() {
        // Test maximum length constraints
        assertTrue(regular.isMatch("a".repeat(20), "a*"));
        assertFalse(regular.isMatch("a".repeat(20), "a{19}"));
    }
}