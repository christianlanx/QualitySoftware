package RegularExpressionMatching.gpto1Mini.black;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import RegularExpressionMatching.Regular;

public class RegularTest {

    @Test
    void testExample1() {
        Regular regular = new Regular();
        String s = "aa";
        String p = "a";
        boolean expected = false;
        assertEquals(expected, regular.isMatch(s, p), "Pattern 'a' should not match string 'aa'");
    }

    @Test
    void testExample2() {
        Regular regular = new Regular();
        String s = "aa";
        String p = "a*";
        boolean expected = true;
        assertEquals(expected, regular.isMatch(s, p), "Pattern 'a*' should match string 'aa'");
    }

    @Test
    void testExample3() {
        Regular regular = new Regular();
        String s = "ab";
        String p = ".*";
        boolean expected = true;
        assertEquals(expected, regular.isMatch(s, p), "Pattern '.*' should match string 'ab'");
    }

    @Test
    void testEmptyStringAndPattern() {
        Regular regular = new Regular();
        String s = "";
        String p = "";
        boolean expected = true;
        assertEquals(expected, regular.isMatch(s, p), "Empty pattern should match empty string");
    }

    @Test
    void testEmptyStringWithPattern() {
        Regular regular = new Regular();
        String s = "";
        String p = "a*";
        boolean expected = true;
        assertEquals(expected, regular.isMatch(s, p), "Pattern 'a*' should match empty string");
    }

    @Test
    void testNonMatchingPattern() {
        Regular regular = new Regular();
        String s = "abc";
        String p = "abd";
        boolean expected = false;
        assertEquals(expected, regular.isMatch(s, p), "Pattern 'abd' should not match string 'abc'");
    }

    @Test
    void testComplexPattern1() {
        Regular regular = new Regular();
        String s = "aab";
        String p = "c*a*b";
        boolean expected = true;
        assertEquals(expected, regular.isMatch(s, p), "Pattern 'c*a*b' should match string 'aab'");
    }

    @Test
    void testComplexPattern2() {
        Regular regular = new Regular();
        String s = "mississippi";
        String p = "mis*is*p*.";
        boolean expected = false;
        assertEquals(expected, regular.isMatch(s, p), "Pattern 'mis*is*p*.' should not match string 'mississippi'");
    }

    @Test
    void testSingleCharacterWithDot() {
        Regular regular = new Regular();
        String s = "a";
        String p = ".";
        boolean expected = true;
        assertEquals(expected, regular.isMatch(s, p), "Pattern '.' should match any single character");
    }

    @Test
    void testMultipleCharactersWithDot() {
        Regular regular = new Regular();
        String s = "abc";
        String p = "a.c";
        boolean expected = true;
        assertEquals(expected, regular.isMatch(s, p), "Pattern 'a.c' should match string 'abc'");
    }

    @Test
    void testStarWithDot() {
        Regular regular = new Regular();
        String s = "abbbb";
        String p = "ab*";
        boolean expected = true;
        assertEquals(expected, regular.isMatch(s, p), "Pattern 'ab*' should match string 'abbbb'");
    }
}