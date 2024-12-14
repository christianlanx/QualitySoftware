package RegularExpressionMatching.gpt35Turbo.grey;

import org.junit.jupiter.api.Test;

import RegularExpressionMatching.Regular;

import static org.junit.jupiter.api.Assertions.*;

public class RegularExpressionMatchingTest {

    Regular regular = new Regular();

    @Test
    void testExample1() {
        String s = "aa";
        String p = "a";
        assertFalse(regular.isMatch(s, p));
    }

    @Test
    void testExample2() {
        String s = "aa";
        String p = "a*";
        assertTrue(regular.isMatch(s, p));
    }

    @Test
    void testExample3() {
        String s = "ab";
        String p = ".*";
        assertTrue(regular.isMatch(s, p));
    }

    @Test
    void testEmptyString() {
        String s = "";
        String p = ".*";
        assertTrue(regular.isMatch(s, p));
    }

    @Test
    void testSameCharacters() {
        String s = "aaaaa";
        String p = "a*";
        assertTrue(regular.isMatch(s, p));
    }

    @Test
    void testNoMatch() {
        String s = "abcd";
        String p = "efgh";
        assertFalse(regular.isMatch(s, p));
    }

    @Test
    void testPatternWithDot() {
        String s = "abcdefg";
        String p = "..c..f.";
        assertTrue(regular.isMatch(s, p));
    }
}