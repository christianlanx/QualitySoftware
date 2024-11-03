package RegularExpressionMatching.claudeSonnet.prompt1;


import static org.junit.Assert.*;
import org.junit.Test;

import RegularExpressionMatching.Regular;

import org.junit.Before;

public class RegularExpressionMatchingclaudeSonnetTest {
    private Regular solution;

    @Before
    public void setUp() {
        solution = new Regular();
    }

    @Test
    public void testBasicMatching() {
        // Test exact matching
        assertTrue(solution.isMatch("a", "a"));
        assertFalse(solution.isMatch("aa", "a"));
        assertTrue(solution.isMatch("abc", "abc"));
    }

    @Test
    public void testDotOperator() {
        // Test single dot operator
        assertTrue(solution.isMatch("a", "."));
        assertTrue(solution.isMatch("b", "."));
        assertTrue(solution.isMatch("abc", "a.c"));
        assertFalse(solution.isMatch("abc", "a.d"));
    }

    @Test
    public void testStarOperator() {
        // Test star operator with letters
        assertTrue(solution.isMatch("aa", "a*"));
        assertTrue(solution.isMatch("aaa", "a*"));
        assertTrue(solution.isMatch("", "a*"));
        assertTrue(solution.isMatch("aab", "a*b"));
    }

    @Test
    public void testDotStarCombination() {
        // Test combination of dot and star
        assertTrue(solution.isMatch("abc", ".*"));
        assertTrue(solution.isMatch("abcd", ".*d"));
        assertTrue(solution.isMatch("", ".*"));
        assertTrue(solution.isMatch("abc", "a.*"));
    }

    @Test
    public void testComplexPatterns() {
        // Test more complex patterns
        assertTrue(solution.isMatch("aab", "c*a*b"));
        assertTrue(solution.isMatch("mississippi", "mis*is*ip*."));
        assertFalse(solution.isMatch("mississippi", "mis*is*p*."));
    }

    @Test
    public void testEmptyInputs() {
        // Test empty string cases
        assertTrue(solution.isMatch("", ""));
        assertFalse(solution.isMatch("", "a"));
        assertTrue(solution.isMatch("", "a*"));
        assertTrue(solution.isMatch("", ".*"));
    }

    @Test
    public void testMultipleStars() {
        // Test patterns with multiple stars
        assertTrue(solution.isMatch("aaa", "a*a*"));
        assertTrue(solution.isMatch("aaaa", "a*a*a*a"));
        assertTrue(solution.isMatch("aaab", "a*a*a*b"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidPattern() {
        // Test invalid pattern with * as first character
        solution.isMatch("abc", "*abc");
    }

    @Test
    public void testLongInputs() {
        // Test inputs at length constraints
        String longStr = "aaaaaaaaaaaaaaaaaaaa"; // 20 'a's
        String longPattern = "a*a*a*a*a*"; // Valid pattern
        assertTrue(solution.isMatch(longStr, longPattern));
    }

    @Test
    public void testAlternatingPatterns() {
        // Test patterns with alternating characters
        assertTrue(solution.isMatch("abababab", "ab*ab*ab*ab"));
        assertTrue(solution.isMatch("abababab", "(ab)*"));
        assertFalse(solution.isMatch("abababab", "ab*ab*ab*abc"));
    }

    @Test
    public void testExampleCases() {
        // Test the example cases from the problem description
        assertFalse(solution.isMatch("aa", "a"));
        assertTrue(solution.isMatch("aa", "a*"));
        assertTrue(solution.isMatch("ab", ".*"));
    }
}