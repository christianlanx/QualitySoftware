package RegularExpressionMatching.gpt4o.white;
import RegularExpressionMatching.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RegularTest {

    private final Regular regular = new Regular();

    @Test
    public void testExactMatch() {
        assertTrue(regular.isMatch("abc", "abc"), "Exact match should return true");
        assertFalse(regular.isMatch("abc", "abcd"), "Different strings should return false");
    }

    @Test
    public void testDotWildcard() {
        assertTrue(regular.isMatch("abc", "a.c"), "Dot wildcard should match any single character");
        assertFalse(regular.isMatch("abcd", "a.c"), "Dot wildcard should only match one character");
    }

    @Test
    public void testStarWildcard() {
        assertTrue(regular.isMatch("aa", "a*"), "Star wildcard should match zero or more of the preceding element");
        assertTrue(regular.isMatch("a", "a*"), "Star wildcard should match even if there's only one character");
        assertTrue(regular.isMatch("", "a*"), "Star wildcard should match zero occurrences");
    }

    @Test
    public void testDotAndStarWildcard() {
        assertTrue(regular.isMatch("ab", ".*"), "Dot and star wildcard combo should match any string");
        assertTrue(regular.isMatch("abc", ".*c"), "Dot and star wildcard should match any leading sequence");
        assertFalse(regular.isMatch("abcd", ".*c"), "Dot and star wildcard should not match non-matching suffix");
    }

    @Test
    public void testComplexPatterns() {
        assertTrue(regular.isMatch("aab", "c*a*b"), "Complex patterns with star should match according to rules");
        assertFalse(regular.isMatch("mississippi", "mis*is*p*."), "Complex patterns with multiple stars");
    }

    @Test
    public void testEdgeCases() {
        assertTrue(regular.isMatch("", ""), "Empty strings should return true");
        assertFalse(regular.isMatch("abc", ""), "Non-empty string with empty pattern should return false");
        assertTrue(regular.isMatch("", ".*"), "Empty string with wildcard pattern should return true");
    }
}