package RegularExpressionMatching.ai21Jamba15Large.black;
import RegularExpressionMatching.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class RegularTest {

    private Regular regular = new Regular();

    @Test
    void testExample1() {
        String s = "aa";
        String p = "a";
        boolean expected = false;
        Assertions.assertEquals(expected, regular.isMatch(s, p));
    }

    @Test
    void testExample2() {
        String s = "aa";
        String p = "a*";
        boolean expected = true;
        Assertions.assertEquals(expected, regular.isMatch(s, p));
    }

    @Test
    void testExample3() {
        String s = "ab";
        String p = ".*";
        boolean expected = true;
        Assertions.assertEquals(expected, regular.isMatch(s, p));
    }

    @Test
    void testEmptyStringAndPattern() {
        String s = "";
        String p = "";
        boolean expected = true;
        Assertions.assertEquals(expected, regular.isMatch(s, p));
    }

    @Test
    void testSingleCharacterStringAndPattern() {
        String s = "a";
        String p = "a";
        boolean expected = true;
        Assertions.assertEquals(expected, regular.isMatch(s, p));
    }

    @Test
    void testSingleCharacterStringAndPatternWithDot() {
        String s = "a";
        String p = ".";
        boolean expected = true;
        Assertions.assertEquals(expected, regular.isMatch(s, p));
    }

    @Test
    void testSingleCharacterStringAndPatternWithAsterisk() {
        String s = "a";
        String p = "a*";
        boolean expected = true;
        Assertions.assertEquals(expected, regular.isMatch(s, p));
    }

    @Test
    void testMultipleCharacterStringAndPatternWithAsterisk() {
        String s = "ab";
        String p = "a*b";
        boolean expected = true;
        Assertions.assertEquals(expected, regular.isMatch(s, p));
    }

    @Test
    void testMultipleCharacterStringAndPatternWithDotAndAsterisk() {
        String s = "abc";
        String p = ".*";
        boolean expected = true;
        Assertions.assertEquals(expected, regular.isMatch(s, p));
    }

    @Test
    void testMultipleCharacterStringAndPatternWithDotAndAsterisk2() {
        String s = "aab";
        String p = "c*a*b";
        boolean expected = true;
        Assertions.assertEquals(expected, regular.isMatch(s, p));
    }

    @Test
    void testMultipleCharacterStringAndPatternWithDotAndAsterisk3() {
        String s = "mississippi";
        String p = "mis*is*p*.";
        boolean expected = false;
        Assertions.assertEquals(expected, regular.isMatch(s, p));
    }

    @Test
    void testMultipleCharacterStringAndPatternWithDotAndAsterisk4() {
        String s = "aaa";
        String p = "a*a";
        boolean expected = true;
        Assertions.assertEquals(expected, regular.isMatch(s, p));
    }

    @Test
    void testMultipleCharacterStringAndPatternWithDotAndAsterisk5() {
        String s = "aaaa";
        String p = "a*a*";
        boolean expected = true;
        Assertions.assertEquals(expected, regular.isMatch(s, p));
    }
}