package RegularExpressionMatching.gpto1Mini.grey;

import RegularExpressionMatching.Regular;
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
    void testExample1() {
        String s = "aa";
        String p = "a";
        boolean expected = false;
        assertEquals(expected, regular.isMatch(s, p), "Failed on input: s = \"aa\", p = \"a\"");
    }

    @Test
    void testExample2() {
        String s = "aa";
        String p = "a*";
        boolean expected = true;
        assertEquals(expected, regular.isMatch(s, p), "Failed on input: s = \"aa\", p = \"a*\"");
    }

    @Test
    void testExample3() {
        String s = "ab";
        String p = ".*";
        boolean expected = true;
        assertEquals(expected, regular.isMatch(s, p), "Failed on input: s = \"ab\", p = \".*\"");
    }

    @Test
    void testEmptyStringAndPattern() {
        String s = "";
        String p = "";
        boolean expected = true;
        assertEquals(expected, regular.isMatch(s, p), "Failed on input: s = \"\", p = \"\"");
    }

    @Test
    void testEmptyStringWithPatternAsterisk() {
        String s = "";
        String p = "a*";
        boolean expected = true;
        assertEquals(expected, regular.isMatch(s, p), "Failed on input: s = \"\", p = \"a*\"");
    }

    @Test
    void testSingleCharacterMatch() {
        String s = "a";
        String p = ".";
        boolean expected = true;
        assertEquals(expected, regular.isMatch(s, p), "Failed on input: s = \"a\", p = \".\"");
    }

    @Test
    void testNoMatchDueToExtraCharacters() {
        String s = "aab";
        String p = "c*a*b";
        boolean expected = true;
        assertEquals(expected, regular.isMatch(s, p), "Failed on input: s = \"aab\", p = \"c*a*b\"");
    }

    @Test
    void testComplexPatternMatch() {
        String s = "mississippi";
        String p = "mis*is*p*.";
        boolean expected = false;
        assertEquals(expected, regular.isMatch(s, p), "Failed on input: s = \"mississippi\", p = \"mis*is*p*.\"");
    }

    @Test
    void testPatternWithMultipleAsterisks() {
        String s = "aaa";
        String p = "a*a";
        boolean expected = true;
        assertEquals(expected, regular.isMatch(s, p), "Failed on input: s = \"aaa\", p = \"a*a\"");
    }

    @Test
    void testPatternWithDotAndAsterisk() {
        String s = "ab";
        String p = ".*c";
        boolean expected = false;
        assertEquals(expected, regular.isMatch(s, p), "Failed on input: s = \"ab\", p = \".*c\"");
    }
}