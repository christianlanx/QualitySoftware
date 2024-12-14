package RegularExpressionMatching.ai21Jamba15Large.grey;

import RegularExpressionMatching.Regular;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RegularExpressionMatchingTest {

    private final Regular regular = new Regular();

    @Test
    void testExample1() {
        String s = "aa";
        String p = "a";
        boolean expected = false;
        assertEquals(expected, regular.isMatch(s, p));
    }

    @Test
    void testExample2() {
        String s = "aa";
        String p = "a*";
        boolean expected = true;
        assertEquals(expected, regular.isMatch(s, p));
    }

    @Test
    void testExample3() {
        String s = "ab";
        String p = ".*";
        boolean expected = true;
        assertEquals(expected, regular.isMatch(s, p));
    }

    @Test
    void testSingleCharacter() {
        String s = "a";
        String p = "a";
        boolean expected = true;
        assertEquals(expected, regular.isMatch(s, p));
    }

    @Test
    void testSingleCharacterWithDot() {
        String s = "a";
        String p = ".";
        boolean expected = true;
        assertEquals(expected, regular.isMatch(s, p));
    }

    @Test
    void testSingleCharacterWithStar() {
        String s = "a";
        String p = "a*";
        boolean expected = true;
        assertEquals(expected, regular.isMatch(s, p));
    }

    @Test
    void testMultipleCharacters() {
        String s = "abcd";
        String p = "abcd";
        boolean expected = true;
        assertEquals(expected, regular.isMatch(s, p));
    }

    @Test
    void testMultipleCharactersWithDot() {
        String s = "abcd";
        String p = "a.cd";
        boolean expected = true;
        assertEquals(expected, regular.isMatch(s, p));
    }

    @Test
    void testMultipleCharactersWithStar() {
        String s = "abcd";
        String p = "a*b*c*d*";
        boolean expected = true;
        assertEquals(expected, regular.isMatch(s, p));
    }

    @Test
    void testEmptyString() {
        String s = "";
        String p = "";
        boolean expected = true;
        assertEquals(expected, regular.isMatch(s, p));
    }

    @Test
    void testEmptyPattern() {
        String s = "a";
        String p = "";
        boolean expected = false;
        assertEquals(expected, regular.isMatch(s, p));
    }

    @Test
    void testEmptyStringWithStar() {
        String s = "";
        String p = "a*";
        boolean expected = true;
        assertEquals(expected, regular.isMatch(s, p));
    }

    @Test
    void testComplexPattern() {
        String s = "aab";
        String p = "c*a*b";
        boolean expected = true;
        assertEquals(expected, regular.isMatch(s, p));
    }

    @Test
    void testComplexPatternWithDot() {
        String s = "aab";
        String p = "c*.a*b";
        boolean expected = true;
        assertEquals(expected, regular.isMatch(s, p));
    }

    @Test
    void testMismatch() {
        String s = "aab";
        String p = "a*b";
        boolean expected = false;
        assertEquals(expected, regular.isMatch(s, p));
    }

    @Test
    void testMismatchWithDot() {
        String s = "aab";
        String p = "a*.b";
        boolean expected = false;
        assertEquals(expected, regular.isMatch(s, p));
    }
}