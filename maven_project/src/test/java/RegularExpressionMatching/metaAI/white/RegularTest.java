package RegularExpressionMatching.metaAI.white;
import RegularExpressionMatching.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RegularTest {

    private Regular regular = new Regular();

    @Test
    public void testIsMatch_Example1() {
        String s = "aa";
        String p = "a";
        boolean expected = false;
        boolean actual = regular.isMatch(s, p);
        assertEquals(expected, actual);
    }

    @Test
    public void testIsMatch_Example2() {
        String s = "aa";
        String p = "a*";
        boolean expected = true;
        boolean actual = regular.isMatch(s, p);
        assertEquals(expected, actual);
    }

    @Test
    public void testIsMatch_Example3() {
        String s = "ab";
        String p = ".*";
        boolean expected = true;
        boolean actual = regular.isMatch(s, p);
        assertEquals(expected, actual);
    }

    @Test
    public void testIsMatch_EmptyString() {
        String s = "";
        String p = "";
        boolean expected = true;
        boolean actual = regular.isMatch(s, p);
        assertEquals(expected, actual);
    }

    @Test
    public void testIsMatch_EmptyPattern() {
        String s = "ab";
        String p = "";
        boolean expected = false;
        boolean actual = regular.isMatch(s, p);
        assertEquals(expected, actual);
    }

    @Test
    public void testIsMatch_DotMatchesAnyCharacter() {
        String s = "ab";
        String p = "a.";
        boolean expected = true;
        boolean actual = regular.isMatch(s, p);
        assertEquals(expected, actual);
    }

    @Test
    public void testIsMatch_StarMatchesZeroOrMore() {
        String s = "aaa";
        String p = "a*";
        boolean expected = true;
        boolean actual = regular.isMatch(s, p);
        assertEquals(expected, actual);
    }

    @Test
    public void testIsMatch_StarMatchesOneOrMore() {
        String s = "ab";
        String p = "a*b";
        boolean expected = true;
        boolean actual = regular.isMatch(s, p);
        assertEquals(expected, actual);
    }
}