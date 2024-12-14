package RegularExpressionMatching.gpt4o.grey;

import RegularExpressionMatching.Regular;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RegularTest {

    @Test
    void testSingleCharacterNoMatch() {
        Regular regular = new Regular();
        String s = "aa";
        String p = "a";
        assertFalse(regular.isMatch(s, p), "Expected no match for pattern 'a' with string 'aa'");
    }

    @Test
    void testRepeatingCharacterMatch() {
        Regular regular = new Regular();
        String s = "aa";
        String p = "a*";
        assertTrue(regular.isMatch(s, p), "Expected match for pattern 'a*' with string 'aa'");
    }

    @Test
    void testAnyCharacterMatch() {
        Regular regular = new Regular();
        String s = "ab";
        String p = ".*";
        assertTrue(regular.isMatch(s, p), "Expected match for pattern '.*' with string 'ab'");
    }

    @Test
    void testEmptyStringAndEmptyPattern() {
        Regular regular = new Regular();
        String s = "";
        String p = "";
        assertTrue(regular.isMatch(s, p), "Expected match for empty string and empty pattern");
    }

    @Test
    void testNonMatchingString() {
        Regular regular = new Regular();
        String s = "abcd";
        String p = "d*";
        assertFalse(regular.isMatch(s, p), "Expected no match for pattern 'd*' with string 'abcd'");
    }

    @Test
    void testComplexPatternMatch() {
        Regular regular = new Regular();
        String s = "aab";
        String p = "c*a*b";
        assertTrue(regular.isMatch(s, p), "Expected match for pattern 'c*a*b' with string 'aab'");
    }

    @Test
    void testComplexPatternNoMatch() {
        Regular regular = new Regular();
        String s = "mississippi";
        String p = "mis*is*p*.";
        assertFalse(regular.isMatch(s, p), "Expected no match for pattern 'mis*is*p*.' with string 'mississippi'");
    }

    @Test
    void testMatchWithDotStar() {
        Regular regular = new Regular();
        String s = "a";
        String p = ".*..";
        assertFalse(regular.isMatch(s, p), "Expected no match for pattern '.*..' with string 'a'");
    }

    @Test
    void testPatternWithMultipleStars() {
        Regular regular = new Regular();
        String s = "aaaa";
        String p = "a*a";
        assertFalse(regular.isMatch(s, p), "Expected no match for pattern 'a*a' with string 'aaaa'");
    }

    @Test
    void testPatternWithMultipleDots() {
        Regular regular = new Regular();
        String s = "abc";
        String p = "...";
        assertTrue(regular.isMatch(s, p), "Expected match for pattern '...' with string 'abc'");
    }
}