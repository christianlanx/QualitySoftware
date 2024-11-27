package RegularExpressionMatching.claudeSonnet.prompt0;

import org.junit.Test;

import RegularExpressionMatching.Regular;

import org.junit.Before;
import static org.junit.Assert.*;

public class RegularTest {
    private Regular matcher;

    @Before
    public void setUp() {
        matcher = new Regular();
    }

    @Test
    public void testEmptyStringAndPattern() {
        assertTrue(matcher.isMatch("", ""));
        assertFalse(matcher.isMatch("", "a"));
        assertTrue(matcher.isMatch("", "a*"));
        assertTrue(matcher.isMatch("", ".*"));
    }

    @Test
    public void testBasicMatching() {
        assertTrue(matcher.isMatch("a", "a"));
        assertTrue(matcher.isMatch("ab", "ab"));
        assertFalse(matcher.isMatch("a", "b"));
        assertFalse(matcher.isMatch("ab", "ac"));
    }

    @Test
    public void testDotOperator() {
        assertTrue(matcher.isMatch("a", "."));
        assertTrue(matcher.isMatch("b", "."));
        assertTrue(matcher.isMatch("ab", ".."));
        assertFalse(matcher.isMatch("a", ".."));
    }

    @Test
    public void testStarOperator() {
        assertTrue(matcher.isMatch("", "a*"));
        assertTrue(matcher.isMatch("a", "a*"));
        assertTrue(matcher.isMatch("aa", "a*"));
        assertTrue(matcher.isMatch("aaa", "a*"));
        assertFalse(matcher.isMatch("b", "a*"));
    }

    @Test
    public void testDotStarCombination() {
        assertTrue(matcher.isMatch("", ".*"));
        assertTrue(matcher.isMatch("a", ".*"));
        assertTrue(matcher.isMatch("ab", ".*"));
        assertTrue(matcher.isMatch("abc", ".*"));
    }

    @Test
    public void testComplexPatterns() {
        assertTrue(matcher.isMatch("aab", "c*a*b"));
        assertTrue(matcher.isMatch("mississippi", "mis*is*ip*."));
        assertFalse(matcher.isMatch("mississippi", "mis*is*p*."));
        assertTrue(matcher.isMatch("ab", ".*.."));
        assertTrue(matcher.isMatch("aaa", "a*a"));
    }

    @Test
    public void testLongStrings() {
        assertTrue(matcher.isMatch("aaaaaaaa", "a*"));
        assertTrue(matcher.isMatch("aaaaaaaa", ".*"));
        assertTrue(matcher.isMatch("abcdefghijk", ".*k"));
        assertFalse(matcher.isMatch("abcdefghijk", ".*l"));
    }

    @Test
    public void testAlternatingPatterns() {
        assertTrue(matcher.isMatch("xaabyc", "xa*b.c"));
        assertTrue(matcher.isMatch("aaa", "ab*ac*a"));
        assertFalse(matcher.isMatch("aaa", "ab*ac*b"));
    }

    @Test
    public void testEdgeCases() {
        // Test pattern longer than string
        assertFalse(matcher.isMatch("a", "aaaa"));
        
        // Test consecutive stars
        assertTrue(matcher.isMatch("aaa", "a*a*a*"));
        
        // Test pattern with only stars
        assertTrue(matcher.isMatch("", "a*b*c*"));
        
        // Test dots and stars at the end
        assertTrue(matcher.isMatch("abcd", "abcd.*"));
        
        // Test pattern with multiple possibilities
        assertTrue(matcher.isMatch("abc", "a.*c"));
    }

    @Test
    public void testCornerCases() {
        // Test single character patterns
        assertTrue(matcher.isMatch("a", "a*"));
        assertTrue(matcher.isMatch("a", "."));
        
        // Test patterns ending with dot
        assertTrue(matcher.isMatch("ab", "ab."));
        
        // Test patterns starting with star (invalid in real regex but handled by this implementation)
        assertFalse(matcher.isMatch("aa", "*a"));
        
        // Test multiple dots
        assertTrue(matcher.isMatch("abc", "..."));
    }
}