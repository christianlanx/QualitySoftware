package RegularExpressionMatching.ai21Jamba15Large.white;

import RegularExpressionMatching.Regular;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegularTest {

    private Regular regular = new Regular();

    @Test
    public void testIsMatch_EmptyStrings() {
        String s = "";
        String p = "";
        boolean expected = true;
        boolean actual = regular.isMatch(s, p);
        assertEquals(expected, actual);
    }

    @Test
    public void testIsMatch_SingleCharacterPattern() {
        String s = "a";
        String p = "a";
        boolean expected = true;
        boolean actual = regular.isMatch(s, p);
        assertEquals(expected, actual);
    }

    @Test
    public void testIsMatch_SingleCharacterPatternWithDot() {
        String s = "a";
        String p = ".";
        boolean expected = true;
        boolean actual = regular.isMatch(s, p);
        assertEquals(expected, actual);
    }

    @Test
    public void testIsMatch_SingleCharacterPatternWithMismatch() {
        String s = "a";
        String p = "b";
        boolean expected = false;
        boolean actual = regular.isMatch(s, p);
        assertEquals(expected, actual);
    }

    @Test
    public void testIsMatch_MultipleCharacterPattern() {
        String s = "abc";
        String p = "abc";
        boolean expected = true;
        boolean actual = regular.isMatch(s, p);
        assertEquals(expected, actual);
    }

    @Test
    public void testIsMatch_MultipleCharacterPatternWithDot() {
        String s = "abc";
        String p = "a.c";
        boolean expected = true;
        boolean actual = regular.isMatch(s, p);
        assertEquals(expected, actual);
    }

    @Test
    public void testIsMatch_MultipleCharacterPatternWithMismatch() {
        String s = "abc";
        String p = "abd";
        boolean expected = false;
        boolean actual = regular.isMatch(s, p);
        assertEquals(expected, actual);
    }

    @Test
    public void testIsMatch_PatternWithAsterisk() {
        String s = "aa";
        String p = "a*";
        boolean expected = true;
        boolean actual = regular.isMatch(s, p);
        assertEquals(expected, actual);
    }

    @Test
    public void testIsMatch_PatternWithAsteriskAndMismatch() {
        String s = "aa";
        String p = "a*b";
        boolean expected = false;
        boolean actual = regular.isMatch(s, p);
        assertEquals(expected, actual);
    }

    @Test
    public void testIsMatch_PatternWithAsteriskAndDot() {
        String s = "aa";
        String p = "a*.";
        boolean expected = true;
        boolean actual = regular.isMatch(s, p);
        assertEquals(expected, actual);
    }

    @Test
    public void testIsMatch_ComplexPattern() {
        String s = "abcd";
        String p = "a*b.c*d";
        boolean expected = true;
        boolean actual = regular.isMatch(s, p);
        assertEquals(expected, actual);
    }

    @Test
    public void testIsMatch_ComplexPatternWithMismatch() {
        String s = "abcd";
        String p = "a*b.c*e";
        boolean expected = false;
        boolean actual = regular.isMatch(s, p);
        assertEquals(expected, actual);
    }
}