package RegularExpressionMatching.chatGPT4o.prompt0;

import RegularExpressionMatching.Regular;

import org.junit.Test;
import static org.junit.Assert.*;

public class RegularTest {

    @Test
    public void testExactMatch() {
        Regular regExMatcher = new Regular();
        assertTrue(regExMatcher.isMatch("abc", "abc"));
    }

    @Test
    public void testSingleCharacterWildcardMatch() {
        Regular regExMatcher = new Regular();
        assertTrue(regExMatcher.isMatch("abc", "a.c"));
    }

    @Test
    public void testStarWildcardZeroOccurrence() {
        Regular regExMatcher = new Regular();
        assertTrue(regExMatcher.isMatch("abc", "ab.*c"));
    }

    @Test
    public void testStarWildcardMultipleOccurrences() {
        Regular regExMatcher = new Regular();
        assertTrue(regExMatcher.isMatch("aaab", "a*b"));
    }

    @Test
    public void testEmptyPatternAndString() {
        Regular regExMatcher = new Regular();
        assertTrue(regExMatcher.isMatch("", ""));
    }

    @Test
    public void testEmptyStringWithStarPattern() {
        Regular regExMatcher = new Regular();
        assertTrue(regExMatcher.isMatch("", "a*"));
    }

    @Test
    public void testNoMatchDueToPatternMismatch() {
        Regular regExMatcher = new Regular();
        assertFalse(regExMatcher.isMatch("abc", "abd"));
    }

    @Test
    public void testPatternLongerThanString() {
        Regular regExMatcher = new Regular();
        assertFalse(regExMatcher.isMatch("a", "a*a*a*a*a*"));
    }

    @Test
    public void testComplexPattern() {
        Regular regExMatcher = new Regular();
        assertTrue(regExMatcher.isMatch("aab", "c*a*b"));
    }

    @Test
    public void testDotStarPattern() {
        Regular regExMatcher = new Regular();
        assertTrue(regExMatcher.isMatch("abcd", ".*"));
    }

    @Test
    public void testSingleDotPattern() {
        Regular regExMatcher = new Regular();
        assertFalse(regExMatcher.isMatch("abc", "."));
    }

    @Test
    public void testStarWithZeroOccurrences() {
        Regular regExMatcher = new Regular();
        assertTrue(regExMatcher.isMatch("abcd", "abcde*"));
    }

    @Test
    public void testTrailingStarWithCharacter() {
        Regular regExMatcher = new Regular();
        assertTrue(regExMatcher.isMatch("aaa", "a*a"));
    }

    @Test
    public void testLeadingStarWithCharacter() {
        Regular regExMatcher = new Regular();
        assertFalse(regExMatcher.isMatch("aaa", "*a"));
    }
}


